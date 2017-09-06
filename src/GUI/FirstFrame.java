package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstFrame extends JFrame{
	
	private NewPlayerPanel newPlayerPanel;
	private PlayerNoPanel playerNoPanel;
	
	public FirstFrame(String title){
		super(title);
		
	setLayout(new BorderLayout());	
	JLabel welcome = new JLabel("Welcome To Pet World, Please Create Or Choose A Player!!!");
	welcome.setFont(new Font("courier",Font.ITALIC,25));
	welcome.setForeground(Color.PINK);
	
	
	newPlayerPanel = new NewPlayerPanel();
	playerNoPanel = new PlayerNoPanel();
	
//	welcome.setBorder(BorderFactory.createRaisedBevelBorder());
//	newPlayerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//	playerNoPanel.setBorder(BorderFactory.createRaisedBevelBorder());
	Container c = getContentPane();
	c.add(welcome, BorderLayout.NORTH);
	c.add(playerNoPanel, BorderLayout.WEST);
	c.add(newPlayerPanel, BorderLayout.CENTER);
	
	c.setBackground(new Color(3,54,73));
	}
}
