package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myPet.PetGame;


public class EmptyPanel extends JPanel {
	
	ImageIcon buttonImage = new ImageIcon(FirstFrame.class.getResource("/pics/new_player.png"));
	
	public EmptyPanel(){
		Dimension size = getPreferredSize();
		size.width = 420;
		size.height = 170;
		setPreferredSize(size);
		//setSize(buttonImage.getIconWidth(), buttonImage.getIconHeight());
		setBackground(new Color(3,22,52));
		setOpaque(false);
//		setLayout(new BorderLayout());
		JButton addButton =new JButton(buttonImage);
		Dimension size1 = getPreferredSize();
		size1.width = 400;
		size1.height = 50;
		addButton.setPreferredSize(size1);
		//addButton.setSize(400, 160);
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
