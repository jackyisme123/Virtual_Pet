package myPet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {
	private int account;
	private ArrayList<Animal> animals;
	private ArrayList<Food> foods;
	private ArrayList<Toy> toys;
	private String name;
	private String name1 ="";
	private int gameDays = 1;
	private int playDays = -1;
	private boolean canPlay = true;
	private Random random = new Random();
	public static final int HOSPITAL_FEE = 50;
	public static final int DAMAGE_COST = 20;
	public static final int DAY_INCOME = 100;
	public Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.name1 = name;
		account = 100;
		animals = new ArrayList<Animal>();
		foods = new ArrayList<Food>();
		toys = new ArrayList<Toy>();
		}
	
	
	

	public void setAccount(int account) {
		this.account = account;
	}




	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}




	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}




	public void setToys(ArrayList<Toy> toys) {
		this.toys = toys;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setGameDays(int gameDays) {
		this.gameDays = gameDays;
	}




	public int getPlayDays() {
		return playDays;
	}




	public void setPlayDays(int playDays) {
		this.playDays = playDays;
	}




	public void setName1(String name1) {
		this.name1 = name1;
	}
	
	public String getName1() {
		return name1;
	}



	public boolean isCanPlay() {
		return canPlay;
	}



	public void setCanPlay(boolean canPlay) {
		this.canPlay = canPlay;
	}



	public int getGameDays() {
		return gameDays;
	}

	public int getAccount() {
		return account;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public ArrayList<Toy> getToys() {
		return toys;
	}

	public String getName() {
		return name;
	}

	public void addAnimal(Animal animal) {
		if (animals.size() < 3 && account >= animal.getPrice()) {
			animals.add(animal);
			System.out.println("you get a " + animal.getSpecies());
			account -= animal.getPrice();
			System.out.println("your account balance is $" + account);
		} else if (animals.size() >= 3) {
			System.out.println("too many pets");
		} else {
			System.out.println("not enough money");
		}
	}

	public void addToy(Toy toy) {
		if (toys.size() <= 3 && account >= toy.price) {
			toys.add(toy);
			System.out.println("you get a " + toy.toString());
			account -= toy.price;
			System.out.println("your account balance is $" + account);
		} else if (account < toy.price) {
			System.out.println("not enough money");
		} else {
			System.out.println("too many toys");
		}
	}

	public void removeToy(Toy toy) {
		if (toy.durability <= 0) {
			toys.remove(toy);
		}
	}

	public void addFood(Food food) {
		if (foods.size() <= 6 && account >= food.price) {
			foods.add(food);
			System.out.println("you get a " + food.toString());
			account -= food.price;
			System.out.println("your account balance is $" + account);
		} else if (account < food.price) {
			System.out.println("not enough money");
		} else {
			System.out.println("too much food");
		}
	}

	public void removeFood(Food food) {
		foods.remove(food);
	}

	public void animalEating(Animal animal, Food food) {
		animal.eating(food);
		removeFood(food);
	}

	public void animalTolieting(Animal animal) {
		animal.tolieting();
	}

	public void animalSleeping(Animal animal) {
		animal.sleeping();
	}

	public void animalPlaying(Animal animal, Toy toy) {
		animal.playing(toy);
		removeToy(toy);
	}

	public void event(Animal animal) {
		double result = randomResult(animal);

		if (result > 0.8) {
			animal.setMad(true);
//			System.out.println(animal.getName() + " is mad");
		}

		if (result < 0.2) {
			animal.setSick(true);
//			System.out.println(animal.getName() + " is sick");
		}
	}

	public Double randomResult(Animal animal) {
		double result = random.nextDouble();
		if (result >= 0.2 && animal.getMood().equals("Hungry")) {
			result += 0.2;
		} else if (result <= 0.8 && animal.getMood().equals("Tired")) {
			result -= 0.2;
		}

		return result;
	}

	public void goHospital(Animal animal) {
		if (animal.getActionNumber() >= 2) {
			System.out.println("action number >= 2");
		} else if (account < HOSPITAL_FEE) {
			System.out.println("not enough money");
		} else {
			account -= HOSPITAL_FEE;
			animal.setSick(false);
			animal.setSickDays(0);
			animal.setActionNumber(animal.getActionNumber() + 1);
			System.out.println("pay $" + HOSPITAL_FEE + " as hospital fee");
			System.out.println(animal.getName() + " is recovery");
		}
	}

	public void correctBehaviour(Animal animal) {
		if (animal.getActionNumber() >= 2) {
			System.out.println("action number >= 2");
		} else {
			animal.setMad(false);
			animal.setActionNumber(animal.getActionNumber() + 1);
			animal.setPlayfulness(animal.getPlayfulness() - 3);
			animal.checkStatus();
			System.out.println(animal.getName() + " is recovery");
		}
	}

	/*
	 * turn a day if pet is mad, 50% opportunity to attack others, you have to
	 * pay fine, or your pet will be killed. if pet is sick, calculate the sick
	 * days, if days > 2, your pet will die. if your pet is normal, random event
	 * happens. calculator the age of pets and show a total score your account
	 * will receive money
	 */
	public void nextDay() {
		for (Animal animal : animals) {
			if (animal.isAlive()) {
				if (animal.isMad()) {
					animal.setPlayfulness(animal.getPlayfulness() - 2);
					animal.checkStatus();
//					System.out.println(animal.getName() + " is mad");
					if (animal.isAlive()&&random.nextInt(10) >= 5) {
						
						System.out.println(animal.getName() + " attacks other people");
						if (account >= DAMAGE_COST) {
							String message = animal.getName() + "attacked other people!\nYou paid " +DAMAGE_COST+" for damage cost!";
							JOptionPane.showMessageDialog(null, message, "Pet Attacks!",JOptionPane.INFORMATION_MESSAGE);
							System.out.println("pay " + DAMAGE_COST + " for damage cost");
							account -= DAMAGE_COST;
						} else {
							String message = animal.getName() + "attacked other people!\nYou did not own enough money for damage cost!\n"+animal.getName()+ " was killed!";
							JOptionPane.showMessageDialog(null, message, "Pet Attacks!",JOptionPane.INFORMATION_MESSAGE);
							System.out.println("not enough money");
							System.out.println(animal.getName() + " is killed");
							animal.setAlive(false);
							if(!animal.isAlive()){
								continue;
							}
						}
					}

				}

				if (animal.isSick()) {
					animal.setPlayfulness(animal.getPlayfulness() - 2);
					animal.checkStatus();
//					System.out.println(animal.getName() + " is sick");
					animal.setSickDays(animal.getSickDays() + 1);
					if (animal.isAlive()&&animal.getSickDays() > 2) {
						System.out.println(animal.getName() + " is dead of illness");
						String message = animal.getName() + " is dead of illness";
						JOptionPane.showMessageDialog(null, message, "Dead!",JOptionPane.INFORMATION_MESSAGE);
						animal.setAlive(false);
						if(!animal.isAlive()){
							continue;
						}
					}
				}

				else {
					event(animal);
				}
				animal.setAge(animal.getAge() + 1);
			}
			if(animal.isAlive()){
			animal.setHungryLevel(animal.getHungryLevel()-1);
			animal.setPlayfulness(animal.getPlayfulness()-1);
			animal.setTiredness(animal.getTiredness()-1);
			animal.setToiletLevel(animal.getToiletLevel()-1);
			animal.checkStatus();
			}
		}
		gameDays++;
		if(checkAllPetsAlive()){
		System.out.println("You get income $" + DAY_INCOME);
		account += DAY_INCOME;
		System.out.println("Your account balance is $"+account);
		System.out.println("Your score is " + calTotalScore());
		for(Animal animal:getAnimals()){
			animal.setActionNumber(0);
			animal.showStatus();
		}
		}
		System.out.println("Day" + getGameDays());
	}

	public void buyAnimals() {
		System.out.println("Welcome to pets store");
		if (getAnimals().size() >= 3) {
			System.out.println("You've already owned 3 pets!");
			System.out.println("Thank you for visiting pets store");
			return;
		}

		while (getAnimals().size() < 3) {
			if (getAccount() < 20) {
				System.out.println("Your account does not own enough money to buy a new pet!");
				break;
			}
			

			System.out.println("Pls select your pet: ");
			System.out.println(
					"1.Cat $20\n2.Dog $20\n3.Kangaroo $20\n4.Monkey $50\n5.Squirrel $50\n6.Panda $100\n0.Quit");
			System.out.println("Pls enter a number: ");
			// throws exception if !number
			int aniNum = -1;
			aniNum = InputMismatch.inputMismatchOToSix(aniNum);
			if(aniNum ==4)	{
				if(getAccount() < 50){
					System.out.println("Your account does not own enough money to buy a Monkey!");
					continue;
				}
			}
			if(aniNum ==5)	{
				if(getAccount() < 50){
					System.out.println("Your account does not own enough money to buy a Squirrel!");
					continue;
				}
			}
			if(aniNum ==6)	{
				if(getAccount() < 100){
					System.out.println("Your account does not own enough money to buy a Panda!");
					continue;
				}
			}
			
			// if pet has already been owned, cannot but it.
			if (aniNum == 0) {
				if (getAnimals().size() == 0) {
					System.out.println("You have no pet, please select one!");
					continue;
				}
				break;
			} else {
				int flatAnimal = 0;
				for (Animal animal : getAnimals()) {
					if (aniNum == animal.aniNumber()) {
						flatAnimal = 1;
					}
				}

				if (flatAnimal == 1) {
					System.out.println("You've already owned one, try others");
					continue;
				}
			}
			
			

			System.out.println("Enter name for Pet" + (getAnimals().size() + 1));
			String petName = scan.next();
			if (aniNum == 1) {
				
				addAnimal(new Cat(petName));
			} else if (aniNum == 2) {
				addAnimal(new Dog(petName));
			} else if (aniNum == 3) {
				addAnimal(new Kangaroo(petName));
			} else if (aniNum == 4) {
				addAnimal(new Monkey(petName));
			} else if (aniNum == 5) {
				addAnimal(new Squirrel(petName));
			} else if (aniNum == 6) {
				addAnimal(new Panda(petName));
			}
			if (getAccount() < 20) {
				System.out.println("Your account does not own enough money to buy a new pet!");
				break;
			}

			if (getAnimals().size() >= 3) {
				System.out.println("Your get maximum number of pets");
				break;
			}
			String resultYN = "";
			do {
				System.out.println("Do you want to get more pet?  Pls enter lower case letter y or n");
				resultYN = scan.next();
			} while (!resultYN.equals("y") && !resultYN.equals("n"));
			if (resultYN.equals("n")) {
				break;
			} else {
				continue;
			}

		}
		System.out.println("Thank you for visiting pets store");

		for (int i = 0; i < getAnimals().size(); i++) {
			System.out.println("Status of pet " + (i + 1));
			getAnimals().get(i).showStatus();
			
		}

	}

	public void buyFood() {
		System.out.println("Welcome to food store");
		if (getFoods().size() >= 6) {
			System.out.println("You've already owned 6 food");

			System.out.println("Thank you for visiting food store");
			return;
		}
		while (getFoods().size() < 6) {
			if (getAccount() < 5) {
				System.out.println("Your account does not own enough money to buy food");
				break;
			}
			System.out.println("Pls select your food: ");
			System.out.println("1.Fish $5\n2.Meat $5\n3.Chocolate $5\n4.Fruit $5\n5.Nuts $5\n6.Bamboo $10\n0.Quit");
			System.out.println("Pls enter a number: ");
			// throws exception if !number
			int foodNum = -1;
			foodNum = InputMismatch.inputMismatchOToSix(foodNum);
			if (foodNum == 1) {
				addFood(new Fish());
			} else if (foodNum == 2) {
				addFood(new Meat());
			} else if (foodNum == 3) {
				addFood(new Chocolate());
			} else if (foodNum == 4) {
				addFood(new Fruit());
			} else if (foodNum == 5) {
				addFood(new Nuts());
			} else if (foodNum == 6) {
				addFood(new Bamboo());
			} else if (foodNum == 0) {
				break;
			} else {
				System.out.println("Pls choose number from 0 to 6, try again");
				continue;
			}

			if (getAccount() < 5) {
				System.out.println("Your account does not own enough money to buy food");
				break;
			}
			if (getFoods().size() >= 6) {
				System.out.println("Your get maximum number of food");
				break;
			}
			String resultYN = "";
			do {
				System.out.println("Do you want to get more food?  Pls enter lower case letter y or n");
				resultYN = scan.next();
			} while (!resultYN.equals("y") && !resultYN.equals("n"));
			if (resultYN.equals("n")) {
				break;
			} else {
				continue;
			}

		}

		System.out.println("Thank you for visiting food store");

		System.out.println("Pet food owned as below: ");
		for (int i = 0; i < getFoods().size(); i++) {

			System.out.println(i + 1 + ": " + getFoods().get(i).toString());
		}
		System.out.println("-------------------------");

	}

	public void buyToy() {
		System.out.println("Welcome to toy store");
		if (getToys().size() >= 3) {
			System.out.println("You've already owned 3 toys");

			System.out.println("Thank you for visiting toy store");
			return;
		}
		while (getToys().size() < 3) {
			if (getAccount() < 20) {
				System.out.println("Your account does not own enough money to buy a new toy");
				break;
			}
			System.out.println("Pls select your toy: ");
			System.out.println(
					"1.SandPit $20\n2.BoneToy $20\n3.BoxingGlove $20\n4.Swing $20\n5.Roller $20\n6.SwimmingPool $150\n0.Quit");
			System.out.println("Pls enter a number: ");
			// throws exception if !number
			int toyNum = -1;
			toyNum=InputMismatch.inputMismatchOToSix(toyNum);
			if (toyNum == 1) {
				addToy(new SandPit());
			} else if (toyNum == 2) {
				addToy(new BoneToy());
			} else if (toyNum == 3) {
				addToy(new BoxingGlove());
			} else if (toyNum == 4) {
				addToy(new Swing());
			} else if (toyNum == 5) {
				addToy(new Roller());
			} else if (toyNum == 6) {
				addToy(new SwimmingPool());
			} else if (toyNum == 0) {
				break;
			} else {
				System.out.println("Pls choose number from 0 to 6, try again");
				continue;
			}

			if (getAccount() < 20) {
				System.out.println("Your account does not own enough money to buy a new toy");
				break;
			}
			if (getToys().size() >= 3) {
				System.out.println("Your get maximum number of toys");
				break;
			}
			String resultYN = "";
			do {
				System.out.println("Do you want to get more toy?  Pls enter lower case letter y or n");
				resultYN = scan.next();
			} while (!resultYN.equals("y") && !resultYN.equals("n"));
			if (resultYN.equals("n")) {
				break;
			} else {
				continue;
			}

		}

		System.out.println("Thank you for visiting toy store");

		System.out.println("Pet toys owned as below: ");
		for (int i = 0; i < getToys().size(); i++) {

			System.out.println(i + 1 + ": " + getToys().get(i).toString());
		}
		System.out.println("-------------------------");
	}

	public void petAction() {
		if(!checkAllPetsAction()){
			System.out.println("No pet owns action today");
			return;
		}
		ArrayList<Animal> canActionPets;
		
		while(checkAllPetsAction()){
		canActionPets = new ArrayList<Animal>();
		for(Animal animal:getAnimals()){
			if(animal.getActionNumber()<2){
				canActionPets.add(animal);
			}
		}
		if(canActionPets.size()==1){
			doAction(canActionPets.get(0));
		}else{
		
		
		System.out.println("Please choose a pet");
		
		
		for (int i = 0; i < canActionPets.size(); i++) {
			System.out.println((i + 1) + "." + getAnimals().get(i).getName());
		}
		//throws exception(! number)
		int animalNum = scan.nextInt();
		while(animalNum-1>=canActionPets.size() || animalNum -1 < 0){
			System.out.println("please enter number from list above, try again");
			animalNum = scan.nextInt();
		}
		doAction(canActionPets.get(animalNum-1));
		}
		if(!checkAllPetsAction()){
			System.out.println("No pet owns action today");
			return;
		}else if(getAnimals().size()!=1){
			String resultYN = "";
			do {
				System.out.println("Some pets still own at least one action oppotunity, do you want to try more  y or n");
				resultYN = scan.next();
			} while (!resultYN.equals("y") && !resultYN.equals("n"));
			if (resultYN.equals("n")) {
				break;
			} else {
				continue;
			}
		}
		
		}
		}
	

	public void doAction(Animal animal) {
		if (!animal.isAlive()) {
			System.out.println(animal.getName() + " is dead, cannot action anymore!!!");
			return;
		} else if (animal.getActionNumber() >= 2) {
			System.out.println(animal.getName() + " reaches maximum action numbers today");
			return;
		} else {
			
			while (animal.getActionNumber() < 2) {
				System.out.println("Which kind of actions you'd like " + animal.getName() + " to do");
				if (animal.isMad() && animal.isSick()) {
					System.out.println(
							"1.Eating\n2.Playing\n3.Tolieting\n4.Sleeping\n5.GoingHospital\n6.CorrectingBehaviour\n0.quit");
				} else if (animal.isSick()) {
					System.out.println("1.Eating\n2.Playing\n3.Tolieting\n4.Sleeping\n5.GoingHospital\n0.quit");
				} else if (animal.isMad()) {
					System.out.println("1.Eating\n2.Playing\n3.Tolieting\n4.Sleeping\n6.CorrectingBehaviour\n0.quit");
				} else {
					System.out.println("1.Eating\n2.Playing\n3.Tolieting\n4.Sleeping\n0.quit");
				}
				int actionNum = scan.nextInt();
				if (actionNum == 1) {
					if (getFoods().size() > 0) {
						System.out.println("Which kind of food you'd like to feed " + animal.getName());

						for (int i = 0; i < getFoods().size(); i++) {
							System.out.println((i + 1) + "." + getFoods().get(i));
						}
						int foodNum = scan.nextInt();
						// Throws Exception(!number)
						while (foodNum - 1 >= getFoods().size()) {
							System.out.println("please enter number from list above, try again");
							foodNum = scan.nextInt();
						}
						animalEating(animal, getFoods().get(foodNum - 1));
						animal.showStatus();
					} else {
						System.out.println("No food, pls visit food shop");
						buyFood();
						continue;
					}

				} else if (actionNum == 2) {
					if (getToys().size() > 0) {
						System.out.println("Which kind of toys you'd like to give to" + animal.getName());
						for (int j = 0; j < getToys().size(); j++) {
							System.out.println((j + 1) + "." + getToys().get(j));
						}
						int toyNum = scan.nextInt();
						// Throws Exception(!number)
						while (toyNum - 1 >= getToys().size()) {
							System.out.println("please enter number from list above, try again");
							toyNum = scan.nextInt();
						}
						animalPlaying(animal, getToys().get(toyNum - 1));
						animal.showStatus();
					} else {
						System.out.println("No toy, pls visit toy shop");
						buyToy();
						continue;
					}
				} else if (actionNum == 3) {
					animalTolieting(animal);
					animal.showStatus();
				} else if (actionNum == 4) {
					animalSleeping(animal);
					animal.showStatus();
				} else if (actionNum == 5) {
					if (animal.isSick()) {
						goHospital(animal);
						animal.showStatus();
					} else {
						System.out.println(animal.getName() + " do not need to go hospital");
					}
				} else if (actionNum == 6) {
					if (animal.isMad()) {
						correctBehaviour(animal);
						animal.showStatus();
					} else {
						System.out.println(animal.getName() + " do not need to correct behaviour");
					}
				} else if (actionNum == 0) {
					return;
				} else {
					System.out.println("Pls choose number from 0 to 6, try again!");
					continue;
				}
				//System.out.println(animal.getName()+": action# is"+animal.getActionNumber());

				if (animal.getActionNumber() < 2) {
					String resultYN = "";
					do {
						System.out.println("Let "+ animal.getName()+" do another action?  Pls enter lower case letter y or n");
						resultYN = scan.next();
					} while (!resultYN.equals("y") && !resultYN.equals("n"));
					if (resultYN.equals("n")) {
						break;
					} else {
						continue;
					}
				} else {
					System.out.println(animal.getName() + " reaches maximum action numbers today");
					return;
				}

			}
		}
	}
	
	
	public boolean checkAllPetsAlive(){
		for(Animal animal:getAnimals()){
			if(animal.isAlive()){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkAllPetsAction(){
		for(Animal animal:getAnimals()){
			if(animal.isAlive() && animal.getActionNumber()<2){
				return true;
			}
		}
		return false;
	}
	
	public int calTotalScore(){
		int result = 0;
		for(Animal animal:getAnimals()){
			result += animal.getScore();
		}
		
		return result;
	}
	
	
	public void playGame(){
		if(playDays==-1){
		
		System.out.println("Hi "+getName()+", How many days do you want to play: ");
        
        playDays = InputMismatch.inputMismatchOneToTwenty(playDays);
		buyAnimals();
		System.out.println("Day1");
		
		}else{
			System.out.println("Your account balance is $"+account);
			System.out.println("Your score is " + calTotalScore());
			for(Animal animal:getAnimals()){
				animal.showStatus();
			}
			System.out.println("Day" + getGameDays());
			
		}
		while (getGameDays() <= playDays) {
			if (!checkAllPetsAlive()) {
					System.out.println("All PETS DIE");
					System.out.println(getName()+" LOSE THE GAME!");
					System.out.println("SCORE IS " + calTotalScore());
					setCanPlay(false);
					setName1(getName1() + " is over");
					return;
				}
				System.out.println("Hi " + getName() + ", what do you want to do today?");
				System.out.println("1.Buy food\n2.Buy toy\n3.Buy Pet\n4.Pet action\n5.Turn day\n6.Switch player");
				int num = -1;
				num = InputMismatch.inputMismatchOneToSix(num);
				if (num == 1) {
					
					buyFood();
				}else if(num ==2){
					buyToy();
				}else if(num == 3){
					buyAnimals();
				}else if(num ==4){
					petAction();
				}else if(num ==5){
					nextDay();
				
			}else if(num ==6){
				return;
			}
				
				if (!checkAllPetsAlive()) {
					System.out.println("All PETS DIE");
					System.out.println(getName()+" LOSE THE GAME!");
					System.out.println("SCORE IS " + calTotalScore());
					setCanPlay(false);
					setName1(getName1() + " is over");
					return;
				}
				
				

		}

		System.out.println(getName()+" WIN!");
		System.out.println("CONGRATULATIONS!");
		System.out.println("SCORE IS " + calTotalScore());
		setCanPlay(false);
		setName1(getName1() + " is over");

	}

	}
	
	


