package myPet;

import javax.swing.ImageIcon;

public class SwimmingPool extends Toy{
	
	ImageIcon icon = new ImageIcon("src\\pics\\swimmingpool.jpg");
	
	public SwimmingPool(){
		price = 150;
		durability = 10000;
		addPlayfulness = 6;
		img = icon.getImage();
	}
	
	public String toString(){
		return "SwimmingPool(infinite)";
	}
	
	public int toyNumber(){
		return 6;
	}
	
	public String toString1(){
		return "SwimmingPool";
	}
}

