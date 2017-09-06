package myPet;

import javax.swing.ImageIcon;

public class Nuts extends Food {
	
	public Nuts(){
		nutrition = 1;
		favorTasteness = 3;
		img = new ImageIcon("src\\pics\\nuts.jpg");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nuts";
	}
	
	public int foodNumber(){
		return 5;
	}

}
