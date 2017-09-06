package myPet;

import javax.swing.ImageIcon;

public class Monkey extends Animal {
	
	
	public Monkey(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		species = "Rhinopithecus";
		price = 50;
		favorFood = "Fruit";
		favorToy = "Swing";
		normal = new ImageIcon(Monkey.class.getResource("/pics/monkey_normal.jpg"));
		choose = new ImageIcon(Monkey.class.getResource("/pics/monkey_choose.jpg"));
		dead = new ImageIcon(Monkey.class.getResource("/pics/monkey_dead.jpg"));
	}
	
	public int aniNumber(){
		return 4;
	}
	
	public String toString(){
		return "Monkey";
	}


}
