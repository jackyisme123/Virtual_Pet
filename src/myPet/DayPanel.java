package myPet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayPanel extends JPanel {
	
	public DayPanel(){
		Dimension size = getPreferredSize();
		size.width = 295;
		size.height = 170;
		setPreferredSize(size);
		setBackground(new Color(222,156,83));
		JLabel day = new JLabel("Day: ");
		day.setFont(new Font("courier",Font.PLAIN,25));
		JLabel gameDay = new JLabel();
		gameDay.setText(String.valueOf(PetGame.player.getGameDays()));
		gameDay.setFont(new Font("courier",Font.BOLD,60));
		gameDay.setForeground(Color.ORANGE);
		JLabel winDay = new JLabel();
		winDay.setText("of " + String.valueOf(PetGame.player.getPlayDays()));
		winDay.setFont(new Font("courier",Font.ITALIC,20));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(day, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(gameDay, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(winDay, gc);
	}
}
