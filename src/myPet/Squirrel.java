package myPet;

import javax.swing.ImageIcon;

public class Squirrel extends Animal {
	
	public Squirrel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		species = "Tamias";
		price = 50;
		favorFood = "Nuts";
		favorToy = "Roller";
		normal = new ImageIcon(Squirrel.class.getResource("/pics/squirrel_normal.jpg"));
		choose = new ImageIcon(Squirrel.class.getResource("/pics/squirrel_choose.jpg"));
		dead = new ImageIcon(Squirrel.class.getResource("/pics/squirrel_dead.jpg"));
	}
	
	public int aniNumber(){
		return 5;
	}
	
	public String toString(){
		return "Squirrel";
	}


}
