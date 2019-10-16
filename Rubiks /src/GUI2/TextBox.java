package GUI2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TextBox implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int width;
	private int height;
	private String Text;
	private Color color;
	private final Color ogcolor;
	private int id;
	public TextBox(int x, int y, int width, int height, String Text,Color color, int id) {
		this.x = x;
		this.y = y;
		this.xBegin = x;
		this.yBegin = y;
		this.width = width;
		this.height = height;
		this.Text = Text;
		this.color = color;
		ogcolor = color;
		this.id = id;
	}
	public TextBox() {
		this.x = 0;
		this.y = 0;
		this.xBegin = x;
		this.yBegin = y;
		this.width = 0;
		this.height = 0;
		this.Text = "";
		this.color = null;
		this.ogcolor = color;
		this.id = 0;
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
	public void changeXY(int a,int b) {
		x = x + a;
		y = y + b;
	}
	public  void defaultXY() {
		x = xBegin;
		y = yBegin;
	}
	public void changeY(int b) {
		y = y + b;
		//System.out.println("Y is no:w " + y);
	}
	public void add(String n) {
		Text = Text + n;
	}
	public void remove() {
	}
	public void setText(String n) {
		Text = n;
	}
	public boolean scrollContains(int a,int b) {
		return false;
	}
	public void right() {
		
	}
	public void left() {
		
	}
	public boolean contains(int a, int b) {
		Rectangle Button = new Rectangle(x,y,width,height);
		return Button.contains(a, b);
	}
	public void enter() {
		
	}
	public void click() {
		color = ogcolor.darker();
	}
	public void unclick() {
		color = ogcolor;
	}
	public void drawSelf(Graphics2D g2){
		if(width > 0) {
			//System.out.println("Textbox");
			Rectangle box = new Rectangle(x,y,width,height);
			g2.setColor(color);
			g2.fill(box);
			Rectangle top = new Rectangle(x,y,width,3);
			Rectangle right = new Rectangle(x-3+width,y,3,height);
			Rectangle bottom = new Rectangle(x,y+height-3,width,3);
			Rectangle left = new Rectangle(x,y,3,height);
			g2.setColor(Color.BLACK);
			g2.fill(top);
			g2.fill(right);
			g2.fill(bottom);
			g2.fill(left);
			//get the length of the string
			Font myfont = new Font("butt",Font.BOLD, 20);
			g2.setFont(myfont);
			g2.setColor(Color.BLACK);
			int length = g2.getFontMetrics().stringWidth(Text);
			if(length > width) {
				//System.out.println("hello1");
	
				ArrayList<String> list = new ArrayList<String>();
				int currentSpot = 0;
				for(int i = 0; i < Text.length();i++) {
					if(g2.getFontMetrics().stringWidth(Text.substring(currentSpot,i))>width) {
						list.add(Text.substring(currentSpot,i-1));
						currentSpot = i-1;
					}
				}
				list.add(Text.substring(currentSpot,Text.length()));
				for(int i = 0; i < list.size();i++) {
					g2.drawString(list.get(i), x+3, y+20*i+20);
				}
			}
			else {
				//System.out.println("hello2");
				g2.drawString(Text, x+3, y+20);
			}
		}
		//g2.drawString(Text, 200, 200);
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
		//g2.setClip(new Rectangle(x1,y1,width1,height1));
		drawSelf(g2);
	}
}
