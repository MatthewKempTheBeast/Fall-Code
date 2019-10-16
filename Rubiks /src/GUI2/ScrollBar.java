package GUI2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class ScrollBar extends Button implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int width;
	private int height;
	private int size;
	private Window w;
	private boolean axis;
	private BufferedImage image;
	private BufferedImage cimage;
	//position of the bar
	private int yPos;
	private int yHeight;
	private int id;
	//window size is the total size in pixels of the window trying to be displayed
	//windowX is the current xPos being displayed in the window
	//this one makes vertical scroll bars
	public ScrollBar(int x, int y, int height,int background, int size,Window w,int id) {
		this.x = x;
		this.y = y;
		xBegin = x;
		yBegin = y;
		if(size == 1) {
			this.width = 20;
		}
		this.height = height;
		image = Load.getScroll(size, background);
		cimage = Load.getScrollBar(size, 0);
		this.size = size;
		this.w = w;
		axis = false;
		this.yPos = y+20;
		this.yHeight = (int) ((((double)w.getHeight())/w.getRHeight())* (height-40));
		this.id = id;
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
	public Window getWindow() {
		return w;
	}
	public int getID() {
		return id;
	}
	public boolean contains(int a,int b) {
		if(a <= x+20 && a >= x && b <= y+20 && b >= y) {
			scrollContains(a,b);
			//System.out.println("up");
			return true;
		}
		else if(a <= x+20 && a >= x && b >= y+height-20 && b <= y+height) {
			scrollContains(a,b);
			//System.out.println("down");
			return true;
		}
		else if(a <= x+20 && b > y+20 && a <= x+20 && b < y+height-20&& a >= x ) {
			yPosMove(b);
			return true;
		}
		return false;
	}
	public boolean scrollContains(int a, int b) {
		if(a <= x+20 && b <= y+20) {
			scrollUp();
			return true;
		}
		else if (a <= x+20 && b >= y+height-20 && b <= y+height){
			scrollDown();
			return true;
		}
		return false;
	}
	public void scrollUp() {
		if(yPos >= y+20) {
			if(yPos <= y+20+(height-40)/5) {
				yPos = y+20;
				//System.out.println("UP1 : " + yPos);
			}
			else {
				//System.out.print("up");
				yPos = yPos - (height-40)/5;
				//System.out.println("UP2 : " + yPos);
			}
		}
		//System.out.println("yPos-y-20: " + (yPos-y-20));
		//System.out.println("whole : " + ((int)((yPos-y-20)*((double)w.getRHeight()/yHeight)))/2 );
		w.changeYPos(((int)((yPos-y-20)*((double)w.getRHeight()/yHeight)))/2);
		//System.out.println("up: " + w.getYPos());
	}
	public void scrollDown() {
		if(yPos + yHeight < y+height-20) {
			if(yPos+yHeight >= y+height-20-(height-40)/5) {
				//System.out.println("down1");
				yPos = y+height-20-yHeight;
			}
			else if(yPos < y+height-20-(yHeight/2)){
				//System.out.println("down2");
				yPos = yPos + (height-40)/5;
			}
		}
		w.changeYPos(((int)((yPos-y-20)*((double)w.getRHeight()/yHeight)))/2);
		//System.out.println("down: " + w.getYPos());
	}
	public void yPosMove(int n) {
		//System.out.println(n);
		if(n >= y+20 && n < y+height-20-yHeight ) {
			//System.out.println("yPosMove1");
			yPos = n;
		}
		else {
			//System.out.println("yPosMove2");
			yPos = y+height-yHeight-20;
		}
		//System.out.println("rHeight: " + w.getRHeight());
		//System.out.println("yPos: "+(int)((yPos-y-20)*((double)w.getRHeight()/yHeight)));
		w.changeYPos(((int)((yPos-y-20)*((double)w.getRHeight()/yHeight)))/2);
		//System.out.println(w.getYPos());
	}
	public void click() {
		
	}
	public void unclick() {
		
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
	public void updateYHeight() {
		yHeight = (int)((((double)w.getHeight())/w.getRHeight())*(height-40));
	}
	public void drawSelf(Graphics2D g2){
		updateYHeight();
		if(!axis) {
			g2.drawImage(image, x, y, null);
			Rectangle bar = new Rectangle(x+1,yPos,width-2,yHeight);
			g2.setColor(Color.BLUE);
			g2.fill(bar);
		}
		else {
			
		}
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1,int height1) {
		g2.setClip(new Rectangle(x1,y1,width1,height1));
		drawSelf(g2);
	}
}
