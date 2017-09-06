package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myPet.PetGame;


public class EmptyPanel extends JPanel {
	
	
	
	public EmptyPanel(){
		setSize(200,150);
		setBackground(new Color(3,22,52));
		JButton addButton =new JButton("Click to add a new player");
		addButton.setFont(new Font("courier",Font.ITALIC,25));
		//Click Button get add player panel
		addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel jp = (JPanel) PetGame.frame.getContentPane().getComponent(2);
				jp.getComponent(0).setVisible(true);
				jp.getComponent(1).setVisible(false);

			}
			
		});
		add(addButton);
		
	}
	

}
