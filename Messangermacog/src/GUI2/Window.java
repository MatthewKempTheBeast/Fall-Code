package GUI2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

public class Window implements Drawable{
	private int x;
	private int y;
	private int width;
	private int height;
	private ArrayList<ArrayList<Drawable>> gfx;
	private int id;
	private int rHeight;
	private int yPos;
	public Window(int x, int y, int width, int height,int rHeight, ArrayList<ArrayList<Drawable>> gfx,int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gfx = gfx;
		this.id = id;
		this.rHeight = rHeight;
		this.yPos = 0;
		for(int j = 0; j < gfx.size();j++) {
			for(int i = 0; i < gfx.get(j).size();i++) {
				gfx.get(j).get(i).changeXY(x,y-yPos);
			}
		}
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
	public ArrayList<ArrayList<Drawable>> getGFX(){
		return gfx;
	}
	public int getID() {
		return id;
	}
	public int getRHeight() {
		return rHeight;
	}
	public int getYPos() {
		return yPos;
	}
	public void changeXY(int a, int b) {
		x = x+a;
		y = y+b;
	}
	public void changeYPos(int n) {
		if(n >= 0 && n < rHeight) {
			yPos = n;
			moveDownGFX(n);
		}
	}
	public void moveDownGFX(int n) {
		for(int j = 0; j < gfx.size();j++) {
			for(int i = 0; i < gfx.get(j).size();i++) {
				gfx.get(j).get(i).defaultXY();
				gfx.get(j).get(i).changeXY(x, y-yPos);
			}
		}
	}
	public void defaultXY() {
	}
	public void changeY(int b) {
	}
	public boolean contains(int a, int b) {
		Rectangle Button = new Rectangle(x,y,width,height);
		return Button.contains(a, b);
	}
	public void heightRCalc() {
		int maxheight = rHeight;
		for(int i = 0; i < gfx.size();i++) {
			for(int j = 0; j < gfx.get(i).size();j++) {
				if(i == 0) {
					if(((Button)((gfx.get(i)).get(j))).getHeight() > maxheight) {
						maxheight = ((Button)((gfx.get(i)).get(j))).getHeight();
					}
				}
				else if(i == 1) {
					if(((List)((gfx.get(i)).get(j))).getY() > maxheight) {
						maxheight = ((List)((gfx.get(i)).get(j))).getY();
					}
				}
				else if(i == 2) {
					if(((TextBox)((gfx.get(i)).get(j))).getY() > maxheight) {
						maxheight = ((TextBox)((gfx.get(i)).get(j))).getY();
					}
				}
			}
		}
		//System.out.println(rHeight);
		rHeight = maxheight;
	}
	public boolean gfxContains(int a, int b) {
		boolean k = false;
		for(int i = 0; i < gfx.size();i++) {
			for(int j = 0; j < gfx.get(i).size();j++) {
				//buttons
				if(i == 0) {
					if(((Button)((gfx.get(i)).get(j))).contains(a, b)) {
						k = ((Button)((gfx.get(i)).get(j))).contains(a, b);
					}
				}
				//lists
				else if(i == 1) {
					if(((List)((gfx.get(i)).get(j))).contains(a, b)) {
						k = ((List)((gfx.get(i)).get(j))).contains(a, b);
					}
				}
				//textboxs
				else if(i == 2) {
					System.out.println("2");
					System.out.println(((TextBox)((gfx.get(i)).get(j))).getY());
					if(((TextBox)((gfx.get(i)).get(j))).contains(a, b)) {
						System.out.println("2true");
						k = ((TextBox)((gfx.get(i)).get(j))).contains(a, b);
					}
				}
			}
		}
		System.out.println(k);
		return k;
	}
	public int[] gfxGetContains(int a, int b){
		int[] pos = new int[2];
		
		for(int i = 0; i < gfx.size();i++) {
			for(int j = 0; j < gfx.get(i).size();j++) {
				//buttons
				if(i == 0 && ((Button)((gfx.get(i)).get(j))).contains(a, b)) {
					pos[0] = i;
					pos[1] = j;
				}
				//lists
				else if(i == 1 && ((List)((gfx.get(i)).get(j))).contains(a, b)) {
					pos[0] = i;
					pos[1] = j;
				}
				//textboxs
				else if(i == 2 && ((TextBox)((gfx.get(i)).get(j))).contains(a, b)) {
					//System.out.println("2");
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}
	public Drawable getGfxSpot(int i , int j) {
		return gfx.get(i).get(j);
	}
	public void unclickAll() {
		for(int i = 0;i < gfx.get(2).size();i++) {
			TextBox temp = (TextBox)(gfx.get(2).get(i));
			temp.unclick();
		}
	}
	public void addText(TextBox n) {
		gfx.get(2).add(n);
	}
	public int getSize() {
		return gfx.get(0).size() + gfx.get(1).size() + gfx.get(2).size();
	}
	public Button getButton(int n) {
		if(n < gfx.get(0).size()) {
			return (Button)(gfx.get(0).get(n));
		}
		return null;
	}
	public List getList(int n) {
		if(n < gfx.get(1).size()) {
			return (List)(gfx.get(1).get(n));
		}
		return null;
	}
	public TextBox getTextBox(int n) {
		if(n < gfx.get(2).size()) {
			return (TextBox)(gfx.get(2).get(n));
		}
		return null;
	}
	public void setTextBox(ArrayList<Drawable> n) {
		gfx.set(2,n);
	}
	public ArrayList<Drawable> getTextBoxArray(){
		return gfx.get(2);
	}
	public void drawSelf(Graphics2D g2){
		heightRCalc();
		Rectangle back = new Rectangle(x,y,width,height);
		g2.setColor(new Color(118,214,255));
		g2.fill(back);
		for(ArrayList<Drawable> dd: gfx) {
			for(Drawable d : dd)
			{
				g2.setClip(new Rectangle(x,y,width,height));
				d.drawSelf(g2,x,y,width,height);
			}
		}
	}
	public void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1) {
	}
}
