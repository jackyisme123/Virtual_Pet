package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import myPet.Animal;
import myPet.MyMenu;
import myPet.PetGame;
import myPet.fileIO;

public class CommandPanel extends JPanel {
	
	public CommandPanel(){
		Dimension size = getPreferredSize();
		size.width = 150;
		setPreferredSize(size);
		setBackground(new Color(201,186,31));
		JButton home = new JButton("Home");
		home.setPreferredSize(new Dimension(100,100));
		home.setIcon(new ImageIcon(CommandPanel.class.getResource("/pics/home.jpg")));
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = PetGame.frame.getContentPane();
				c.setVisible(false);
				JPanel jp =  (JPanel) c.getComponent(1);
				c.remove(jp);
				JPanel home = new HomePanel();
				c.add(home, BorderLayout.CENTER);
				c.setComponentZOrder(home, 1);
				c.setVisible(true);
				
				
			}
		});
		JButton petShop = new JButton("PetShop");
		petShop.setPreferredSize(new Dimension(100,100));
		petShop.setIcon(new ImageIcon(CommandPanel.class.getResource("/pics/petshop.jpg")));
		petShop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = PetGame.frame.getContentPane();
				c.setVisible(false);
				JPanel jp =  (JPanel) c.getComponent(1);
				c.remove(jp);
				JPanel petShop = new PetShopPanel();
				c.add(petShop, BorderLayout.CENTER);
				c.setComponentZOrder(petShop, 1);
				c.setVisible(true);
				
				
			}
		});
		JButton foodShop = new JButton("FoodShop");
		foodShop.setPreferredSize(new Dimension(100,100));
		foodShop.setIcon(new ImageIcon(CommandPanel.class.getResource("/pics/foodshop.jpg")));
		foodShop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = PetGame.frame.getContentPane();
				c.setVisible(false);
				JPanel jp =  (JPanel) c.getComponent(1);
				c.remove(jp);
				JPanel foodShop = new FoodShopPanel();
				c.add(foodShop, BorderLayout.CENTER);
				c.setComponentZOrder(foodShop, 1);
				c.setVisible(true);
				
				
			}
		});
		JButton toyShop = new JButton("ToyShop");
		toyShop.setPreferredSize(new Dimension(100,100));
		toyShop.setIcon(new ImageIcon(CommandPanel.class.getResource("/pics/toyshop.jpg")));
		toyShop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = PetGame.frame.getContentPane();
				c.setVisible(false);
				JPanel jp =  (JPanel) c.getComponent(1);
				c.remove(jp);
				JPanel toyShop = new ToyShopPanel();
				c.add(toyShop, BorderLayout.CENTER);
				c.setComponentZOrder(toyShop, 1);
				c.setVisible(true);
				
				
			}
		});
		JButton action = new JButton("Action");
		action.setPreferredSize(new Dimension(100,100));
		action.setIcon(new ImageIcon(CommandPanel.class.getResource("/pics/action.jpg")));
		action.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.player.getAnimals().size()<=0){
					JOptionPane.showMessageDialog(null, "You should own at least one pet!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Container c = PetGame.frame.getContentPane();
				c.setVisible(false);
				JPanel jp =  (JPanel) c.getComponent(1);
				c.remove(jp);
				JPanel action = new ActionPanel();
				c.add(action, BorderLayout.CENTER);
				c.setComponentZOrder(action, 1);
				c.setVisible(true);
				
				
			}
		});
		JButton nextDay = new JButton("NextDay");
		nextDay.setPreferredSize(new Dimension(100,100));
		nextDay.setIcon(new ImageIcon(CommandPanel.class.getResource("/pics/nextday.jpg")));
		nextDay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.player.getAnimals().size()<=0){
					JOptionPane.showMessageDialog(null, "You should own at least one pet!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					return;
				}
				PetGame.player.nextDay();
				JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
				account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
				Container c = PetGame.frame.getContentPane();
				c.setVisible(false);
				JPanel jp =  (JPanel) c.getComponent(1);
				JPanel jp1 = (JPanel) c.getComponent(2);
				JPanel day = (JPanel) jp1.getComponent(0);
				JLabel day2 = (JLabel) day.getComponent(1);
				day2.setText(String.valueOf(PetGame.player.getGameDays()));

				
				c.remove(jp);
				JPanel home = new HomePanel();
				c.add(home, BorderLayout.CENTER);
				c.setComponentZOrder(home, 1);
				c.setVisible(true);	
				
				String info = null;
				try{
				info = fileIO.readIn("hs.txt");}
				catch(Exception ea){
					info = "0";
				}
				if(info.equals("0")){
					PetGame.highScore = 0;
				}else{
				String [] infomation = info.trim().split(":");
				PetGame.highScoreName = infomation[0];
				PetGame.highScore = Integer.valueOf(infomation[1]);}
				int currentScore = PetGame.player.calTotalScore();
				if(currentScore > PetGame.highScore){
					PetGame.highScore = currentScore;
					PetGame.highScoreName = PetGame.player.getName();
				}
				String fileContent = PetGame.highScoreName +":" +String.valueOf(PetGame.highScore);
				fileIO.writeIn("hs.txt", fileContent);
				
				
				if(!PetGame.player.checkAllPetsAlive()){
					PetGame.frame.setVisible(false);
					PetGame.frame = new LostFrame("PetGame");
					PetGame.frame.setSize(1000, 800);
					PetGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					MyMenu myM = new MyMenu();
					PetGame.frame.setJMenuBar(myM.bulidMenu());
					PetGame.frame.setVisible(true);	
				}
				else if(PetGame.player.getGameDays()>PetGame.player.getPlayDays()){
					PetGame.frame.setVisible(false);
					PetGame.frame = new WinFrame("PetGame");
					PetGame.frame.setSize(1000, 800);
					PetGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					MyMenu myM = new MyMenu();
					PetGame.frame.setJMenuBar(myM.bulidMenu());
					PetGame.frame.setVisible(true);	
				}
				String message = "";
				for(Animal ani:PetGame.player.getAnimals()){
					if(!ani.isAlive()){
						message += ani.getName() + " is Dead! :(\n";
					}else{
					if(ani.getHungryLevel()<=3){
						message += ani.getName() + " want to eat!\n";
					}
					if(ani.getTiredness()<=3){
						message += ani.getName() +" want to sleep!\n";
					}
					if(ani.getToiletLevel()<=3){
						message += ani.getName() +" want to toilet!\n";
					}
					if(ani.getPlayfulness()<=3){
						message += ani.getName()+" want to play!\n";
					}
					if(ani.isSick()){
						message += ani.getName()+ " is sick for "+(ani.getSickDays()+1)+ " day(s)!\n";
					}if (ani.isMad()){
						message += ani.getName() + " is mad!\n";
					}
				}
				}
				if(message == ""||message.equals("")){
					message = "Calm Day! Nothing happened!";
				}
				JOptionPane.showMessageDialog(null, message, "Pet Daily Log", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(home, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(petShop, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add(foodShop, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		add(toyShop, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		add(action, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		add(nextDay, gc);
		
	}
}
