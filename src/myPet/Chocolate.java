package myPet;

import javax.swing.ImageIcon;

public class Chocolate extends Food {
	
	
	public Chocolate(){
		img = new ImageIcon("src\\pics\\chocolate.jpg");;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Chocolate";
	}
	
	public int foodNumber(){
		return 3;
	}

}
