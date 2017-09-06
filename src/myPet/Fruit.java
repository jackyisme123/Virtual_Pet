package myPet;

import javax.swing.ImageIcon;

public class Fruit extends Food {

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fruit";
	}
	
	public int foodNumber(){
		return 4;
	}
	
	public Fruit(){
		img = new ImageIcon("src\\pics\\fruit.jpg");
	}

}
