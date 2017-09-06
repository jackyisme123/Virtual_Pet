package myPet;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandGame {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<String> playerNames = new ArrayList<String>();

	public static void main(String[] args) {
		
		System.out.println("Hello! Welcome to Game My Pet! ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Create a new player and enter player name: ");
		String resultYN;
		do{String playerName = sc.next();
		if(CommandGame.players.size()>0 && playerName.equals("0")){
			break;
		}
		
		if(!playerNames.contains(playerName)){
		CommandGame.players.add(new Player(playerName));
		playerNames.add(playerName);
		System.out.println(playerName + " has been created");
		if(CommandGame.players.size()==3){
			System.out.println("You have got the maximum number of players");
			break;
		}
		
		}else{
			System.out.println(playerName + " has been created before, you have to change another name, or enter 0 to start game");
			continue;
		}
		do{	
		System.out.println("Would you like to add more player? Pls use lower case y or n ");
		resultYN =sc.next();
		}
		while(!resultYN.equals("y")&&!resultYN.equals("n"));
		
		
		if(resultYN.equals("y")){
			System.out.println("Create a new player and enter player name, or enter 0 to start game");
			continue;
		}else{
			break;		
		}

		}while(CommandGame.players.size() <= 2);
		
		while(allCanPlay()){
		Player a = null;
		if(CommandGame.players.size() == 1){
			a = CommandGame.players.get(0);
		}else{
			
		System.out.println("which player you'd like to choose?");
		
		for(Player player : CommandGame.players){
			System.out.println(CommandGame.players.indexOf(player)+1 +":"+player.getName1());			
		}
		System.out.println("please enter number from 1 to " + CommandGame.players.size()+", 0 to quit game");
		String playerNumStr = sc.next();
		int playerNum= -1;
		while(true){
			try{
				playerNum=Integer.parseInt(playerNumStr);
				if (playerNum < 0 || playerNum > CommandGame.players.size()) {
					System.out.println("Pls choose number from 0 to "+CommandGame.players.size()+", try again");
					playerNumStr =sc.next();
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("Pls choose number from 0 to "+CommandGame.players.size()+", try again");
				playerNumStr =sc.next();
			}
		}
		if(playerNum == 0){
			break;
		}
		a = CommandGame.players.get(playerNum-1);
		
		}
		if(a.isCanPlay()){
		a.playGame();}
		else{
			System.out.println(a.getName()+" has finished the game, pls choose another one");
			continue;
		}

	}if(!allCanPlay()){
		System.out.println("No player can play!");
	}
		
		System.out.println("Game Over!!!");
		
	}
	
	public static boolean allCanPlay(){
		for(Player player:CommandGame.players){
			if(player.isCanPlay()){
				return true;
			}
		}
		
		return false;
		
	}
}
