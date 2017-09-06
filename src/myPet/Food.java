package myPet;

import javax.swing.ImageIcon;

public abstract class Food {
	int nutrition;
	int favorNutrition;
	int tasteness;
	int favorTasteness;
	int price;
	protected ImageIcon img;
	
	public Food() {
		nutrition = 2;
		favorTasteness = 2;
		favorNutrition = 6;
		tasteness = 0;
		price = 5;
		img = null;
	}
	
	


	public ImageIcon getImg() {
		return img;
	}




	public void setImg(ImageIcon img) {
		this.img = img;
	}




	public String toString(){
		return null;}
	
	public int foodNumber(){
		return 0;
	}
}

