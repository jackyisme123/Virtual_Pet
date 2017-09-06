package myPet;

import javax.swing.ImageIcon;

public class Panda extends Animal {
	
	public Panda(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		species = "Kung Fu Panda";
		price = 100;
		favorFood = "BAMBOO";
		favorToy = "SwimmingPool";
		normal = new ImageIcon(Panda.class.getResource("/pics/panda_normal.jpg"));
		choose = new ImageIcon(Panda.class.getResource("/pics/panda_choose.jpg"));
		dead = new ImageIcon(Panda.class.getResource("/pics/panda_dead.jpg"));
	}
	
	public int aniNumber(){
		return 6;
	}
	
	public String toString(){
		return "Panda";
	}


}
