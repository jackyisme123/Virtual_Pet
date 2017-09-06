package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import myPet.Food;
import myPet.PetGame;
import myPet.Toy;

public class ActionOptionPanel extends JPanel {

	public ActionOptionPanel(){
		Dimension size = getPreferredSize();
		size.height = 380;
		size.width = 520;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		JLabel actionNo = new JLabel();
		actionNo.setFont(new Font("courier",Font.BOLD,20));
		if(PetGame.player.getAnimals().size()>0){
		actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
		}else{
			actionNo.setText("No Pet!");	
		}
		
		JLabel result = new JLabel();
		
		JButton eating = new JButton("eating");
		eating.setPreferredSize(new Dimension(100,100));
		eating.setIcon(new ImageIcon(ActionOptionPanel.class.getResource("/pics/eat.jpg")));
		eating.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.animal==null){
					result.setText("No PET!!!");
				}else if(!PetGame.animal.isAlive()){
					result.setText(PetGame.animal.getName()+" is dead!");
				}else if(PetGame.player.getFoods().size()<=0){
					result.setText("No FOOD!!!");
				}else if(PetGame.animal.getActionNumber()>=2){
					result.setText("Maximum Action Number!!!");
				}else{
					ArrayList<Food> foods = PetGame.player.getFoods();
					
					String[] foodchosen = new String[foods.size()]; 
					
					int i = 0;
					for(Food food:foods){
						foodchosen[i] = food.toString();
						i++;
					}
				    int response = JOptionPane.showOptionDialog(null,
				              "choose food", "choose food", JOptionPane.YES_OPTION,
				              JOptionPane.QUESTION_MESSAGE, null, foodchosen, foodchosen[0]);
				       Food food = null;
				       if(response >-1){
				       	food = PetGame.player.getFoods().get(response);}
				       else{
				    	   return;
				       }
				    	  PetGame.player.animalEating(PetGame.animal, food);
				    	  //if food = pet's fav food , print yummy
				    	  if(food.toString().equals(PetGame.animal.favorFood)){
				    		  result.setText("Yummy! Yummy!"); 
				    	  }else{
				    	  //else print Better than nothing!
				    	  result.setText("Better than nothing!");}
				    	  actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
				    	  JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
							JPanel jp1 = (JPanel) jp.getComponent(1);
							jp1.setVisible(false);
							jp1.removeAll();
							jp1.add(new FoodInventoryPanel());
							jp1.setVisible(true);
				}
				
			}
		});
		JButton sleeping = new JButton("sleeping");
		sleeping.setPreferredSize(new Dimension(100,100));
		sleeping.setIcon(new ImageIcon(ActionOptionPanel.class.getResource("/pics/sleep.jpg")));
		sleeping.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.animal==null){
					result.setText("No PET!!!");
			}else if(!PetGame.animal.isAlive()){
				result.setText(PetGame.animal.getName()+" is dead!");
			}else if(PetGame.animal.getActionNumber()>=2){
				result.setText("Maximum Action Number!!!");
			}else{
				PetGame.player.animalSleeping(PetGame.animal);
				result.setText("Zzzzz,Zzzzz,Zzzzz"); 

		    	actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
			}
			}
		});
		
		JButton tolieting = new JButton("tolieting");
		tolieting.setPreferredSize(new Dimension(100,100));
		tolieting.setIcon(new ImageIcon(ActionOptionPanel.class.getResource("/pics/toilet.jpg")));
		tolieting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.animal==null){
					result.setText("No PET!!!");
			}else if(!PetGame.animal.isAlive()){
				result.setText(PetGame.animal.getName()+" is dead!");
			}else if(PetGame.animal.getActionNumber()>=2){
				result.setText("Maximum Action Number!!!");
			}else{
				PetGame.player.animalTolieting(PetGame.animal);
				result.setText("Feeling Good!"); 
		    	actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
				
			}
			}
		});
		
		JButton playing = new JButton("playing");
		playing.setPreferredSize(new Dimension(100,100));
		playing.setIcon(new ImageIcon(ActionOptionPanel.class.getResource("/pics/play.jpg")));
		playing.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.animal == null){
					result.setText("No PET!!!");
				}else if(!PetGame.animal.isAlive()){
					result.setText(PetGame.animal.getName()+" is dead!");
				}else if(PetGame.player.getToys().size()<=0){
					result.setText("No Toy!!!");
				}else if(PetGame.animal.getActionNumber()>=2){
					result.setText("Maximum Action Number!!!");
				}else{
					ArrayList<Toy> toys = PetGame.player.getToys();
					
					String[] toychosen = new String[toys.size()]; 
					
					int i = 0;
					for(Toy toy:toys){
						toychosen[i] = toy.toString();
						i++;
					}
					
					
				       int response = JOptionPane.showOptionDialog(null,
				              "choose toy", "choose toy", JOptionPane.YES_OPTION,
				              JOptionPane.QUESTION_MESSAGE, null, toychosen, toychosen[0]);
				       Toy toy = null;
				       if(response > -1){
				       	toy = PetGame.player.getToys().get(response);}
				       else{
				    	   return;
				       }
				    	  PetGame.player.animalPlaying(PetGame.animal, toy);
				    	  //if toy = pet's fav toy , print WaHaHaHaHaHa
				    	  if(toy.toString1().equals(PetGame.animal.favorToy)){
				    		  result.setText("WaHaHaHaHaHa!"); 
				    	  }else{
				    	  //else print Better than nothing!
				    	  result.setText("Better than nothing!");}
				    	  actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
				    	  JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
							JPanel jp1 = (JPanel) jp.getComponent(2);
							jp1.setVisible(false);
							jp1.removeAll();
							jp1.add(new ToyInventoryPanel());
							jp1.setVisible(true);
				}
				
			}
		});
		
		JButton hospital = new JButton("hospital");
		hospital.setPreferredSize(new Dimension(100,100));
		hospital.setIcon(new ImageIcon(ActionOptionPanel.class.getResource("/pics/hospital.jpg")));
		hospital.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.animal==null){
					result.setText("No PET!!!");
			}else if(!PetGame.animal.isAlive()){
				result.setText(PetGame.animal.getName()+" is dead!");
			}else if(PetGame.animal.getActionNumber()>=2){
				result.setText("Maximum Action Number!!!");
			}else if(!PetGame.animal.isSick()){
				result.setText("I'm Healthy!");
			}else if(PetGame.player.getAccount()<50){
				result.setText("Not enough money");
			}else{
				PetGame.player.goHospital(PetGame.animal);
				result.setText("Recovery, cost $50");
		    	actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
		    	JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
				account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
			}
				
				
			}
		});
		
		JButton correctBehaviour = new JButton("correctBehaviour");
		correctBehaviour.setPreferredSize(new Dimension(100,100));
		correctBehaviour.setIcon(new ImageIcon(ActionOptionPanel.class.getResource("/pics/correctbehaviour.jpg")));
		correctBehaviour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PetGame.animal == null){
					result.setText("No PET!!!");
			}else if(!PetGame.animal.isAlive()){
				result.setText(PetGame.animal.getName()+" is dead!");
			}else if(PetGame.animal.getActionNumber()>=2){
				result.setText("Maximum Action Number!!!");
			}else if(!PetGame.animal.isMad()){
				result.setText("I'm Normal!");
			}else{
				PetGame.player.correctBehaviour(PetGame.animal);
				result.setText("Getting Normal!");
		    	actionNo.setText("Used Action Number: "+PetGame.animal.getActionNumber());
		    	
			}
				
				
			}
		});
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridwidth = 3;
		gc.weightx = 0.2;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.gridy = 0;
		add(actionNo, gc);
		
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		add(eating, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(sleeping, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(tolieting, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(playing, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(hospital, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(correctBehaviour, gc);
		
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 3;
		add(result, gc);
		
		
	}
}
