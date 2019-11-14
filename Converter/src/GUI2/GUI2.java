package GUI2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class GUI2 extends JComponent{
	BufferedImage image;
	BufferedImage image2;
	private static ArrayList<Drawable> buttons;
	private static int buttonspot;
	private static ArrayList<Drawable> lists;
	private static int listspot;
	private static ArrayList<Drawable> images;
	private static ArrayList<Drawable> windows;
	private static int windowspot;
	private static ArrayList<Drawable> old;
	
	private static boolean shift;
	public void paintComponent(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		g2.drawImage(image, 0, 0, null);
		g2.drawImage(image2,200,100,null);
		//old.get(0).drawSelf(g2);
		for(Drawable d : buttons)
		{
			d.drawSelf(g2);
		}
		for(Drawable d: lists) {
			d.drawSelf(g2);
		}
		for(Drawable d: images) {
			d.drawSelf(g2);
		}
		for(Drawable d: old) {
			d.drawSelf(g2);
		}
		for(Drawable d: windows) {
			d.drawSelf(g2);
		}
	}
	public void setup() throws IOException {
		//image = ImageIO.read(new File("/Users/maetkemp/Desktop/bobby.jpg"));
		//image2 = ImageIO.read(new File("/Users/maetkemp/Desktop/seethew.png"));
		ArrayList<Drawable> buttons = new ArrayList<Drawable>();
		ArrayList<Drawable> lists = new ArrayList<Drawable>();
		ArrayList<Drawable> images = new ArrayList<Drawable>();
		ArrayList<Drawable> windows = new ArrayList<Drawable>();
		ArrayList<Drawable> old = new ArrayList<Drawable>();
		//buttons
		buttons.add(new NewButton());
		buttons.add(new NewButton(0,50,0,1,"Test",1));
		buttons.add(new NewButton(0,75,0,1,"Hello",2));
		buttons.add(new NewButton(0,100,0,1,"Hello this is a test",3));
		buttons.add(new NewButton(0,125,0,2,"whats up",4));
		//buttons.add(new ScrollBar(400,0,200,1,1,null,5));
		//lists
		lists.add(new NewList());
		lists.add(new NewList(0,175,0,1,"Hello  this is a testttttttt",1,false));
		lists.add(new OldList(0,275,100,100,"whats up",2,Color.GRAY,false));
		//lists.add(new OldDisplay(100,300,100,50,"HELLO",Color.BLUE,2));
		lists.add(new NewDisplay(0,25,0,1,"",1));
		//lists.add(new TextBox(100,125,100,50,"Hello this is a test",Color.GREEN,1));
		//images
		images.add(new Image(100,100,0,0));
		//old
		old.add(new TextBox(300,325,200,100,"hello my name is matt and im really cool",Color.BLUE,1));
		//windows
		//ArrayList<Drawable> windowTemp = (ArrayList<Drawable>) buttons.clone();
		ArrayList<Drawable> windowButton = new ArrayList<Drawable>();
		windowButton.add(new NewButton());
		windowButton.add(new NewButton(0,0,0,1,"Test1",1));
		windowButton.add(new NewButton(0,25,0,1,"Test2",2));
		windowButton.add(new NewButton(0,50,0,1,"Test3",3));
		windowButton.add(new NewButton(0,75,0,1,"Test4",4));
		windowButton.add(new NewButton(0,100,0,1,"Test5",5));
		//windowTemp.add(new TextBox(0,125,100,50,"Hello this is a test",Color.GREEN,6));
		ArrayList<Drawable> windowList = new ArrayList<Drawable>();
		windowList.add(new NewDisplay(0,125,0,1,"Hello",6));
		ArrayList<ArrayList<Drawable>> windowTempTemp = new ArrayList<ArrayList<Drawable>>();
		windowTempTemp.add(windowButton);
		windowTempTemp.add(windowList);
		windows.add(new Window(600,400,100,100,200,windowTempTemp,0));
		//window scrollbar
		buttons.add(new ScrollBar(700,400,100,0,1,(Window)windows.get(0),6));
		//old list (mostly depricated) a lot of its broken 
		//old.add(new OldDisplay(100,300,100,50,"HELLO",Color.BLUE,2));
		this.buttons = buttons;
		this.buttonspot = 0;
		this.lists = lists;
		this.listspot = 0;
		this.images = images;
		this.windows = windows;
		this.windowspot = 0;
		this.old = old;
	}
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("Updated GUI");
		frame.setSize(1000,1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI2 m = new GUI2();
		m.setup();
		frame.add(m);
		class RectClicker extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				for(int i = 0;i<buttons.size();i++) {
					Button n = (Button)buttons.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						n.click();
						buttonspot = i;
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
					Window n = (Window)windows.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						windowspot = i;
					}
				}
				frame.repaint();
			}
			public void mouseReleased(MouseEvent e) {
				Button n = (Button) buttons.get(buttonspot);
				n.click();
				frame.repaint();
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
				frame.repaint();
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
