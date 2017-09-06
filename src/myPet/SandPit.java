package myPet;

import javax.swing.ImageIcon;

public class SandPit extends Toy{
	ImageIcon icon = new ImageIcon("src\\pics\\sandpit.jpg");
	public SandPit(){
		img = icon.getImage();
	}
	
	public String toString(){
		return "SandPit(" + durability + ")";
	}
	
	public int toyNumber(){
		return 1;
	}
	public String toString1(){
		return "SandPit";
	}
}
