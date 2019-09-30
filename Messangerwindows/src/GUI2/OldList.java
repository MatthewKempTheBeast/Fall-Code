package GUI2;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
public class OldList extends List implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int width;
	private int height;
	private int id;
	private String Text;
	private boolean scaleable;
	private ArrayList<String> rows;
	private Color color;
	private final int c;
	private final int cl;
	private int spot;
	public OldList(int x, int y, int width, int height,String Text, int id, Color color, boolean scaleable) {
		this.x = x;
		this.y = y;
		this.xBegin = x;
		this.yBegin = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.Text = Text;
		this.scaleable = scaleable;
		this.color = color;
		c = (width-20)/10;
		spot = 0;
		cl = height/((width-20)/c*2);
		setRows();
	}
	public OldList() {
		this.x = 0;
		this.y = 0;
		this.xBegin = x;
		this.yBegin = y;
		this.width = 0;
		this.height = 0;
		this.id = 0;
		this.Text = "";
		this.scaleable = false;
		this.color = Color.BLACK;
		c = 1;
		cl = 0;
		spot = 0;
		setRows();
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
	public int getID() {
		return id;
	}
	public String getText() {
		return Text;
	}
	public boolean getScaleable() {
		return scaleable;
	}
	public ArrayList<String> getRows(){
		return rows;
	}
	public Color getColor() {
		return color;
	}
	public int getSpot() {
		return spot;
	}
	public int getSize() {
		return rows.size();
	}
	public void setRows() {
		rows = new ArrayList<String>();
		if(!scaleable) {
			int length = Text.length()/c;
			for(int i = 0; i < length;i++) {
				String tempText = Text.substring(i*c, i*c+c);
				rows.add(tempText);
			}
			rows.add(Text.substring(length*c,Text.length()));
		}
	}
	public void addText(String n) {
		Text = Text + n;
		setRows();
	}
	public void printRows() {
			for(int i = 0; i < rows.size();i++) {
				System.out.println(rows.get(i));
			}
	}
	public boolean contains(int a, int b) {
		Rectangle Button = new Rectangle(x,y,width,height);
		return Button.contains(a, b);
	}
	public void up() {
		if(spot > 0) {
			spot = spot- 1;
		}
	}
	public void down() {
		if(spot < rows.size()-cl) {
			spot = spot + 1;
		}
	}
	public boolean scrollContains(int a, int b) {
		Rectangle up = new Rectangle(x+width-20,y,20,20);
		Rectangle down = new Rectangle(x+width-20,y+height-20,20,20);
		if(up.contains(a, b)) {
			up();
			System.out.println("up");
			return true;
		}
		else if(down.contains(a, b)) {
			down();
			System.out.println("down");
			return true;
		}
		else {
			return false;
		}
		
	}
	public void add(String n) {
		Text = Text + n;
		setRows();
		if(rows.size()>cl) {
			spot = rows.size()-cl;
		}
	}
	public void remove() {
		if(Text.length() > 0) {
			if(rows.get(rows.size()-1).length() > 0) {
				Text = Text.substring(0,Text.length()-1);
				setRows();
			}
			else {
				System.out.println("called");
				Text = Text.substring(0,Text.length()-1);
				up();
				setRows();
			}
		}
	}
	public void enter() {
		for(int i = 0 ;i < c-rows.get(rows.size()-1).length();i++) {
			Text = Text + " ";
		}
		if(rows.size()>cl) {
			spot = rows.size()-cl;
		}
	}
	public void right() {
		
	}
	public void left() {
		
	}
	public void changeXY(int a,int b) {
		x = a + x;
		y = b + y;
	}
	public  void defaultXY() {
		x = xBegin;
		y = yBegin;
	}
	public void changeY(int b) {
		y = y + b;
		System.out.println("Y is no:w " + y);
	}
	public void drawSelf(Graphics2D g2){
		Rectangle back = new Rectangle(x,y,width,height);
		Rectangle up = new Rectangle(x+width-20,y,20,20);
		Rectangle down = new Rectangle(x+width-20,y+height-20,20,20);
		g2.setColor(color);
		g2.fill(back);
		g2.setColor(color.darker());
		g2.fill(up);
		g2.fill(down);
		if(!scaleable) {
			Font myfont = new Font("butt",Font.BOLD, (width-20)/c*2);
			 g2.setFont(myfont);
			 g2.setColor(Color.BLACK);
			for(int i = 0; i < cl;i++) {
				//the numbers in here are kinda weird but they work
				if(i < rows.size()){
					g2.drawString(rows.get(i+spot), x, y+(i)*((width-20)/c*2)+(width-20)/c*2-5);
				}
			}
		}
		
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
		g2.setClip(new Rectangle(x1,y1,width1,height1));
		drawSelf(g2);
	}
}