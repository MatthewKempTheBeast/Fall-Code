package TextComp;

public class Unit {
	private String name;
	private double value;
	public Unit(String name, double value) {
		this.name = name;
		this.value = value;
	}
	public void setName(String n) {
		name = n;
	}
	public void setValue(double n) {
		value = n;
	}
	public String getName() {
		return name;
	}
	public double getValue() {
		return value;
	}
}
