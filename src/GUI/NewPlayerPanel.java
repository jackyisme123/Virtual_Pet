package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myPet.MyMenu;
import myPet.PetGame;

/*
 * It was a hidden panel, 
 * when add a new player was click or an existed player was chosen, 
 * it would be show up
 */
public class NewPlayerPanel extends JPanel {
	public NewPlayerPanel(){
		Dimension size = getPreferredSize();
		size.width = 600;
		setPreferredSize(size);
		setBackground(new Color(3,22,52));
		JButton startGame = new JButton("Start Game");
		startGame.setSize(200,10);
		startGame.setFont(new Font("courier",Font.BOLD,25));
		startGame.setVisible(false);
		startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetGame.frame.setVisible(false);
				PetGame.frame = new MainFrame("PetGame");
				PetGame.frame.setSize(1000, 800);
				PetGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				PetGame.frame.setVisible(true);
				MyMenu myM = new MyMenu();
				PetGame.frame.setJMenuBar(myM.bulidMenu());
				PetGame.frame.setVisible(true);
			}
		});
		EnterPlayerInfoPanel epip = new EnterPlayerInfoPanel();
		epip.setVisible(false);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(epip, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(startGame, gc);
		
		
		
	}
}
