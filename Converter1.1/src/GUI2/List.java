package GUI2;

public abstract class List {
	public abstract boolean contains(int a,int b);
	public abstract boolean scrollContains(int a,int b);
	public abstract void remove();
	public abstract void add(String n);
	public abstract void enter();
	public abstract void right();
	public abstract void left();
	public abstract void changeXY(int a, int b);
	public abstract int getHeight();
	public abstract int getY();
	public abstract void print();
	public abstract void cprint();
	public abstract void up();
	public abstract void down();
	public abstract void cup();
	public abstract void cdown();
}
