package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.Bamboo;
import myPet.Chocolate;
import myPet.Fish;
import myPet.Fruit;
import myPet.Meat;
import myPet.Nuts;
import myPet.PetGame;

public class FoodShopPanel extends JPanel {
	public FoodShopPanel(){
		Dimension size = getPreferredSize();
		size.width = 550;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		JLabel foodShop = new JLabel("Welcome to Food Shop");
		foodShop.setFont(new Font("courier",Font.BOLD,20));
		JLabel result = new JLabel();
		result.setFont(new Font("courier",Font.BOLD,20));
		result.setPreferredSize(new Dimension(500,100));
		result.setVisible(false);
		JButton fish = new JButton("fish");
		fish.setPreferredSize(new Dimension(160,160));
		fish.setIcon(new ImageIcon(FoodShopPanel.class.getResource("/pics/fish.jpg")));
		fish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<5){
					result.setText("Not enough money");
				}else if(PetGame.player.getFoods().size()>=6){
					result.setText("Maximum Food");
				}else{
					PetGame.player.addFood(new Fish());
					result.setText("Fish purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new FoodInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		JButton meat = new JButton("meat");
		meat.setPreferredSize(new Dimension(160,160));
		meat.setIcon(new ImageIcon(FoodShopPanel.class.getResource("/pics/meat.jpg")));
		meat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<5){
					result.setText("Not enough money");
				}else if(PetGame.player.getFoods().size()>=6){
					result.setText("Maximum Food");
				}else{
					PetGame.player.addFood(new Meat());
					result.setText("Meat purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new FoodInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		JButton chocolate = new JButton("chocolate");
		chocolate.setPreferredSize(new Dimension(160,160));
		chocolate.setIcon(new ImageIcon(FoodShopPanel.class.getResource("/pics/chocolate.jpg")));
		chocolate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<5){
					result.setText("Not enough money");
				}else if(PetGame.player.getFoods().size()>=6){
					result.setText("Maximum Food");
				}else{
					PetGame.player.addFood(new Chocolate());
					result.setText("Chocolate purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new FoodInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		JButton fruit = new JButton("fruit");
		fruit.setPreferredSize(new Dimension(160,160));
		fruit.setIcon(new ImageIcon(FoodShopPanel.class.getResource("/pics/fruit.jpg")));
		fruit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<5){
					result.setText("Not enough money");
				}else if(PetGame.player.getFoods().size()>=6){
					result.setText("Maximum Food");
				}else{
					PetGame.player.addFood(new Fruit());
					result.setText("Fruit purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new FoodInventoryPanel());
					jp1.setVisible(true);
					
					
					
				}
				
			}
		});
		JButton nuts = new JButton("nuts");
		nuts.setPreferredSize(new Dimension(160,160));
		nuts.setIcon(new ImageIcon(FoodShopPanel.class.getResource("/pics/nuts.jpg")));
		nuts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<5){
					result.setText("Not enough money");
				}else if(PetGame.player.getFoods().size()>=6){
					result.setText("Maximum Food");
				}else{
					PetGame.player.addFood(new Nuts());
					result.setText("Nuts purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new FoodInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		JButton bamboo = new JButton("bamboo");
		bamboo.setPreferredSize(new Dimension(160,160));
		bamboo.setIcon(new ImageIcon(FoodShopPanel.class.getResource("/pics/bamboo.jpg")));
		bamboo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<10){
					result.setText("Not enough money");
				}else if(PetGame.player.getFoods().size()>=6){
					result.setText("Maximum Food");
				}else{
					PetGame.player.addFood(new Bamboo());
					result.setText("Bamboo purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new FoodInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		JLabel $5 = new JLabel("$5");
		JLabel $51 = new JLabel("$5");
		JLabel $52 = new JLabel("$5");
		JLabel $53 = new JLabel("$5");
		JLabel $54 = new JLabel("$5");
		JLabel $10 = new JLabel("$10");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.2;
		gc.weighty = 0.2;
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 5;
		add(result, gc);
		gc.gridx = 0;
		gc.gridy = 0;
		add(foodShop, gc);
		gc.gridwidth =1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 1;
		add(fish, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(meat, gc);
		gc.gridx = 2;
		gc.gridy = 1;
		add(chocolate, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add($5, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add($51, gc);
		gc.gridx = 2;
		gc.gridy = 2;
		add($52, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(fruit, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(nuts, gc);
		gc.gridx = 2;
		gc.gridy = 3;
		add(bamboo, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add($53, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add($54, gc);
		gc.gridx = 2;
		gc.gridy = 4;
		add($10, gc);
		
		
		
		
	}
		
	}
