package myPet;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import GUI.FirstFrame;

public class MyMenu extends JMenuBar {
	
	public static final int FONT_SIZE = 20;
	public static final String FONT_NAME = "alias";
	public static final int FONT_STYLE = Font.PLAIN;
	public MyMenu() {
		super();
	}
	
	public MyMenu bulidMenu(){
		MyMenu mm = new MyMenu();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.setPlayers(new ArrayList<Player>());
				PetGame.setAnimal(null);
				PetGame.setPlayer(null);
				PetGame.setPlayerNames(new ArrayList<String>());
				PetGame.frame.setVisible(false);
				PetGame.frame = new FirstFrame("PetGame");
				PetGame.frame.setSize(1000, 800);
				PetGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MyMenu myM = new MyMenu();
				PetGame.frame.setJMenuBar(myM.bulidMenu());
				PetGame.frame.setVisible(true);		
			}
				
			}
		);
		newGame.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
		JMenuItem saveGame = new JMenuItem("Save Game");
		saveGame.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
		
		saveGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.record = "";
				PetGame.record =playersRecord(PetGame.getPlayers());
				fileIO.writeIn("save.txt", PetGame.record);
				JOptionPane.showMessageDialog(null, "Save successfully!", "Save successfully",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem loadGame = new JMenuItem("Load Game");
		loadGame.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
		loadGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String info = null;
				try{
				info = fileIO.readIn("save.txt");
				ArrayList<Player> players = readRecord(info);
				ArrayList<String> playerNames = new ArrayList<String>();
				PetGame.setPlayers(players);
				for(Player player:players){
					playerNames.add(player.getName());
				}
				PetGame.setPlayerNames(playerNames);
//				fileIO.writeIn("save.txt", PetGame.record);
				JOptionPane.showMessageDialog(null, "Load successfully!", "Load successfully",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ea){
					JOptionPane.showMessageDialog(null, "Load unsuccessfully!", "Load unsuccessfully",JOptionPane.ERROR_MESSAGE);
					ea.printStackTrace();
					return;
				}
				PetGame.frame.setVisible(false);
				PetGame.frame = new FirstFrame("PetGame");
				PetGame.frame.setSize(1000, 800);
				PetGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MyMenu myM = new MyMenu();
				PetGame.frame.setJMenuBar(myM.bulidMenu());
				PetGame.frame.setVisible(true);	
				
			}
		});
		JMenuItem quit = new JMenuItem("Quit Game");
		quit.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
		
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		JMenuItem choosePlayer = new JMenuItem("Choose Player");
		choosePlayer.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
		choosePlayer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.frame.setVisible(false);
				PetGame.frame = new FirstFrame("PetGame");
				PetGame.frame.setSize(1000, 800);
				PetGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MyMenu myM = new MyMenu();
				PetGame.frame.setJMenuBar(myM.bulidMenu());
				PetGame.frame.setVisible(true);	
				
				
			}
				
			}
		);
		fileMenu.add(newGame);
		fileMenu.add(saveGame);
		fileMenu.add(loadGame);
		fileMenu.add(choosePlayer);
		fileMenu.add(quit);
		mm.add(fileMenu);
		return mm;
	}
	
	public String animalInfoString(Animal animal){
		
		
		return animal.toString()+"@"+animal.getName()+"@"+String.valueOf(animal.getAge())+"@"+String.valueOf(animal.getWeight())+"@"+String.valueOf(animal.getHungryLevel())+"@"+String.valueOf(animal.getTiredness())+"@"+String.valueOf(animal.getPlayfulness())+"@"+String.valueOf(animal.getToiletLevel())+"@"+String.valueOf(animal.getActionNumber())+"@"+String.valueOf(animal.isMad())+"@"+String.valueOf(animal.isAlive())+"@"+String.valueOf(animal.isSick())+"@"+animal.getMood()+"@"+String.valueOf(animal.getSickDays())+"@"+String.valueOf(animal.getReviveTimes());
		
	}
	public String animalsInfoString(ArrayList<Animal> animals){
		String animalStr1 ="~";
		String animalStr2 ="~";
		String animalStr3 ="~";
		int numberOfAnimals =animals.size();
		if (numberOfAnimals == 0){
			return "0:~";
		}
		if(numberOfAnimals >= 1){
			animalStr1 = animalInfoString(animals.get(0));
		}
		if(numberOfAnimals >= 2){
			animalStr2 = animalInfoString(animals.get(1));
		}
		if(numberOfAnimals == 3){
			animalStr3 = animalInfoString(animals.get(2));
		}
		return String.valueOf(numberOfAnimals)+":"+animalStr1+":"+animalStr2+":"+animalStr3;
		
		
	}
	
	public String foodsInfoString(ArrayList<Food> foods){
		int numberOfFoods = foods.size();
		String food1Str = "~";
		String food2Str = "~";
		String food3Str = "~";
		String food4Str = "~";
		String food5Str = "~";
		String food6Str = "~";
		if(numberOfFoods == 0){
			return "0:~";
		}
		if(numberOfFoods>=1){
			food1Str=foods.get(0).toString();
		}if(numberOfFoods>=2){
			food2Str=foods.get(1).toString();
		}if(numberOfFoods>=3){
			food3Str=foods.get(2).toString();
		}if(numberOfFoods>=4){
			food4Str=foods.get(3).toString();
		}if(numberOfFoods>=5){
			food5Str=foods.get(4).toString();
		}if(numberOfFoods==6){
			food6Str=foods.get(5).toString();
		}
		return String.valueOf(numberOfFoods)+":"+food1Str+":"+food2Str+":"+food3Str+":"+food4Str+":"+food5Str+":"+food6Str;
		
	}
	
	public String toysInfoString(ArrayList<Toy> toys){
		int numberOfToys = toys.size();
		String toy1Str = "~";
		String toy2Str = "~";
		String toy3Str = "~";
		if(numberOfToys == 0){
			return "0:~";
		}
		if(numberOfToys >=1){
			toy1Str = toys.get(0).toString1()+"@"+String.valueOf(toys.get(0).durability);
			}
		if(numberOfToys >=2){
			toy2Str = toys.get(1).toString1()+"@"+String.valueOf(toys.get(1).durability);
			}
		if(numberOfToys ==3){
			toy3Str = toys.get(2).toString1()+"@"+String.valueOf(toys.get(2).durability);
			}
		
		return String.valueOf(numberOfToys)+":"+toy1Str+":"+toy2Str+":"+toy3Str;
		
	}
	public String basicPlayerInfoString(Player player1){
	return player1.getName()+":"+String.valueOf(player1.getGameDays())+":"+String.valueOf(player1.getPlayDays())+":"+String.valueOf(player1.isCanPlay())+":"+String.valueOf(player1.getAccount());	
}
	
	public String playerInfoString(Player player){
		String basic = basicPlayerInfoString(player);
		String animalsInfo = animalsInfoString(player.getAnimals());
		String foodsInfo = foodsInfoString(player.getFoods());
		String toysInfo = toysInfoString(player.getToys());
		return basic +"$"+ animalsInfo +"$"+ foodsInfo+"$"+toysInfo;
		
	}
	
	public String playersRecord(ArrayList<Player> players){
		int numberOfPlayers = players.size();
		String player1Info = "~";
		String player2Info = "~";
		String player3Info = "~";
		if(numberOfPlayers == 0){
			return "0|~";
		}
		if(numberOfPlayers >= 1){
			player1Info = playerInfoString(players.get(0));
		}
		if(numberOfPlayers >= 2){
			player2Info = playerInfoString(players.get(1));
		}
		if(numberOfPlayers ==3){
			player3Info = playerInfoString(players.get(2));
		}
		
		
		
		return String.valueOf(numberOfPlayers)+"|"+player1Info+"|"+player2Info+"|"+player3Info;
		
	}
	
	public ArrayList<Player> readRecord(String info){
		ArrayList<Player> players = new ArrayList<Player>();
		String [] playersInfo = info.trim().split("\\|");
		int numberOfPlayers = Integer.valueOf(playersInfo[0]);
		if(numberOfPlayers == 0){
			return players;
		}
		if(numberOfPlayers >=1){
			String player1Str = playersInfo[1];
	//		System.out.println(player1Str);
			Player player1 = readPlayer(player1Str);
			players.add(player1);
		}
		if(numberOfPlayers >=2){
			String player2Str = playersInfo[2];
			System.out.println(player2Str);
			Player player2 = readPlayer(player2Str);
			players.add(player2);
		}
		if(numberOfPlayers ==3){
			String player3Str = playersInfo[3];
			Player player3 = readPlayer(player3Str);
			players.add(player3);
		}
		return players;
		
	}
	
	public Player readPlayer(String playerStr){
		Player player = new Player("");
		String [] infos = playerStr.trim().split("\\$");
		String basicStr = infos[0];
		System.out.println(basicStr);
		String animalsStr = infos[1];
		System.out.println(animalsStr);
		String foodsStr = infos[2];
		System.out.println(foodsStr);
		String toysStr = infos[3];
		System.out.println(toysStr);
		String [] basicInfo = basicStr.trim().split("\\:");
		player.setName(basicInfo[0]);
		player.setGameDays(Integer.valueOf(basicInfo[1]));
		player.setPlayDays(Integer.valueOf(basicInfo[2]));
		player.setCanPlay(Boolean.valueOf(basicInfo[3]));
		player.setAccount(Integer.valueOf(basicInfo[4]));
		player.setAnimals(readAnimals(animalsStr));
//		System.out.println(animalsStr);
		player.setFoods(readFoods(foodsStr));
		player.setToys(readToys(toysStr));
		return player;
		
	}
	
	public ArrayList<Animal> readAnimals (String animalsStr){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		String[] animalsInfo = animalsStr.trim().split("\\:");
		int numberOfAnimals = Integer.valueOf(animalsInfo[0]);
		if(numberOfAnimals == 0){
			return animals;
		}
		if(numberOfAnimals >=1){
			String animalStr1 = animalsInfo[1];
			Animal animal1 = readAnimal(animalStr1);
			animals.add(animal1);
		}
		if(numberOfAnimals >=2){
			String animalStr2 = animalsInfo[2];
			Animal animal2 = readAnimal(animalStr2);
			animals.add(animal2);
		}
		if(numberOfAnimals ==3){
			String animalStr3 = animalsInfo[3];
			Animal animal3 = readAnimal(animalStr3);
			animals.add(animal3);
		}
		return animals;
	}
	
	public Animal readAnimal(String AnimalStr){
		Animal animal = new Animal("");
		String[] animalInfo = AnimalStr.trim().split("\\@");
		String animalType = animalInfo[0];
//		System.out.println(animalType);
		String name = animalInfo[1];
		if(new Cat("").toString().equals(animalType)){
			animal = new Cat(name);
		}else if(new Dog("").toString().equals(animalType)){
			animal = new Dog(name);
		}else if(new Kangaroo("").toString().equals(animalType)){
			animal = new Kangaroo(name);
		}else if(new Monkey("").toString().equals(animalType)){
			animal = new Monkey(name);
		}else if(new Squirrel("").toString().equals(animalType)){
			animal = new Squirrel(name);
		}else if(new Panda("").toString().equals(animalType)){
			animal = new Panda(name);
		}
		animal.setAge(Integer.valueOf(animalInfo[2]));
		animal.setWeight(Integer.valueOf(animalInfo[3]));
		animal.setHungryLevel(Integer.valueOf(animalInfo[4]));
		animal.setTiredness(Integer.valueOf(animalInfo[5]));
		animal.setPlayfulness(Integer.valueOf(animalInfo[6]));
		animal.setToiletLevel(Integer.valueOf(animalInfo[7]));
		animal.setActionNumber(Integer.valueOf(animalInfo[8]));
		animal.setMad(Boolean.valueOf(animalInfo[9]));
		System.out.println(animalInfo[10]);
		animal.setAlive(Boolean.valueOf(animalInfo[10]));
		animal.setSick(Boolean.valueOf(animalInfo[11]));
		animal.setMood(animalInfo[12]);
		animal.setSickDays(Integer.valueOf(animalInfo[13]));
		animal.setReviveTimes(Integer.valueOf(animalInfo[14]));
		
		return animal;
		
	}
	
	public ArrayList<Food> readFoods(String foodsStr){
		String [] foodsInfo = foodsStr.trim().split("\\:");
		ArrayList<Food> foods = new ArrayList<Food>();
		Food food1 = null;
		Food food2 = null;
		Food food3 = null;
		Food food4 = null;
		Food food5 = null;
		Food food6 = null;
		int numberOfFoods = Integer.valueOf(foodsInfo[0]);
		if(numberOfFoods==0){
			return foods;
		}
		if(numberOfFoods>=1){
			food1 = getFood(foodsInfo[1]);
			foods.add(food1);
		}
		if(numberOfFoods>=2){
			food2 = getFood(foodsInfo[2]);
			foods.add(food2);
		}
		if(numberOfFoods>=3){
			food3 = getFood(foodsInfo[3]);
			foods.add(food3);
		}
		if(numberOfFoods>=4){
			food4 = getFood(foodsInfo[4]);
			foods.add(food4);
		}
		if(numberOfFoods>=5){
			food5 = getFood(foodsInfo[5]);
			foods.add(food5);
		}
		if(numberOfFoods==6){
			food6 = getFood(foodsInfo[6]);
			foods.add(food6);
		}
		System.out.println(foods.toString());
		return foods;
		
	}
	
	public Food getFood(String FoodStr){
		Food food = null;
		if(new Fish().toString().equals(FoodStr)){
			food = new Fish();
		}
		else if(new Meat().toString().equals(FoodStr)){
			food = new Meat();
		}else if(new Chocolate().toString().equals(FoodStr)){
			food =  new Chocolate();
		}else if(new Fruit().toString().equals(FoodStr)){
			food = new Fruit();
		}else if(new Nuts().toString().equals(FoodStr)){
			food = new Nuts();
		}else if(new Bamboo().toString().equals(FoodStr)){
			food = new Bamboo();
		}
		return food;
		
	}
	
	public ArrayList<Toy> readToys(String toysStr){
		ArrayList<Toy> toys = new ArrayList<Toy>();
		String[] toysInfo =toysStr.trim().split("\\:");
		int numberOfToys = Integer.valueOf(toysInfo[0]);
		if (numberOfToys == 0){
			return toys;
		}
		if(numberOfToys>=1){
			String toy1Str = toysInfo[1];
			Toy toy1 = getToy(toy1Str);
			toys.add(toy1);
		}
		if(numberOfToys>=2){
			String toy2Str = toysInfo[2];
			Toy toy2 = getToy(toy2Str);
			toys.add(toy2);
		}
		if(numberOfToys==3){
			String toy3Str = toysInfo[3];
			Toy toy3 = getToy(toy3Str);
			toys.add(toy3);
		}
		
		return toys;
	}
	
	public Toy getToy(String toyStr){
		String[] toyInfo = toyStr.trim().split("\\@");
		String toyType = toyInfo[0];
		Toy toy = new Toy();
		int durability = Integer.valueOf(toyInfo[1]);
		if(new SandPit().toString1().equals(toyType)){
			toy = new SandPit();
		}else if(new BoneToy().toString1().equals(toyType)){
			toy = new BoneToy();
		}else if(new BoxingGlove().toString1().equals(toyType)){
			toy = new BoxingGlove();
		}else if(new Swing().toString1().equals(toyType)){
			toy = new Swing();
		}else if(new Roller().toString1().equals(toyType)){
			toy = new Roller();
		}else if(new SwimmingPool().toString1().equals(toyType)){
			toy = new SwimmingPool();
		}
		
		toy.durability = durability;
		return toy;
		
	}
	
	
}
