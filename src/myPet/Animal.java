package myPet;

import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Animal implements Eating, Playing, Sleeping, Tolieting {
	protected String species;
	private String name;
	private int age;
	private int weight;
	private int hungryLevel;
	private int tiredness;
	private int playfulness;
	private int toiletLevel;
	private int actionNumber;
	private boolean isMad;
	private boolean isAlive;
	private boolean isSick;
	private String mood;
	private int sickDays;
	private int reviveTimes;
	protected int price;
	public static final int MAX_NUM = 10;
	public static final int MIN_NUM = 0;
	public static final int AGE_SCORE = 100;
	public static final int WEIGHT_SCORE = 20;
	public String favorFood;
	public String favorToy;
	protected ImageIcon normal;
	protected ImageIcon choose;
	protected ImageIcon dead;
	public Scanner scan = new Scanner(System.in);
	// set pet original status
	// species, price, favorFood, favorToy should be override
	public Animal(String name) {
		this.name = name;
		species = "animal";
		age = 0;
		weight = 0;
		hungryLevel = 7;
		tiredness = 7;
		playfulness = 7;
		toiletLevel = 7;
		actionNumber = 0;
		isAlive = true;
		isMad = false;
		isSick = false;
		mood = "Normal";
		sickDays = 0;
		reviveTimes = 0;
		price = 0;
		favorFood = "";
		favorToy = "";
		normal = null;
		choose = null;
		dead = null;
	}
	


	public ImageIcon getNormal() {
		return normal;
	}






	public void setNormal(ImageIcon normal) {
		this.normal = normal;
	}






	public ImageIcon getChoose() {
		return choose;
	}






	public void setChoose(ImageIcon choose) {
		this.choose = choose;
	}






	public ImageIcon getDead() {
		return dead;
	}






	public void setDead(ImageIcon dead) {
		this.dead = dead;
	}






	public int getReviveTimes() {
		return reviveTimes;
	}



	public void setReviveTimes(int reviveTimes) {
		this.reviveTimes = reviveTimes;
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// pet get score by age and weight.
	public int calScore() {
		return age * AGE_SCORE + weight * WEIGHT_SCORE;
	}

	/*
	 * if pet die, score is 1/4. if pet has revived, score is 1/2.
	 */
	public int getScore() {
		if (!isAlive) {
			return calScore() / 4;
		} else if (reviveTimes > 0) {
			return calScore() / 2;
		} else {
			return calScore();
		}

	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHungryLevel() {
		return hungryLevel;
	}

	public void setHungryLevel(int hungryLevel) {
		this.hungryLevel = hungryLevel;
	}

	public int getTiredness() {
		return tiredness;
	}

	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}

	public int getPlayfulness() {
		return playfulness;
	}

	public void setPlayfulness(int playfulness) {
		this.playfulness = playfulness;
	}

	public int getToiletLevel() {
		return toiletLevel;
	}

	public void setToiletLevel(int toiletLevel) {
		this.toiletLevel = toiletLevel;
	}

	public int getActionNumber() {
		return actionNumber;
	}

	public void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

	public boolean isMad() {
		return isMad;
	}

	public void setMad(boolean isMad) {
		this.isMad = isMad;
	}

	public boolean isAlive() {
		return isAlive;
	}

	// if pet is dead, can not do any action
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
//		String resultYN;
//		if(reviveTimes>=1){
//			System.out.println(getName()+" is permanently dead!");		
//		}
//		else{
//		do{System.out.println("Do you want to revive " + getName());
//		
//		System.out.println("Pls choose lower case letter y or n");			
//		resultYN = scan.next();
//		}
//		while(!resultYN.equals("y")&&!resultYN.equals("n"));
//		if(resultYN.equals("y")){
//			reviving();
//		}}
		if(isAlive == false){
		if(this.reviveTimes<1){
		int n = JOptionPane.showConfirmDialog(null, "Revive " + this.getName()+" ?", "Respawn with half status",JOptionPane.YES_NO_OPTION);
		if(n==0){
			this.reviving();
		}
		if (!isAlive()) {
			actionNumber = 2;
		}
		}
	}
	}
	public boolean isSick() {
		return isSick;
	}

	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	@Override
	public void tolieting() {
		if (actionNumber < 2) {
			toiletLevel += 5;
			playfulness--;
			hungryLevel--;
			tiredness--;
			actionNumber++;
			if(weight!=0){
			weight--;}
			
			checkStatus();
		} else {
			System.out.println("action number >= 2");
		}
	}

	@Override
	public void sleeping() {
		if (actionNumber < 2) {
			tiredness += 5;
			playfulness--;
			hungryLevel--;
			toiletLevel--;
			actionNumber++;
			
			checkStatus();
		} else {
			System.out.println("action number >= 2");
		}
	}

	@Override
	public void playing(Toy toy) {
		if (actionNumber < 2) {
			if (favorToy.equals(toy.toString1())) {
				playfulness += toy.addFavorPlayfulness;
			} else {
				playfulness += toy.addPlayfulness;
			}
			tiredness--;
			hungryLevel--;
			toiletLevel--;
			actionNumber++;
			
			checkStatus();
			toy.durability--;
		} else {
			System.out.println("action number >= 2");
		}
	}

	@Override
	public void eating(Food food) {
		if (actionNumber < 2) {
			if (favorFood.equals(food.toString())) {
				hungryLevel += food.favorNutrition;
				toiletLevel -= food.favorNutrition / 2;
				playfulness += food.favorTasteness;
				weight+=food.favorNutrition;
			} else {
				hungryLevel += food.nutrition;
				toiletLevel -= food.nutrition / 2;
				playfulness += food.tasteness;
				tiredness--;
				weight+=food.nutrition;
			}
			actionNumber++;
			checkStatus();
		} else {
			System.out.println("action number >= 2");
		}

	}

	private void moodChange() {
		if (hungryLevel <= 3) {
			mood = "Hungry";
		} else if (tiredness <= 3) {
			mood = "Tired";
		} else if (playfulness <= 3) {
			mood = "Unhappy";
		}else if (toiletLevel <= 3) {
			mood = "Toileting";
		} else {
			mood = "Normal";
		}

	}

	public void checkStatus() {
		if (isAlive()) {
			
			moodChange();
			if (getHungryLevel() < MIN_NUM) {
				String message = getName() + " is dead of too hungry";
				JOptionPane.showMessageDialog(null, message, "Dead!",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getName() + " is dead of too hungry");
				setAlive(false);
			}
			if (getTiredness() < MIN_NUM) {
				String message = getName() + " is dead of too tired";
				JOptionPane.showMessageDialog(null, message, "Dead!",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getName() + " is dead of too tired");
				setAlive(false);
			}
			if (getToiletLevel() < MIN_NUM) {
				String message = getName() + " is dead of no toileting";
				JOptionPane.showMessageDialog(null, message, "Dead!",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getName() + " is dead of no toileting");
				setAlive(false);
			}
			if (getPlayfulness() < MIN_NUM) {
				String message = getName() + " is dead of unhappy";
				JOptionPane.showMessageDialog(null, message, "Dead!",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getName() + " is dead of unhappy");
				setAlive(false);
			}

			if (getHungryLevel() > MAX_NUM) {
				setHungryLevel(MAX_NUM);
			}

			if (getTiredness() > MAX_NUM) {
				setTiredness(MAX_NUM);
			}
			if (getToiletLevel() > MAX_NUM) {
				setToiletLevel(MAX_NUM);
			}
			if (getPlayfulness() > MAX_NUM) {
				setPlayfulness(MAX_NUM);
			}
			
		}
	}

	// pet reviving
	public void reviving() {
		
			hungryLevel = 5;
			tiredness = 5;
			playfulness = 5;
			toiletLevel = 5;
			isAlive = true;
			isMad = false;
			isSick = false;
			mood = "Normal";
			sickDays = 0;
			reviveTimes++;
			System.out.println(getName() + " has revived");
		
	}
	
	public void showStatus(){
		System.out.println("-------------------------");
		if(!isAlive){
			System.out.println(getName()+" is Dead!");
		}else{
		System.out.println("Name : " + name);
		System.out.println("Species : " + species);
		System.out.println("Age : " + age);
		System.out.println("Weight : " + weight);
		System.out.println("HungryLevel : " + hungryLevel);
		System.out.println("Tiredness : " + tiredness);
		System.out.println("Playfulness : "  + playfulness);
		System.out.println("ToiletLevel : " + toiletLevel);
		System.out.println("Mood : " + mood);
		if(isMad){
			System.out.println("Warning: "+getName()+" is Mad!");
		}if(isSick){
			System.out.println("Warning: "+getName()+" is Sick!");
		}if(hungryLevel<=3){
			System.out.println("Warning: "+getName()+" want to eat");
		}if(tiredness<=3){
			System.out.println("Warning: "+getName()+" want to sleep");
		}if(playfulness<=3){
			System.out.println("Warning: "+getName()+" want to play");
		}if(toiletLevel<=3){
			System.out.println("Warning: "+getName()+" want to toilet");
		}
		}
		System.out.println("-------------------------");
		
		
	}
	
	public int aniNumber(){
		return 0;
	}
	
	public String toString(){
		return "Animal";
	}

}
