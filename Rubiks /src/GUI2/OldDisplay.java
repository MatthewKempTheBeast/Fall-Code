package GUI2;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
public class OldDisplay extends List implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int width;
	private int height;
	private String Text;
	private int id;
	private Color color;
	private int spot;
	private final int c;
	public OldDisplay(int x, int y, int width, int height,String Text, Color color, int id) {
		this.x = x;
		this.y = y;
		xBegin = x;
		yBegin = y;
		this.width = width;
		this.height = height;
		this.Text = Text;
		this.id = id;
		this.color = color;
		spot = 0;
		//kinda jank only works with some font sizes
		c = 2*(width/height)-1;
	}
	public OldDisplay(){
		x = 0;
		y = 0;
		xBegin = x;
		yBegin = y;
		width = 0;
		height = 0;
		Text = "";
		id = 0;
		color = null;
		spot = 0;
		c = 0;
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
	public Color getColor() {
		return color;
	}
	public boolean contains(int a, int b) {
		Rectangle Button = new Rectangle(x,y,width,height);
		return Button.contains(a, b);
	}
	public boolean scrollContains(int a,int b) {
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
		Rectangle back = new Rectangle(x,y,width,height);
		g2.setColor(color);
		g2.fill(back);
		Font myfont = new Font("butt",Font.BOLD, height);
		g2.setFont(myfont);
		g2.setColor(Color.BLACK);
		if(Text.length()-spot>=c) {
			g2.drawString(Text.substring(spot,spot+c),x,y+height-height/10);
		}
		else if(Text.length() < c) {
			g2.drawString(Text, x, y+height-height/10);
		}
		
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
		g2.setClip(new Rectangle(x1,y1,width1,height1));
		drawSelf(g2);
	}
}
