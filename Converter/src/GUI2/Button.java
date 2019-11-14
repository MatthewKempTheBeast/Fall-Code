package GUI2;

import java.awt.Rectangle;

public abstract class Button {
	public abstract boolean contains(int a, int b);
	public abstract void click();
	public abstract void unclick();
	public abstract void changeXY(int a, int b);
	public abstract int getID();
	public abstract int getHeight();
	public abstract int getY();
}
