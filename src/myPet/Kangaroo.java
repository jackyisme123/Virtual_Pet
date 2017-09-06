package myPet;

import javax.swing.ImageIcon;

public class Kangaroo extends Animal {
	
	
	public Kangaroo(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		species = "Quokka";
		price = 20;
		favorFood = "Chocolate";
		favorToy = "BoxingGlove";
		normal = new ImageIcon(Kangaroo.class.getResource("/pics/kangaroo_normal.jpg"));
		choose = new ImageIcon(Kangaroo.class.getResource("/pics/kangaroo_choose.jpg"));
		dead = new ImageIcon(Kangaroo.class.getResource("/pics/kangaroo_dead.jpg"));
	}
	
	public int aniNumber(){
		return 3;
	}
	
	public String toString(){
		return "Kangaroo";
	}

}
