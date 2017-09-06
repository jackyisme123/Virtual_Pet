package myPet;

import javax.swing.ImageIcon;

import GUI.PetVarietyPanel;

public class Cat extends Animal {
	
	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		species = "Felis catus";
		price = 20;
		favorFood = "Fish";
		favorToy = "SandPit";
		normal = new ImageIcon(Cat.class.getResource("/pics/cat_normal.jpg"));
		//normal = new ImageIcon("src\\pics\\cat_normal.jpg");
		choose = new ImageIcon(Cat.class.getResource("/pics/cat_choose.jpg"));
		//choose = new ImageIcon(Cat.class.getResource("pics\\cat_choose.jpg"));
		dead = new ImageIcon(Cat.class.getResource("/pics/cat_dead.jpg"));
	}
	
	public int aniNumber(){
		return 	1;
	}
	
	public String toString(){
		return "Cat";
	}
	
	

}
