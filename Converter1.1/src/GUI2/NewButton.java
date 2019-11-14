package GUI2;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.*;
public class NewButton extends Button implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int width;
	private int height;
	private int size;
	private int id;
	private String Text;
	private boolean clicked;
	private BufferedImage[] images;
	private BufferedImage[] cimages;
	private BufferedImage image;
	private BufferedImage cimage;
	public NewButton() {
		this.x = 0;
		this.y = 0;
		xBegin = x;
		yBegin = y;
		this.width = 0;
		this.height = 0;
		this.size = 1;
		this.id = 0;
		Text = "";
		/*try {
			//BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/default/default.PNG"))};
			//images = null;
			//BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/default/default.PNG"))};
			//cimages = null;
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//image = images[0];
		//cimage = cimages[0];
		clicked = false;
	}
	public NewButton(int x, int y, int backgroud,int size,int id) {
		this.x = x;
		this.y = y;
		xBegin = x;
		yBegin = y;
		this.size = size;
		this.Text = "";
		this.id = id;
		if(size == 1) {
			this.width = 50;
			this.height = 50;
		}
		else if(size == 2) {
			this.width = 100;
			this.height = 50;
		}
		//size three is for the search, add, and minus button
		else if(size == 3) {
			this.width = 25;
			this.height = 25;
		}
		//size 4 is for the addgui menu
		else if(size == 4) {
			this.width = 180;
			this.height=  25;
		}
		//gui buttons for rubiks
		else if(size == 5) {
			this.width = 50;
			this.height = 50;
		}
		else if(size == 6) {
			this.width = 50;
			this.height = 25;
		}
		else if(size==7) {
			this.width = 100;
			this.height = 25;
		}
		images = Load.getNewButton(size);
		cimages = Load.getNewButtonc(size);
		image = images[backgroud];
		cimage = cimages[backgroud];
		this.clicked = false;
	}
	public NewButton(int x, int y, int backgroud,int size,String Text,int id) {
		this.x = x;
		this.y = y;
		xBegin = x;
		yBegin = y;
		this.size = size;
		this.Text = Text;
		this.id = id;
		if(size == 1) {
			this.width = 100;
			this.height = 25;
		}
		else if(size == 2) {
			this.width = 100;
			this.height = 50;
		}
		else if(size == 3) {
			this.width = 25;
			this.height = 25;
		}
		else if(size == 4) {
			this.width = 180;
			this.height=  25;
		}
		else if(size == 5) {
			this.width = 50;
			this.height = 50;
		}
		else if(size == 6) {
			this.width = 50;
			this.height = 25;
		}
		else if(size==7) {
			this.width = 100;
			this.height = 25;
		}
		images = Load.getNewButton(size);
		cimages = Load.getNewButtonc(size);
		image = images[backgroud];
		cimage = cimages[backgroud];
		this.clicked = false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getSize() {
		return size;
	}
	public String getText() {
		return Text;
	}
	public int getID() {
		return id;
	}
	public boolean getClicked() {
		return clicked;
	}
	public void click() {
		clicked = !clicked;
	}
	public void unclick() {
		clicked = false;
	}
	public boolean contains(int a, int b) {
		Rectangle Button1 = new Rectangle(x,y,width,height);
		return Button1.contains(a, b);
	}
	public void changeXY(int a,int b) {
		x = a + x;
		y = b + y;
	}
	public void changeY(int b) {
		y = y + b;
		//System.out.println("Y is no:w " + y);
	}
	public void defaultXY() {
		x = xBegin;
		y = yBegin;
	}
	public void drawSelf(Graphics2D g2){
		//g2.setClip(new Rectangle(0,0,50,600));
		if(id != 0) {
			if(!clicked) {
				g2.drawImage(image, x, y, null);
			}
			else {
				g2.drawImage(cimage,x,y,null);
			}
			Font myfont = new Font("butt",Font.BOLD, 20);
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			if(Text.length()>0 && 20 > 20*(width/(g2.getFontMetrics().stringWidth(Text)))) {
				myfont = new Font("butt",Font.BOLD,(int)(20*((double)width/(g2.getFontMetrics().stringWidth(Text)))));
			}
			else {
				myfont = new Font("butt",Font.BOLD,20);
			}
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			g2.drawString(Text, x+(width-g2.getFontMetrics().stringWidth(Text))/2, y+height-(height-g2.getFontMetrics().getMaxAscent())/2);
		}
	}
	public void drawSelf(Graphics2D g2,Rectangle n) {
		//g2.setClip(new Rectangle());
		if(id != 0) {
			if(!clicked) {
				g2.drawImage(image, x, y, null);
			}
			else {
				g2.drawImage(cimage,x,y,null);
			}
			Font myfont = new Font("butt",Font.BOLD, 20);
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			if(Text.length()>0 && 20 > 20*(width/(g2.getFontMetrics().stringWidth(Text)))) {
				myfont = new Font("butt",Font.BOLD,(int)(20*((double)width/(g2.getFontMetrics().stringWidth(Text)))));
			}
			else {
				myfont = new Font("butt",Font.BOLD,20);
			}
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			g2.drawString(Text, x+(width-g2.getFontMetrics().stringWidth(Text))/2, y+height-(height-g2.getFontMetrics().getAscent())/2);
		}
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
		g2.setClip(new Rectangle(x1,y1,width1,height1));
		if(id != 0) {
			if(!clicked) {
				g2.drawImage(image, x, y, null);
			}
			else {
				g2.drawImage(cimage,x,y,null);
			}
			Font myfont = new Font("butt",Font.BOLD, 20);
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			if(Text.length()>0 && 20 > 20*(width/(g2.getFontMetrics().stringWidth(Text)))) {
				myfont = new Font("butt",Font.BOLD,(int)(20*((double)width/(g2.getFontMetrics().stringWidth(Text)))));
			}
			else {
				myfont = new Font("butt",Font.BOLD,20);
			}
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			g2.drawString(Text, x+(width-g2.getFontMetrics().stringWidth(Text))/2, y+height-(height-g2.getFontMetrics().getAscent())/2);
		}
	}
	
}
