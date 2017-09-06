package myPet;

import javax.swing.ImageIcon;

public class Bamboo extends Food {
	
	
	public Bamboo(){
		nutrition = 1;
		favorTasteness = 3;
		price = 10;
		img = new ImageIcon("src\\pics\\fruit.jpg");
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Bamboo";
	}
	
	public int foodNumber(){
		return 6;
	}
}
