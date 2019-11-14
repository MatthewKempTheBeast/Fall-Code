
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JFrame;

import GUI2.*;

public class GUI extends JComponent{
	private static ArrayList<Drawable> buttons;
	private static int buttonspot;
	private static ArrayList<Drawable> lists;
	private static int listspot;
	private static boolean shift;
	private static boolean ctrl;
	private static Timer timer;
	public void paintComponent(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		for(Drawable d : buttons)
		{
			d.drawSelf(g2);
		}
		for(Drawable d : lists) {
			d.drawSelf(g2);
		}
	}
	public void setup() {
		ArrayList<Drawable> buttons = new ArrayList<Drawable>();
		ArrayList<Drawable> lists = new ArrayList<Drawable>();

		//buttons
		buttons.add(new NewButton());
		//lists
		lists.add(new NewList1(0,0,0,1,"CONVERTER A1",1,false));
		buttonspot = 0;
		this.buttons = buttons;
		listspot = 0;
		this.lists = lists;
		this.shift = false;
		this.ctrl = false;
	}
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("Converter");
		frame.setSize(600,650);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI m = new GUI();
		m.setup();
		frame.add(m);
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				frame.repaint();
			}
		},0,1000/60);
		class RectClicker extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				for(int i = 0;i<buttons.size();i++) {
					Button n = (Button)buttons.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						buttonspot = i;
					}
				}
			}
			public void mouseReleased(MouseEvent e) {
				Button n = (Button) buttons.get(buttonspot);
				n.click();
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
				else if(key == KeyEvent.VK_CONTROL) {
					ctrl = true;
					System.out.println("ctrl pressed");
				}
				else if(key == KeyEvent.VK_UP) {
					if(ctrl) {
						n.cup();
					}
					else {
						n.up();
					}
				}
				else if(key == KeyEvent.VK_DOWN) {
					if(ctrl) {
						n.cdown();
					}
					else {
						n.down();
					}
				}
				else {
					n.add(KeyText.whatKeyAllCapitalize(key,shift));
				}
			}
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_SHIFT) {
					shift = false;
					System.out.println("shift released");
				}
				else if(key == KeyEvent.VK_CONTROL) {
					ctrl = false;
					System.out.println("ctrl released");
				}
			}
			public void keyTyped(KeyEvent e) {
				
			}
		}
		RectClicker bbm = new RectClicker();
		frame.addMouseListener(bbm);
		frame.setVisible(true);
		KeyEventDemo ked = new KeyEventDemo();
		frame.addKeyListener(ked);
	}
}
