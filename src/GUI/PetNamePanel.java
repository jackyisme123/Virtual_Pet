package GUI;

import java.awt.Color;
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

public class PetNamePanel extends JPanel {

	public PetNamePanel(){
		Dimension size = getPreferredSize();
		size.height = 150;
		size.width = 520;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		JLabel confirm =new JLabel();
		confirm.setFont(new Font("courier",Font.BOLD,15));
		confirm.setText("Please give your pet a name first: ");
		confirm.setVisible(false);
		JTextField name = new JTextField(10);
		name.setFont(new Font("courier",Font.ITALIC,15));
		name.setVisible(false);
		JLabel result = new JLabel();
		result.setVisible(false);
		JButton buy = new JButton("Buy it!");
		buy.setFont(new Font("courier",Font.PLAIN,15));
		buy.setVisible(false);
		buy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String petName = name.getText();
				String regEx ="[a-zA-Z0-9_]*";
				Pattern pattern = Pattern.compile(regEx);
				Matcher matcher = pattern.matcher(petName);
				if(PetGame.player.getAnimals().size()>=3){
					result.setText("Maximum Pets!");
				}else if(PetGame.player.getAccount()<PetGame.petToBuy.getPrice()){
					result.setText("Not enough money!");
				}else if(!matcher.matches()){
					result.setText("Enter letters, numbers or '_' for pet name");
				}else if (petName == null ||petName.trim().equals("")){
					result.setText("Please give pet a name!");
				}else{
					PetGame.petToBuy.setName(petName);
					PetGame.player.addAnimal(PetGame.petToBuy);
					result.setText("Pet purchase successfully");
					
				}
				result.setVisible(true);
				confirm.setVisible(false);
				name.setText(null);
				name.setVisible(false);
				buy.setVisible(false);
				JLabel account = (JLabel) PetGame.frame.getContentPane().getComponent(3);
				account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
				
				
			}
		});
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.2;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.gridy = 0;
		add(confirm, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(name, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(buy, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add(result, gc);
		
		
	}
}
