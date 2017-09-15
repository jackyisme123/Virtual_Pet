package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.PetGame;

public class Player3Panel extends PlayerInfoPanel {
	
	public Player3Panel(){
	name1.setText(PetGame.getPlayers().get(2).getName());
	petsNo1.setText(String.valueOf(PetGame.getPlayers().get(2).getAnimals().size()));
	playDays1.setText(String.valueOf(PetGame.getPlayers().get(2).getGameDays())+"("+String.valueOf(PetGame.getPlayers().get(2).getPlayDays())+")");
	player.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel jp2 = (JPanel) PetGame.frame.getContentPane().getComponent(1);
			jp2.setVisible(false);
			((JComponent) jp2.getComponent(5)).setOpaque(true);
			jp2.getComponent(3).setBackground(null);
			jp2.getComponent(4).setBackground(null);
			jp2.getComponent(5).setBackground(Color.GREEN);
			jp2.setVisible(true);
			JPanel jp1 = (JPanel) PetGame.frame.getContentPane().getComponent(2);
			jp1.getComponent(0).setVisible(false);
			PetGame.player=PetGame.getPlayers().get(2);
			jp1.getComponent(1).setVisible(true);
		}
	});
	
}
}