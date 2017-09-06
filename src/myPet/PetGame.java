package myPet;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import GUI.FirstFrame;

public class PetGame {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<String> playerNames = new ArrayList<String>();
	public static int highScore = 0;
	public static String highScoreName = null;
	public static Player player;
	
	public static JFrame frame;
	
	public static Animal animal = null;
	
	public static Animal petToBuy = null;
	
	public static String record = null;
	
	public static Animal getAnimal() {
		return animal;
	}

	public static void setAnimal(Animal animal) {
		PetGame.animal = animal;
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		PetGame.player = player;
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(ArrayList<Player> players) {
		PetGame.players = players;
	}

	public static ArrayList<String> getPlayerNames() {
		return playerNames;
	}

	public static void setPlayerNames(ArrayList<String> playerNames) {
		PetGame.playerNames = playerNames;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
//				Player p = new Player("xiaowang");
//				p.setPlayDays(5);
//				p.addFood(new Fish());
//				p.addFood(new Fish());
//				p.addFood(new Meat());
//				p.addFood(new Fish());
//				p.addToy(new SandPit());
//				p.addToy(new Swing());
//				p.addToy(new Swing());
//				PetGame.player = p;
//				player.addAnimal(new Cat("mimi"));
//				player.getAnimals().get(0).setSick(true);
//				player.getAnimals().get(0).setMad(true);
				frame = new FirstFrame("PETS WORLD");
//				frame = new MainFrame("PETS WORLD");
//				frame = new WinFrame("PETS WORLD");
//				frame = new LostFrame("PETS WORLD");
				frame.setSize(1000, 800);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				MyMenu myM = new MyMenu();
				frame.setJMenuBar(myM.bulidMenu());
			}
		});
	}
}
