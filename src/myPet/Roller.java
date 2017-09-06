package myPet;

import javax.swing.ImageIcon;

public class Roller extends Toy{
	ImageIcon icon = new ImageIcon("src\\pics\\roller.jpg");
	public Roller(){
		img = icon.getImage();
	}
	
	public String toString(){
		return "Roller(" + durability + ")";
	}
	
	public int toyNumber(){
		return 5;
	}
	
	public String toString1(){
		return "Roller";
	}
}

