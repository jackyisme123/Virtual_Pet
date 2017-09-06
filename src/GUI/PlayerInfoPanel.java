package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfoPanel extends JPanel {
	public JLabel name1;
	public JLabel petsNo1;
	public JLabel playDays1;
	public JButton player;
	
	public PlayerInfoPanel(){
		setSize(200, 150);
		player =new JButton();
		player.setPreferredSize(new Dimension(400,150));
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("courier",Font.BOLD,20));
		JLabel petsNo = new JLabel("Pet No.: ");
		petsNo.setFont(new Font("courier",Font.BOLD,20));
		JLabel playDays = new JLabel("Play Days: ");
		playDays.setFont(new Font("courier",Font.BOLD,20));
		name1 = new JLabel();
		name1.setFont(new Font("courier",Font.ITALIC,20));
		petsNo1 = new JLabel();
		petsNo1.setFont(new Font("courier",Font.ITALIC,20));
		playDays1 = new JLabel();
		playDays1.setFont(new Font("courier",Font.ITALIC,20));
		
		player.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
			
		gc.gridx = 0;
		gc.gridy = 0;
		player.add(name, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		player.add(petsNo, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		player.add(playDays, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 0;
		player.add(name1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		player.add(petsNo1, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		player.add(playDays1, gc);
		
		add(player);
		
	}
}
