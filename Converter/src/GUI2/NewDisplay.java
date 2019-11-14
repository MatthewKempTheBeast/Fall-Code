package GUI2;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class NewDisplay extends List implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int width;
	private int height;
	private String Text;
	private int id;
	private int spot;
	private int c;
	private BufferedImage image;
	public NewDisplay(int x, int y,int background,int size, String Text, int id) {
		this.x = x;
		this.y = y;
		xBegin = x;
		yBegin = y;
		if(size == 1) {
			this.width = 100;
			this.height = 25;
		}
		else if(size == 2) {
			this.width = 125;
			this.height = 25;
		}
		else if(size == 3) {
			this.width = 180;
			this.height = 25;
		}
		else if(size == 4) {
			this.width = 375;
			this.height = 25;
		}
		this.Text = Text;
		this.id = id;
		spot = 0;
		//kinda jank only works with some font sizes
		c = 2*(width/height)-1;
		//c = 0;
		image = Load.getNewDisplay(size, background);
	}
	public NewDisplay(){
		x = 0;
		y = 0;
		xBegin = x;
		yBegin = y;
		width = 0;
		height = 0;
		Text = "";
		id = 0;
		spot = 0;
		c = 0;
		image = null;
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
	public String getText() {
		return Text;
	}
	public int getIntText() {
		return Integer.parseInt(Text);
	}
	public int getTextSize() {
		return Text.length();
	}
	public int getID() {
		return id;
	}
	public boolean contains(int a, int b) {
		Rectangle Button = new Rectangle(x,y,width,height);
		return Button.contains(a, b);
	}
	public boolean scrollContains(int a, int b) {
		return false;
	}
	public void right() {
		if(Text.length()-spot>c) {
			spot = spot + 1;
		}
	}
	public void left() {
		if(spot > 0) {
			spot = spot -1;
		}
	}
	public void enter() {
		
	}
	public void add(String n) {
		Text = Text + n;
	}
	public void remove() {
		if(Text.length()>0) {
			Text = Text.substring(0, Text.length()-1);
			if(spot > 0) {
				spot = spot -1;
			}
		}
	}
	public void changeXY(int a,int b) {
		x = a + x;
		y = b + y;
	}
	public void changeY(int b) {
		y = y + b;
	}
	public void defaultXY() {
		x = xBegin;
		y = yBegin;
	}
	public void drawSelf(Graphics2D g2){
		if(id!=0) {
			g2.drawImage(image, x, y, null);
			for(int i = Text.length();i > 0;i--) {
				if(g2.getFontMetrics().stringWidth(Text.substring(0,i)) < width) {
					c = i;
					//System.out.println("c :" + c);
					//System.out.println("Text.length()" + Text.length());
					//System.out.println(c == Text.length());
					break;
				}
			}
			//c = g2.getFontMetrics().stringWidth(Text);
			if(Text.length()-spot>=c) {
			//if(Text.length())
				//System.out.println("display");
				g2.drawString(Text.substring(spot,spot+c),x,y+height-height/10);
				g2.setColor(Color.BLACK);
				g2.fill(new Rectangle(x+g2.getFontMetrics().stringWidth(Text.substring(spot,spot+c)),y+height-height/10-20,2,20));
				
			}
			//else if(Text.length() < c) {
			else if((int)Text.length() == (int)c ){
				//System.out.println("2");
				g2.drawString(Text, x, y+height-height/10);
				g2.setColor(Color.BLACK);
				g2.fill(new Rectangle(x+g2.getFontMetrics().stringWidth(Text)+1,y+height-height/10-20,2,20));
			}
		}
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
		g2.setClip(new Rectangle(x1,y1,width1,height1));
		drawSelf(g2);
	}
}
