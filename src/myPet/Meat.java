package myPet;

import javax.swing.ImageIcon;

public class Meat extends Food {

	
	public Meat(){
		img = new ImageIcon("src\\pics\\meat.jpg");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Meat";
	}
	
	public int foodNumber(){
		return 2;
	}

}
