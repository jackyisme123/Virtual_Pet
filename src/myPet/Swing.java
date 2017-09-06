package myPet;

import javax.swing.ImageIcon;

public class Swing extends Toy{
	
	ImageIcon icon = new ImageIcon("src\\pics\\swing.jpg");
	public Swing(){
		img = icon.getImage();
	}
	
	public String toString(){
		return "Swing(" + durability + ")";
	}
	
	public int toyNumber(){
		return 4;
	}
	
	public String toString1(){
		return "Swing";
	}
}

