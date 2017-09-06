package myPet;

import javax.swing.ImageIcon;

public class BoxingGlove extends Toy{
	
	ImageIcon icon = new ImageIcon("src\\pics\\boxingglove.jpg");
	public BoxingGlove(){
		img = icon.getImage();
	}
	
	public String toString(){
		return "BoxingGlove(" + durability + ")";
	}
	
	public int toyNumber(){
		return 3;
	}
	
	public String toString1(){
		return "BoxingGlove";
	}
}
