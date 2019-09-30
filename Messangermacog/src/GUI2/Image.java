package GUI2;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class Image implements Drawable{
	private int x;
	private int y;
	private final int xBegin;
	private final int yBegin;
	private int folder;
	private int spot;
	private BufferedImage image;
	public Image(int x,int y, int folder, int spot) {
		this.x = x;
		this.y = y;
		xBegin = x;
		yBegin = y;
		this.folder = folder;
		this.spot = spot;
		image = Load.getImage(folder, spot);
	}
	public void changeXY(int a,int b) {
		x = x + a;
		y = x + b;
	}
	public void changeY(int b) {
		y = y + b;
	}
	public void defaultXY() {
		x = xBegin;
		y = yBegin;
	}
	public void drawSelf(Graphics2D g2){
		//g2.setClip(new Rectangle(100,100,100,100));
		g2.drawImage(image, x, y, null);
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
		g2.setClip(new Rectangle(x1,y1,width1,height1));
		drawSelf(g2);
	}
}
