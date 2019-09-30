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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JFrame;

import GUI2.*;
import GUI2.Drawable;

public class GUI extends JComponent{
	private static Timer timer = new Timer();
	private static boolean shift;
	private static ArrayList<Drawable> buttons;
	private static int buttonspot;
	private static ArrayList<Drawable> lists;
	private static int listspot;
	private static ArrayList<Drawable> texts;
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
	}
	public void setup() {
		ArrayList<Drawable> buttons = new ArrayList<>();
		ArrayList<Drawable> lists = new ArrayList<>();
		ArrayList<Drawable> texts = new ArrayList<>();
		//buttons
		buttons.add(new NewButton());
		buttons.add(new NewButton(0,50,0,1,"LOGIN",1));
		buttons.add(new NewButton(100,50,0,1,"CREATE",2));
		//lists
		lists.add(new NewDisplay());
		lists.add(new NewDisplay(75,0,0,2,"",1));
		lists.add(new NewDisplay(75,25,0,2,"",2));

		//texts
		texts.add(new TextBox(0,0,75,25,"USER:",Color.YELLOW,1));
		texts.add(new TextBox(0,25,75,25,"PASS:",Color.YELLOW,2));
		texts.add(new TextBox(0,75,200,25,"LOGIN TO ACCESS",Color.YELLOW,3));
		if(Login.testConnection("50.81.226.237", 12902)) {
			texts.add(new TextBox(0,100,200,25,"Connected",Color.blue,4));
		}
		else {
			texts.add(new TextBox(0,100,200,25,"Not Conntected",Color.blue,4));
		}
		this.buttons = buttons;
		this.buttonspot = 0;
		this.lists = lists;
		this.listspot = 0;
		this.texts = texts;
		this.timer = new Timer("Timer");
	}
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("LOGIN");
		frame.setSize(205,155);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI m = new GUI();
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
	    
		class RectClicker extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				for(int i = 0;i<buttons.size();i++) {
					Button n = (Button)buttons.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						n.click();
						buttonspot = i;
						if(n.getID()==1) {
							Login signin = null;
							try {
								signin = new Login("50.81.226.237", 12902);
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							try {
								if(signin.verifyCred(((NewDisplay)lists.get(1)).getText(),((NewDisplay)lists.get(2)).getText())) {
									MessangerGUI m = new MessangerGUI();
									m.main(args);
									frame.dispose(); // close window
									frame.setVisible(false);
								}
								else {
									((TextBox)texts.get(2)).setText("Incorrect User or Pass");
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						else if(n.getID() == 2) {
							Login signin = null;
							try {
								signin = new Login("50.81.226.237", 12902);
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							try {
								signin.create(((NewDisplay)lists.get(1)).getText(),((NewDisplay)lists.get(2)).getText());
								((TextBox)texts.get(2)).setText("New Account Created");
							} catch (IOException e1) {
								e1.printStackTrace();
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
				//frame.repaint();
			}
			public void mouseReleased(MouseEvent e) {
				Button n = (Button) buttons.get(buttonspot);
				n.click();
				//frame.repaint();
				buttonspot = 0;
			}
		}
		class KeyEventDemo implements KeyListener{
			public void keyPressed(KeyEvent e) {
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
