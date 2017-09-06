package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import myPet.PetGame;

public class AnimalPicturePanel extends JPanel {
	public AnimalPicturePanel(){
		Dimension size = getPreferredSize();
		size.height = 300;
		size.width = 520;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		JLabel choosePet = new JLabel("Choose a pet: ");
		choosePet.setFont(new Font("courier",Font.BOLD,20));
		JButton pet1 = new EmptyButton();
		pet1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.animal = null;
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				jp1.setVisible(false);
				JPanel jp2 = (JPanel) jp1.getComponent(0);
				jp1.remove(jp2);
				jp1.add(new AnimalStatusPanel());
				jp1.setVisible(true);					
			}
		});
		JButton pet2 = new EmptyButton();
		pet2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.animal = null;
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				jp1.setVisible(false);
				JPanel jp2 = (JPanel) jp1.getComponent(0);
				jp1.remove(jp2);
				jp1.add(new AnimalStatusPanel());
				jp1.setVisible(true);					
			}
		});
		JButton pet3 = new EmptyButton();
		pet3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.animal = null;
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				JPanel jp1 = (JPanel) jp.getComponent(1);
				jp1.setVisible(false);
				JPanel jp2 = (JPanel) jp1.getComponent(0);
				jp1.remove(jp2);
				jp1.add(new AnimalStatusPanel());
				jp1.setVisible(true);					
			}
		});
		
		if(PetGame.player.getAnimals().size()>=1){
			pet1 = new Pet1Button();
			if(PetGame.getPlayer().getAnimals().get(0).isAlive()){
			pet1.setIcon(PetGame.getPlayer().getAnimals().get(0).getChoose());}
			else{
				pet1.setIcon(PetGame.getPlayer().getAnimals().get(0).getDead());	
			}
			pet1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					PetGame.animal = PetGame.player.getAnimals().get(0);
					if(!PetGame.animal.isAlive()&&PetGame.animal.getReviveTimes()<1){
							int n = JOptionPane.showConfirmDialog(null, "Revive " + PetGame.animal.getName()+" ?", "Respawn with half status",JOptionPane.YES_NO_OPTION);
							if(n==0){
								PetGame.animal.reviving();
							}
							
					}
					JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
					JPanel jp3 = (JPanel) jp.getComponent(0);
					jp3.setVisible(false);
					JButton ani1 = (JButton) jp3.getComponent(1);
					JButton ani2 = (JButton) jp3.getComponent(2);
					JButton ani3 = (JButton) jp3.getComponent(3);
					if(PetGame.player.getAnimals().get(0).isAlive()){
					ani1.setIcon(PetGame.getPlayer().getAnimals().get(0).getChoose());
					}
					if(PetGame.player.getAnimals().size()>=2&&PetGame.player.getAnimals().get(1).isAlive()){
						ani2.setIcon(PetGame.getPlayer().getAnimals().get(1).getNormal());
						}
					if(PetGame.player.getAnimals().size()==3&&PetGame.player.getAnimals().get(2).isAlive()){
						ani3.setIcon(PetGame.getPlayer().getAnimals().get(2).getNormal());
						}
					
					jp3.setVisible(true);
					
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					JPanel jp2 = (JPanel) jp1.getComponent(0);
					
					jp1.remove(jp2);
					jp1.add(new AnimalStatusPanel());
					jp1.setVisible(true);					
				}
			});
		}
		if(PetGame.player.getAnimals().size()>=2){
			pet2 = new Pet2Button();
			if(PetGame.getPlayer().getAnimals().get(1).isAlive()){
			pet2.setIcon(PetGame.getPlayer().getAnimals().get(1).getNormal());}
			else{
				pet2.setIcon(PetGame.getPlayer().getAnimals().get(1).getDead());	
			}
			pet2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					PetGame.animal = PetGame.player.getAnimals().get(1);
					if(!PetGame.animal.isAlive()&&PetGame.animal.getReviveTimes()<1){
						int n = JOptionPane.showConfirmDialog(null, "Revive " + PetGame.animal.getName()+" ?", "Respawn with half status",JOptionPane.YES_NO_OPTION);
						if(n==0){
							PetGame.animal.reviving();
						}
						
				}
					JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
					JPanel jp3 = (JPanel) jp.getComponent(0);
					jp3.setVisible(false);
					JButton ani1 = (JButton) jp3.getComponent(1);
					JButton ani2 = (JButton) jp3.getComponent(2);
					JButton ani3 = (JButton) jp3.getComponent(3);
					if(PetGame.player.getAnimals().get(0).isAlive()){
					ani1.setIcon(PetGame.getPlayer().getAnimals().get(0).getNormal());}
					
					if(PetGame.player.getAnimals().get(1).isAlive()){
						ani2.setIcon(PetGame.getPlayer().getAnimals().get(1).getChoose());
					}
					if(PetGame.player.getAnimals().size()==3&&PetGame.player.getAnimals().get(2).isAlive()){
						ani3.setIcon(PetGame.getPlayer().getAnimals().get(2).getNormal());
						}
					
					jp3.setVisible(true);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					JPanel jp2 = (JPanel) jp1.getComponent(0);
					jp1.remove(jp2);
					jp1.add(new AnimalStatusPanel());
					jp1.setVisible(true);					
				}
			});
		}
		if(PetGame.player.getAnimals().size()==3){
			pet3 = new Pet3Button();
			if(PetGame.getPlayer().getAnimals().get(1).isAlive()){
				pet3.setIcon(PetGame.getPlayer().getAnimals().get(2).getNormal());
			}else{
				pet3.setIcon(PetGame.getPlayer().getAnimals().get(2).getDead());
			}
			
			pet3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					PetGame.animal = PetGame.player.getAnimals().get(2);
					if(!PetGame.animal.isAlive()&&PetGame.animal.getReviveTimes()<1){
						int n = JOptionPane.showConfirmDialog(null, "Revive " + PetGame.animal.getName()+" ?", "Respawn with half status",JOptionPane.YES_NO_OPTION);
						if(n==0){
							PetGame.animal.reviving();
						}
						
				}
					JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
					JPanel jp3 = (JPanel) jp.getComponent(0);
					jp3.setVisible(false);
					JButton ani1 = (JButton) jp3.getComponent(1);
					JButton ani2 = (JButton) jp3.getComponent(2);
					JButton ani3 = (JButton) jp3.getComponent(3);
					ani1.setIcon(PetGame.getPlayer().getAnimals().get(0).getNormal());
					
						ani2.setIcon(PetGame.getPlayer().getAnimals().get(1).getNormal());
						
						ani3.setIcon(PetGame.getPlayer().getAnimals().get(2).getChoose());
						
					
					jp3.setVisible(true);
					JPanel jp1 = (JPanel) jp.getComponent(1);
					jp1.setVisible(false);
					JPanel jp2 = (JPanel) jp1.getComponent(0);
					jp1.remove(jp2);
					jp1.add(new AnimalStatusPanel());
					jp1.setVisible(true);					
				}
			});
		}
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(choosePet, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(pet1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(pet2, gc);
		gc.gridx = 2;
		gc.gridy = 1;
		add(pet3, gc);
		
	}

}
