package myPet;

import javax.swing.ImageIcon;

public class Fish extends Food {
	
	public Fish(){
		img = new ImageIcon("src\\pics\\fish.jpg");
	}
	public String toString() {
		return "Fish";
	}
	
	public int foodNumber(){
		return 1;
	}
}
