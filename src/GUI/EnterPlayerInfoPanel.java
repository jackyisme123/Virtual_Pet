package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myPet.PetGame;
import myPet.Player;

public class EnterPlayerInfoPanel extends JPanel {
	public EnterPlayerInfoPanel(){
		Dimension size = getPreferredSize();
		size.height = 400;
		size.width = 300;
		setPreferredSize(size);
		
		JLabel createNew = new JLabel("  Create New Player");
		createNew.setFont(new Font("courier",Font.BOLD,15));
		JLabel name = new JLabel("Enter Player Name: ");
		JLabel days = new JLabel("Enter Days To Win: ");
		JTextField playerName = new JTextField(10);
		playerName.setSize(20,5);
		JTextField daysToWin = new JTextField(10);
		daysToWin.setSize(20,5);
		JLabel info = new JLabel();
		JButton add = new JButton("ADD");
		
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String playerNameStr = playerName.getText();
				String regEx ="[a-zA-Z0-9_]*";
				Pattern pattern = Pattern.compile(regEx);
				Matcher matcher = pattern.matcher(playerNameStr);
				int playerDays = 0;
				try{
					playerDays = Integer.valueOf(daysToWin.getText());
				}
				catch(Exception ea){
					info.setText("Please enter an integer in days");
					return;
				}
				for (String name:PetGame.getPlayerNames()){
					if (name.equals(playerNameStr)){
						info.setText("This name has been occupied");
						return;
					}
				}
				
				
				
				if(PetGame.getPlayers().size()>=3){
					info.setText("Maximun Player!");
				}else if(!matcher.matches()){
					info.setText("Enter letters, numbers or '_' for player name");
				}
				else if(playerNameStr==null || playerNameStr.trim().equals("")){
					info.setText("Name cannot be empty");
				}
				else if( playerDays <1 || playerDays > 20 ){
					info.setText("Enter number from 1 to 20");
				}else{
				Player player = new Player(playerNameStr);
				player.setPlayDays(playerDays);
				PetGame.getPlayers().add(player);
				PetGame.getPlayerNames().add(playerNameStr);
	//			System.out.println(PetGame.getPlayers().size());
				playerName.setText(null);
				daysToWin.setText(null);
				info.setText("Player create successfully!");
				
				}
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(1);
				
				
				
				if(PetGame.getPlayers().size() == 1){
					JPanel player1_1 = (JPanel) jp.getComponent(3);
					player1_1.setVisible(false);
					player1_1.removeAll();
					player1_1.add(new Player1Panel());
					player1_1.setVisible(true);
					
				}
				
				
				
				if(PetGame.getPlayers().size() == 2){
					JPanel player2_1 = (JPanel) jp.getComponent(4);
					player2_1.setVisible(false);
					player2_1.removeAll();
					player2_1.add(new Player2Panel());
					player2_1.setVisible(true);
				}
				
				
				if(PetGame.getPlayers().size() == 3){
					JPanel player3_1 = (JPanel) jp.getComponent(5);
					player3_1.setVisible(false);
					player3_1.removeAll();
					player3_1.add(new Player3Panel());
					player3_1.setVisible(true);
				}
				
				
				
		}
		});
		
		
		
		
		
		
		JButton cancle = new JButton("CANCLE");
		cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				playerName.setText(null);
				daysToWin.setText(null);
				
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(createNew, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(name, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(days, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(add, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(playerName, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(daysToWin, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(cancle, gc);
		
		gc.gridwidth = 4;
		gc.gridx = 0;
		gc.gridy = 4;
		add(info, gc);
		
		
		
		
		
	}
}
