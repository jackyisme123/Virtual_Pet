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
import javax.swing.JTextField;

import myPet.Cat;
import myPet.Dog;
import myPet.Kangaroo;
import myPet.Monkey;
import myPet.Panda;
import myPet.PetGame;
import myPet.Squirrel;

public class PetVarietyPanel extends JPanel {
	public PetVarietyPanel(){
		Dimension size = getPreferredSize();
		size.height = 500;
		size.width = 520;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		JLabel petShop = new JLabel("Welcome to Pet Shop");
		petShop.setFont(new Font("courier",Font.BOLD,20));
		JButton cat = new JButton("cat");
		cat.setPreferredSize(new Dimension(160,160));
//		cat.setIcon(new ImageIcon("src\\pics\\cat_normal.jpg"));
		cat.setIcon(new ImageIcon(PetVarietyPanel.class.getResource("/pics/cat_normal.jpg")));
		cat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.petToBuy = new Cat("");
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				jp1.getComponent(0).setVisible(true);
				JTextField jtf = (JTextField) jp1.getComponent(1);
				jtf.setText(null);
				jp1.getComponent(1).setVisible(true);
				jp1.getComponent(2).setVisible(true);
				jp1.getComponent(3).setVisible(false);
		
			}
		});
		JButton dog = new JButton("dog");
		dog.setPreferredSize(new Dimension(160,160));
		dog.setIcon(new ImageIcon(PetVarietyPanel.class.getResource("/pics/dog_normal.jpg")));
		dog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.petToBuy = new Dog("");
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				JTextField jtf = (JTextField) jp1.getComponent(1);
				jtf.setText(null);
				jp1.getComponent(0).setVisible(true);
				jp1.getComponent(1).setVisible(true);
				jp1.getComponent(2).setVisible(true);
				jp1.getComponent(3).setVisible(false);
		
			}
		});
		JButton kangaroo = new JButton("kangaroo");
		kangaroo.setPreferredSize(new Dimension(160,160));
		kangaroo.setIcon(new ImageIcon(PetVarietyPanel.class.getResource("/pics/kangaroo_normal.jpg")));
		kangaroo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.petToBuy = new Kangaroo("");
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				JTextField jtf = (JTextField) jp1.getComponent(1);
				jtf.setText(null);
				jp1.getComponent(0).setVisible(true);
				jp1.getComponent(1).setVisible(true);
				jp1.getComponent(2).setVisible(true);
				jp1.getComponent(3).setVisible(false);
		
			}
		});
		JButton monkey = new JButton("monkey");
		monkey.setPreferredSize(new Dimension(160,160));
		monkey.setIcon(new ImageIcon(PetVarietyPanel.class.getResource("/pics/monkey_normal.jpg")));
		monkey.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.petToBuy = new Monkey("");
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				JTextField jtf = (JTextField) jp1.getComponent(1);
				jtf.setText(null);
				jp1.getComponent(0).setVisible(true);
				jp1.getComponent(1).setVisible(true);
				jp1.getComponent(2).setVisible(true);
				jp1.getComponent(3).setVisible(false);
		
			}
		});
		JButton squirrel = new JButton("squirrel");
		squirrel.setPreferredSize(new Dimension(160,160));
		squirrel.setIcon(new ImageIcon(PetVarietyPanel.class.getResource("/pics/squirrel_normal.jpg")));
		squirrel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.petToBuy = new Squirrel("");
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				JTextField jtf = (JTextField) jp1.getComponent(1);
				jtf.setText(null);
				jp1.getComponent(0).setVisible(true);
				jp1.getComponent(1).setVisible(true);
				jp1.getComponent(2).setVisible(true);
				jp1.getComponent(3).setVisible(false);
		
			}
		});
		JButton panda = new JButton("panda");
		panda.setPreferredSize(new Dimension(160,160));
		panda.setIcon(new ImageIcon(PetVarietyPanel.class.getResource("/pics/panda_normal.jpg")));
		panda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.petToBuy = new Panda("");
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				JTextField jtf = (JTextField) jp1.getComponent(1);
				jtf.setText(null);
				jp1.getComponent(0).setVisible(true);
				jp1.getComponent(1).setVisible(true);
				jp1.getComponent(2).setVisible(true);
				jp1.getComponent(3).setVisible(false);
		
			}
		});
		
		JLabel $20 = new JLabel("$20");
		JLabel $201 = new JLabel("$20");
		JLabel $202 = new JLabel("$20");
		JLabel $50 = new JLabel("$50");
		JLabel $501 = new JLabel("$50");
		JLabel $100 = new JLabel("$100");
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.2;
		gc.weighty = 0.2;
		gc.gridwidth = 3;
		
		add(petShop, gc);
		gc.gridwidth =1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 1;
		add(cat, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(dog, gc);
		gc.gridx = 2;
		gc.gridy = 1;
		add(kangaroo, gc);
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
		add(monkey, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(squirrel, gc);
		gc.gridx = 2;
		gc.gridy = 3;
		add(panda, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add($50, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add($501, gc);
		gc.gridx = 2;
		gc.gridy = 4;
		add($100, gc);
		
	}

}
