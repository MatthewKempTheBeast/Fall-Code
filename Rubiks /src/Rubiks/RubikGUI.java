package Rubiks;

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

import javax.swing.JComponent;
import javax.swing.JFrame;

import GUI2.*;

public class RubikGUI extends JComponent{

	private static ArrayList<Drawable> buttons;
	private static ArrayList<Drawable> gbuttons;
	private static ArrayList<Drawable> lists;
	private static int buttonspot;
	private static int gbuttonspot;
	private static int listspot;
	//rubiks blocks made from textboxs
	private static Cube rubixCube;
	private static int face;
	private static ArrayList<Drawable> rubiks;
	private static Image image;
	
	private static boolean shift = false;
	
	public void paintComponent(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		changeCube();
		for(Drawable d : buttons)
		{
			d.drawSelf(g2);
		}
		for(Drawable d: gbuttons) {
			d.drawSelf(g2);
		}
		for(Drawable d : rubiks) {
			d.drawSelf(g2);
		}
		for(Drawable d: lists) {
			d.drawSelf(g2);
		}
		image.drawSelf(g2);
		g2.drawString((face+1)+"", 295, 280);
		g2.drawString(rubixCube.rotateUp(face)+1+"",295,20);
		g2.drawString(rubixCube.rotateRight(face)+1+"",555,285);
		g2.drawString(rubixCube.rotateDown(face)+1+"",295,550);
		g2.drawString(rubixCube.rotateLeft(face)+1+"", 30,285);
	}
	public void changeCube() {
		rubiks = rubixCube.getFaceArray(face);
	}
	public void setup() {
		ArrayList<Drawable> buttons = new ArrayList<Drawable>();
		ArrayList<Drawable> gbuttons = new ArrayList<Drawable>();
		ArrayList<Drawable> rubiks = new ArrayList<Drawable>();
		ArrayList<Drawable> lists = new ArrayList<Drawable>();
		//buttons
		buttons.add(new NewButton());
		//up
		buttons.add(new NewButton(175,75,0,1,1));
		buttons.add(new NewButton(275,75,0,1,2));
		buttons.add(new NewButton(375,75,0,1,3));
		//right
		buttons.add(new NewButton(450,150,1,1,4));
		buttons.add(new NewButton(450,250,1,1,5));
		buttons.add(new NewButton(450,350,1,1,6));
		//bottom
		buttons.add(new NewButton(175,425,2,1,7));
		buttons.add(new NewButton(275,425,2,1,8));
		buttons.add(new NewButton(375,425,2,1,9));
		//left
		buttons.add(new NewButton(100,150,3,1,10));
		buttons.add(new NewButton(100,250,3,1,11));
		buttons.add(new NewButton(100,350,3,1,12));
		//face up
		buttons.add(new NewButton(275,25,0,1,13));
		//face right
		buttons.add(new NewButton(500,250,1,1,14));
		//face down
		buttons.add(new NewButton(275,475,2,1,15));
		//face left
		buttons.add(new NewButton(50,250,3,1,16));
		
		//gui buttons
		gbuttons.add(new NewButton());
		gbuttons.add(new NewButton(200,578,0,5,"E",1));
		gbuttons.add(new NewButton(250,578,0,6,"U",2));
		gbuttons.add(new NewButton(300,578,1,6,"L",3));
		gbuttons.add(new NewButton(350,578,3,6,"F",4));
		gbuttons.add(new NewButton(400,578,4,6,"R",5));
		gbuttons.add(new NewButton(450,578,5,6,"B",6));
		gbuttons.add(new NewButton(500,578,2,6,"D",7));
		//inverse
		gbuttons.add(new NewButton(250,603,2,6,"U'",9));
		gbuttons.add(new NewButton(300,603,3,6,"L'",10));
		gbuttons.add(new NewButton(350,603,5,6,"F'",11));
		gbuttons.add(new NewButton(400,603,1,6,"R'",12));
		gbuttons.add(new NewButton(450,603,0,6,"B'",13));
		gbuttons.add(new NewButton(500,603,4,6,"D'",14));
		//reset button
		gbuttons.add(new NewButton(550,578,1,5,"R!",15));
		//test buttons
		gbuttons.add(new NewButton(0,628,0,7,"RAND",16));
		gbuttons.add(new NewButton(100,628,1,7,"RESET",17));
		gbuttons.add(new NewButton(200,628,0,7,"TEST",18));

		//lists
		lists.add(new NewList());
		lists.add(new NewList(0,578,0,2,"Moves:",1,false));
		this.buttons = buttons;
		this.buttonspot = 0;
		this.gbuttons = gbuttons;
		this.gbuttonspot = 0;
		this.rubiks = rubiks;
		this.face = 0;
		this.rubixCube = new Cube();
		changeCube();
		this.image = new Image(500,0,0,0);
		this.lists = lists;
		this.listspot = 0;
	}
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("RUBIKS SOLVER");
		frame.setSize(600,675);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RubikGUI m = new RubikGUI();
		m.setup();
		frame.add(m);
		class RectClicker extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				for(int i = 0;i<buttons.size();i++) {
					Button n = (Button)buttons.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						buttonspot = i;
						if(n.getID()==1) {
							System.out.println(face);
							rubixCube.leftUp(face+1);
						}
						else if(n.getID()==3) {
							rubixCube.rightUp(face+1);
						}
						else if(n.getID()==4) {
							rubixCube.topRight(face+1);
						}
						else if(n.getID()==6) {
							rubixCube.bottomRight(face+1);
						}
						else if(n.getID()==7) {
							rubixCube.leftDown(face+1);
						}
						else if(n.getID()==9) {
							rubixCube.rightDown(face+1);
						}
						else if(n.getID()==10) {
							rubixCube.topLeft(face+1);
						}
						else if(n.getID()==12) {
							rubixCube.bottomLeft(face+1);
						}
						else if(n.getID() >12 && n.getID() < 17) {
							if(n.getID() == 13) {
								face = rubixCube.rotateUp(face);
							}
							else if(n.getID() == 14) {
								face = rubixCube.rotateRight(face);
							}
							else if(n.getID() == 15) {
								face = rubixCube.rotateDown(face);
							}
							else {
								face = rubixCube.rotateLeft(face);
							}
						}
					}
				}
				for(int i = 0; i < gbuttons.size();i++) {
					Button n = (Button)gbuttons.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						gbuttonspot = i;
						n.click();
						if(n.getID()==1) {
							
						}
						else if(n.getID()==2) {
							rubixCube.topLeft(face+1);
						}
						else if(n.getID()==3) {
							rubixCube.leftDown(face+1);
						}
						else if(n.getID()==4) {
							//make adjacent face function
							rubixCube.F(face+1);
						}
						else if(n.getID()==5) {
							rubixCube.rightUp(face+1);
						}
						else if(n.getID()==6) {
							rubixCube.B(face+1);
						}
						else if(n.getID()==7) {
							rubixCube.bottomRight(face+1);
						}
						else if(n.getID()==9) {
							rubixCube.topRight(face+1);
						}
						else if(n.getID()==10) {
							rubixCube.leftUp(face+1);
						}
						else if(n.getID()==11) {
							rubixCube.FPrime(face+1);
						}
						else if(n.getID()==12) {
							rubixCube.rightDown(face+1);
						}
						else if(n.getID()==13) {
							rubixCube.BPrime(face+1);
						}
						else if(n.getID()==14) {
							rubixCube.bottomLeft(face+1);
						}
						else if(n.getID()==16) {
							for(int j = 0; j < 100; j++) {
								//make a little animation for randomize
								rubixCube.randomize(1);
								frame.repaint();
							}
							rubixCube.printTotals();
							rubixCube.checkForContinuity();
						}
						else if(n.getID()==17) {
							rubixCube.reset();
						}
						else if(n.getID()==18) {
							rubixCube.randWhiteCornersSolve();
						}
					}
						
				}
				for(int i = 0; i < lists.size();i++) {
					List n = (List)lists.get(i);
					if(n.contains(e.getX(),e.getY()-25)) {
						listspot = i;
					}
					n.scrollContains(e.getX(), e.getY()-25);
				}
				frame.repaint();
			}
			public void mouseReleased(MouseEvent e) {
				Button n = (Button) buttons.get(buttonspot);
				Button n2 = (Button)gbuttons.get(gbuttonspot);
				n2.click();
				frame.repaint();
				buttonspot = 0;
				gbuttonspot = 0;
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
		frame.setVisible(true);
		KeyEventDemo ked = new KeyEventDemo();
		frame.addKeyListener(ked);
	}
}
