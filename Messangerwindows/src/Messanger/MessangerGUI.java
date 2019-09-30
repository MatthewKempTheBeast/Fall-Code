package Messanger;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JFrame;

import GUI2.*;
import GUI2.Drawable;

public class MessangerGUI extends JComponent{
	private static Timer timer = new Timer();
	//main window
	private static boolean shift;
	private static ArrayList<Drawable> buttons;
	private static int buttonspot;
	private static ArrayList<Drawable> lists;
	private static int listspot;
	private static ArrayList<Drawable> texts;
	private static boolean addGUI;
	private static ArrayList<Drawable> windows;
	private static int windowspot;
	private static int windowi;
	private static int windowj;
	//the stored messages
	private static ArrayList<StoredMessage> messages;
	//addguiwindow
	private static ArrayList<Drawable> addguibuttons;
	private static ArrayList<Drawable> addguilists;
	private static ArrayList<Drawable> addguitexts;
	//server
	private static ServerSocket server;
	private static Timer servertimer = new Timer();
	public void paintComponent(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		
		for(Drawable d: buttons) {
			d.drawSelf(g2);
		}
		for(Drawable d: lists) {
			d.drawSelf(g2);
		}
		for(Drawable d: texts) {
			d.drawSelf(g2);
		}
		for(Drawable d:windows) {
			d.drawSelf(g2);
		}
		if(addGUI) {
			for(Drawable d: addguitexts) {
				//System.out.println("TEXTS");
				//System.out.println(addguitexts.size());
				d.drawSelf(g2);
			}
			for(Drawable d: addguilists) {
				//System.out.println("DISPLAY");
				//System.out.println(addguilists.size());

				d.drawSelf(g2);
			}
			for(Drawable d: addguibuttons) {
				//System.out.println("BUTTONS");
				//System.out.println(addguibuttons.size());

				d.drawSelf(g2);
			}
		}
	}
	public static void Server() throws IOException {
		System.out.println("SERVER");
		Socket s = server.accept();
		System.out.println("SERVER ACCEPTED");
		InputStreamReader in1 = new InputStreamReader(s.getInputStream());
		BufferedReader bf1 = new BufferedReader(in1);
		String userpass = bf1.readLine();
		System.out.println(userpass);
		String ip = userpass.substring(0,userpass.indexOf(":"));
		for(int i = 0; i < ((Window)windows.get(0)).getTextBoxArray().size();i++) {
			if(ip.equals(((TextBox)(((Window)windows.get(0)).getTextBoxArray().get(i))).getText())) {
				for(int j = 0; j < messages.size();j++) {
					if(((Window)windows.get(0)).getTextBox(i).getText().equals(messages.get(j).getName())){
						messages.get(j).addTextBox(new TextBox(0,messages.get(j).getLowest()+60,200,60,userpass.substring(userpass.indexOf(":")+1,userpass.length()),Color.cyan,1));
						((Button)buttons.get(6)).contains(590,10);
					}
				}
			}
		}
	}
	public void setup() throws IOException {
		ArrayList<Drawable> buttons = new ArrayList<>();
		ArrayList<Drawable> lists = new ArrayList<>();
		ArrayList<Drawable> texts = new ArrayList<>();
		ArrayList<Drawable> windows = new ArrayList<>();
		ArrayList<Drawable> addguibuttons = new ArrayList<>();
		ArrayList<Drawable> addguilists = new ArrayList<>();
		ArrayList<Drawable> addguitexts = new ArrayList<>();
		//messages
		ArrayList<StoredMessage> messages = new ArrayList<>();
		ArrayList<Drawable> messagestextboxs = new ArrayList<>();
		messagestextboxs.add(new TextBox(180,0,200,100,"TEST",Color.blue,1));
		messages.add(new StoredMessage("",messagestextboxs));
		
		//primary gui
		//buttons
		buttons.add(new NewButton());
		buttons.add(new NewButton(125,0,0,3,"",1));
		buttons.add(new NewButton(150,0,1,3,"",2));
		buttons.add(new NewButton(175,0,2,3,"",3));
		buttons.add(new NewButton(575,575,0,5,"",4));

		//lists
		lists.add(new NewDisplay());
		lists.add(new NewDisplay(0,0,0,2,"",1));
		lists.add(new NewDisplay(200,575,0,4,"",2));
		//texts
		//windows
		ArrayList<ArrayList<Drawable>> temp = new ArrayList<ArrayList<Drawable>>();
		ArrayList<Drawable> tempbutton = new ArrayList<Drawable>();
		ArrayList<Drawable> templists = new ArrayList<Drawable>();
		ArrayList<Drawable> temptextbox = new ArrayList<Drawable>();
		//temptextbox.add(new TextBox(0,0,180,700,"test",Color.blue,1));
		temp.add(tempbutton);
		temp.add(templists);
		temp.add(temptextbox);
		windows.add(new Window(0,25,180,575,575,temp,1));
		buttons.add(new ScrollBar(180,25,575,2,1,(Window)windows.get(0),4));
		
		ArrayList<ArrayList<Drawable>> messageTemp = new ArrayList<ArrayList<Drawable>>();
		ArrayList<Drawable> tempbutton1 = new ArrayList<Drawable>();
		ArrayList<Drawable> templists1 = new ArrayList<Drawable>();
		ArrayList<Drawable> temptextbox1 = new ArrayList<Drawable>();
		temptextbox1.add(new TextBox(0,0,200,60,"Welcome to          P. Messanger.",Color.CYAN,1));
		temptextbox1.add(new TextBox(180,60,200,60,"Start sending       messages by",Color.blue,2));
		temptextbox1.add(new TextBox(180,120,200,60,"clicking the +       and entering",Color.blue,2));
		temptextbox1.add(new TextBox(0,180,200,60,"the local IPV4       address of the",Color.CYAN,1));
		temptextbox1.add(new TextBox(180,240,200,60,"machine you're     trying to talk with",Color.blue,2));



		messageTemp.add(tempbutton1);
		messageTemp.add(templists1);
		messageTemp.add(temptextbox1);
		windows.add(new Window(200,0,380,575,575,messageTemp,2));
		buttons.add(new ScrollBar(580,0,575,2,1,(Window)windows.get(1),5));
		
		//add gui
		addguibuttons.add(new NewButton(210,312,0,4,"new chat",1));
		addguilists.add(new NewDisplay(210,280,0,3,"",1));
		addguitexts.add(new TextBox(200,250,200,100,"add ipv4 address",Color.cyan,1));
		
		//server
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println(localhost.getHostAddress());
		ServerSocket ss = new ServerSocket();
		ss.bind(new InetSocketAddress(localhost.getHostAddress(),12903));
		//System.out.println(ss.getInetAddress(localhost.getHostAddress(),12903));
		this.buttons = buttons;
		this.buttonspot = 0;
		this.lists = lists;
		this.listspot = 0;
		this.texts = texts;
		this.windows = windows;
		this.windowspot = 0;
		this.windowi = 0;
		this.windowj = 0;
		this.messages = messages;
		this.timer = new Timer("Timer");
		this.addGUI = false;
		this.addguibuttons = addguibuttons;
		this.addguilists = addguilists;
		this.addguitexts = addguitexts;
		this.server = ss;
	}
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("Messanger");
		frame.setSize(618,635);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MessangerGUI m = new MessangerGUI();
		m.setup();
		frame.add(m);
		//30 frames per second
		TimerTask task = new TimerTask() {
	        public void run() {
	            frame.repaint();
	        }
	    };
	    long delay = 1000/30L;
	    timer.scheduleAtFixedRate(task,1000L,delay);
	    TimerTask ServerTask = new TimerTask() {
	    	public void run() {
	    		try {
					Server();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    };
	    long delay1 = 1000/30L;
	    servertimer.scheduleAtFixedRate(ServerTask,1000L,delay1);
		class RectClicker extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				if(!addGUI) {
					for(int i = 0;i<buttons.size();i++) {
						Button n = (Button)buttons.get(i);
						if(n.contains(e.getX(),e.getY()-25)) {
							n.click();
							buttonspot = i;
							if(n.getID()==2) {
								addGUI = true;
							}
							else if(n.getID()==4) {
								for(int j = 0; j < messages.size();j++) {
									if(((Window)windows.get(0)).getTextBox(windowj).getText().equals(((StoredMessage)messages.get(j)).getName())) {
										messages.get(j).addTextBox(new TextBox(180,messages.get(j).getLowest()+60,200,60,((NewDisplay)lists.get(2)).getText(),Color.blue,1));
										((Button)buttons.get(6)).contains(590,10);
										Socket connection = null;
										try {
											connection = new Socket(((StoredMessage)messages.get(j)).getName(),12903);
											System.out.println(((StoredMessage)messages.get(j)).getName());
											System.out.println(((StoredMessage)messages.get(j)).getName()+":"+((NewDisplay)lists.get(2)).getText());
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										PrintWriter pr = null;
										try {
											pr = new PrintWriter(connection.getOutputStream());
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										InetAddress localhost = null;
										try {
											localhost = InetAddress.getLocalHost();
										} catch (UnknownHostException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										pr.println(localhost.getHostAddress()+":"+((NewDisplay)lists.get(2)).getText());
										pr.flush();
									}
								}
							}
						}
					}
					for(int i = 0;i<lists.size();i++) {
						List n = (List)lists.get(i);
						if(n.contains(e.getX(),e.getY()-25)) {
							listspot = i;
						}
						n.scrollContains(e.getX(), e.getY()-25);
					}
					for(int i = 0; i < windows.size();i++) {
						Window n = (Window) windows.get(i);
						if(n.contains(e.getX(), e.getY()-25)) {
							System.out.println("window");

							windowspot = i;
							if(n.gfxContains(e.getX(), e.getY()-25)) {
								int[] pos = n.gfxGetContains(e.getX(), e.getY()-25);
								if(pos[0] == 0) {
									windowi = pos[0];
									windowj = pos[1];
									Button tempButton = (Button)(n.getGfxSpot(pos[0], pos[1]));
								}
								else if(pos[0] == 1) {
									windowi = pos[0];
									windowj = pos[1];
									List tempList = (List)(n.getGfxSpot(pos[0], pos[1]));
								}
								else if(pos[0] == 2) {
									//System.out.println("2");
									windowi = pos[0];
									windowj = pos[1];
									TextBox tempTextBox= (TextBox)(n.getGfxSpot(pos[0], pos[1]));
									n.unclickAll();
									tempTextBox.click();
									for(int j = 0; messages.size() > j;j++) {
										if(((StoredMessage)messages.get(j)).getName().equals(((Window)(windows.get(0))).getTextBox(windowj).getText())) {
											((Window)(windows.get(1))).setTextBox(messages.get(j).getTextBoxs());
											((Button)buttons.get(6)).contains(590,10);
										}
									}
								}
							}
						}
					}
				}
				else {
					for(int i = 0;i<addguibuttons.size();i++) {
						Button n = (Button)addguibuttons.get(i);
						if(n.contains(e.getX(),e.getY()-25)) {
							n.click();
							buttonspot = i;
							if(n.getID()==1) {
								((Window)(windows.get(0))).addText(new TextBox(0,0+60*(((Window)(windows.get(0))).getSize()),180,60,((NewDisplay)addguilists.get(0)).getText(),Color.blue,1));
								((Button)buttons.get(5)).contains(190,30);
								messages.add(new StoredMessage(((NewDisplay)addguilists.get(0)).getText()));
								addGUI = false;
							}
							
						}
					}
				}
				//frame.repaint();
			}
			public void mouseReleased(MouseEvent e) {
				Button n = (Button) buttons.get(buttonspot);
				n.click();
				n = (Button) addguibuttons.get(0);
				n.unclick();
				//frame.repaint();
				buttonspot = 0;
			}
		}
		class KeyEventDemo implements KeyListener{
			public void keyPressed(KeyEvent e) {
				if(!addGUI) {
					int key = e.getKeyCode();
					List n = (List) lists.get(listspot);
					if (key == KeyEvent.VK_DELETE || key == KeyEvent.VK_BACK_SPACE) {
						n.remove();
					}
					else if(key == KeyEvent.VK_ENTER) {
							n.enter();
					}
					else if(key == KeyEvent.VK_RIGHT) {
						n.right();
					}
					else if(key == KeyEvent.VK_LEFT) {
						n.left();
					}
					else if(key == KeyEvent.VK_SHIFT) {
						shift = true;
						System.out.println("shift pressed");
					}
					else {
						n.add(KeyText.whatKeyAllCapitalize(key,shift));
					}
				}
				else {
					int key = e.getKeyCode();
					List n = (List) addguilists.get(0);
					if (key == KeyEvent.VK_DELETE || key == KeyEvent.VK_BACK_SPACE) {
						n.remove();
					}
					else if(key == KeyEvent.VK_ENTER) {
							n.enter();
					}
					else if(key == KeyEvent.VK_RIGHT) {
						n.right();
					}
					else if(key == KeyEvent.VK_LEFT) {
						n.left();
					}
					else if(key == KeyEvent.VK_SHIFT) {
						shift = true;
						System.out.println("shift pressed");
					}
					else {
						n.add(KeyText.whatKeyAllCapitalize(key,shift));
					}
				}
				//frame.repaint();
			}
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_SHIFT) {
					shift = false;
					System.out.println("shift released");
				}
			}
			public void keyTyped(KeyEvent e) {
				
			}
		}
		RectClicker bbm = new RectClicker();
		frame.addMouseListener(bbm);
		frame.addMouseMotionListener(bbm);
		KeyEventDemo ked = new KeyEventDemo();
		frame.addKeyListener(ked);
		frame.setVisible(true);
	}
}
