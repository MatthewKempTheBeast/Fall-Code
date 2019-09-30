package Messanger;

import java.util.ArrayList;

import GUI2.Drawable;
import GUI2.TextBox;

public class StoredMessage {
	private String name;
	private ArrayList<Drawable> textboxs;
	public StoredMessage(String name, ArrayList<Drawable> textboxs) {
		this.name = name;
		this.textboxs = textboxs;
	}
	public StoredMessage(String name) {
		this.name = name;
		ArrayList<Drawable> textboxs = new ArrayList<Drawable>();
		textboxs.add(new TextBox());
		this.textboxs = textboxs;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Drawable> getTextBoxs(){
		return textboxs;
	}
	public void addTextBox(TextBox n) {
		textboxs.add(n);
	}
	public int getLowest() {
		int maxheight = 0;
		for(int i = 0; i < textboxs.size();i++) {
			if(((TextBox)(textboxs.get(i))).getY() > maxheight) {
				maxheight = ((TextBox)(textboxs.get(i))).getY();
			}
		}
		return maxheight;
	}
}
