package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.PetGame;

public class PlayerNoPanel extends JPanel {
	public PlayerNoPanel(){
		repaint();
		Dimension size = getPreferredSize();
		size.width = 600;
		setPreferredSize(size);
		setBackground(new Color(3,22,52));
		JLabel player1 = new JLabel("Player 1");
		player1.setFont(new Font("courier",Font.PLAIN,20));
		player1.setForeground(Color.CYAN);
		JLabel player2 = new JLabel("Player 2");
		player2.setFont(new Font("courier",Font.PLAIN,20));
		player2.setForeground(Color.CYAN);
		JLabel player3 = new JLabel("Player 3");
		player3.setFont(new Font("courier",Font.PLAIN,20));
		player3.setForeground(Color.CYAN);
		
		JPanel player1_1 = new EmptyPanel();
		player1_1.setFont(new Font("courier",Font.PLAIN,20));
		JPanel player2_1 = new EmptyPanel();
		player2_1.setFont(new Font("courier",Font.PLAIN,20));
		JPanel player3_1 = new EmptyPanel();
		player3_1.setFont(new Font("courier",Font.PLAIN,20));
		
		if(PetGame.getPlayers().size() >= 1){
			player1_1 = new Player1Panel();
		
		}
		
		
		
		if(PetGame.getPlayers().size() >= 2){
			player2_1 = new Player2Panel();
		}
		
		
		if(PetGame.getPlayers().size() == 3){
			player3_1 = new Player3Panel();
		}
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(player1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(player2, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(player3, gc);
		
			
		gc.gridx = 1;
		gc.gridy = 0;
		add(player1_1, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(player2_1, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(player3_1, gc);
		
	}
}
