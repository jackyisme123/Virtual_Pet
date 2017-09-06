package myPet;

import javax.swing.ImageIcon;

public class Dog extends Animal {
	
	
	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		species = "corgi";
		price = 20;
		favorFood = "Meat";
		favorToy = "BoneToy";
		normal = new ImageIcon(Dog.class.getResource("/pics/dog_normal.jpg"));
		choose  = new ImageIcon(Dog.class.getResource("/pics/dog_choose.jpg"));
		dead  = new ImageIcon(Dog.class.getResource("/pics/dog_dead.jpg"));
	}
	
	public int aniNumber(){
		return 2;
	}
	
	public String toString(){
		return "Dog";
	}

}
