package myPet;

import javax.swing.ImageIcon;

public class BoneToy extends Toy{
	
	ImageIcon icon = new ImageIcon("src\\pics\\bonetoy.jpg");
	public BoneToy(){
		img = icon.getImage();
	}
	public String toString(){
		return "BoneToy(" + durability + ")";
	}
	
	public int toyNumber(){
		return 2;
	}
	
	public String toString1(){
		return "BoneToy";
	}
}
