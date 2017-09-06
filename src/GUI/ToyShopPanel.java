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

import myPet.BoneToy;
import myPet.BoxingGlove;
import myPet.PetGame;
import myPet.Roller;
import myPet.SandPit;
import myPet.SwimmingPool;
import myPet.Swing;

public class ToyShopPanel extends JPanel {

	public ToyShopPanel(){
		Dimension size = getPreferredSize();
		size.width = 550;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		JLabel toyShop = new JLabel("Welcome to Toy Shop");
		toyShop.setFont(new Font("courier",Font.BOLD,20));
		JLabel result = new JLabel();
		result.setFont(new Font("courier",Font.BOLD,20));
		result.setPreferredSize(new Dimension(500,100));
		result.setVisible(false);
		
		JButton sandPit = new JButton("sandpit");
		sandPit.setPreferredSize(new Dimension(160,160));
		sandPit.setIcon(new ImageIcon(ToyShopPanel.class.getResource("/pics/sandpit.jpg")));
		sandPit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<20){
					result.setText("Not enough money");
				}else if(PetGame.player.getToys().size()>=3){
					result.setText("Maximum Toys");
				}else{
					PetGame.player.addToy(new SandPit());
					result.setText("SandPit purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(2);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new ToyInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		
		JButton boneToy = new JButton("bonetoy");
		boneToy.setPreferredSize(new Dimension(160,160));
		boneToy.setIcon(new ImageIcon(ToyShopPanel.class.getResource("/pics/bonetoy.jpg")));
		boneToy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<20){
					result.setText("Not enough money");
				}else if(PetGame.player.getToys().size()>=3){
					result.setText("Maximum Toys");
				}else{
					PetGame.player.addToy(new BoneToy());
					result.setText("BoneToy purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(2);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new ToyInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		
		JButton boxingGlove = new JButton("boxingglove");
		boxingGlove.setPreferredSize(new Dimension(160,160));
		boxingGlove.setIcon(new ImageIcon(ToyShopPanel.class.getResource("/pics/boxingglove.jpg")));
		boxingGlove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<20){
					result.setText("Not enough money");
				}else if(PetGame.player.getToys().size()>=3){
					result.setText("Maximum Toys");
				}else{
					PetGame.player.addToy(new BoxingGlove());
					result.setText("BoxingGlove purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(2);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new ToyInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		
		JButton swing = new JButton("swing");
		swing.setPreferredSize(new Dimension(160,160));
		swing.setIcon(new ImageIcon(ToyShopPanel.class.getResource("/pics/swing.jpg")));
		swing.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<20){
					result.setText("Not enough money");
				}else if(PetGame.player.getToys().size()>=3){
					result.setText("Maximum Toys");
				}else{
					PetGame.player.addToy(new Swing());
					result.setText("Swing purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(2);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new ToyInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		
		JButton roller = new JButton("roller");
		roller.setPreferredSize(new Dimension(160,160));
		roller.setIcon(new ImageIcon(ToyShopPanel.class.getResource("/pics/roller.jpg")));
		roller.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<20){
					result.setText("Not enough money");
				}else if(PetGame.player.getToys().size()>=3){
					result.setText("Maximum Toys");
				}else{
					PetGame.player.addToy(new Roller());
					result.setText("Roller purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(2);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new ToyInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		
		JButton swimmingPool = new JButton("swimmingpool");
		swimmingPool.setPreferredSize(new Dimension(160,160));
		swimmingPool.setIcon(new ImageIcon(ToyShopPanel.class.getResource("/pics/swimmingpool.jpg")));
		swimmingPool.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(true);
				if (PetGame.player.getAccount()<150){
					result.setText("Not enough money");
				}else if(PetGame.player.getToys().size()>=3){
					result.setText("Maximum Toys");
				}else{
					PetGame.player.addToy(new SwimmingPool());
					result.setText("SwimmingPool purchase successfully");
					JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
					account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
					JPanel jp =(JPanel) PetGame.frame.getContentPane().getComponent(2);
					JPanel jp1 = (JPanel) jp.getComponent(2);
					jp1.setVisible(false);
					jp1.removeAll();
					jp1.add(new ToyInventoryPanel());
					jp1.setVisible(true);
					
				}
				
			}
		});
		
		JLabel $20 = new JLabel("$20");
		JLabel $201 = new JLabel("$20");
		JLabel $202 = new JLabel("$20");
		JLabel $203 = new JLabel("$20");
		JLabel $204 = new JLabel("$20");
		JLabel $150 = new JLabel("$150");
		
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
		add(toyShop, gc);
		gc.gridwidth =1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 1;
		add(sandPit, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(boneToy, gc);
		gc.gridx = 2;
		gc.gridy = 1;
		add(boxingGlove, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add($20, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add($201, gc);
		gc.gridx = 2;
		gc.gridy = 2;
		add($202, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(swing, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(roller, gc);
		gc.gridx = 2;
		gc.gridy = 3;
		add(swimmingPool, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add($203, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add($204, gc);
		gc.gridx = 2;
		gc.gridy = 4;
		add($150, gc);
	}
}
