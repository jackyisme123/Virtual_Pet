package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.PetGame;

public class MainFrame extends JFrame {
	private JPanel commandPanel; 
	private JPanel homePanel;
	private JPanel otherPanel;
	public MainFrame(String title){
		super(title);
		setLayout(new BorderLayout());
		JLabel account = new JLabel();
		account.setText("Hi, " +String.valueOf(PetGame.player.getName()+" your account: $" +String.valueOf(PetGame.player.getAccount())));
		account.setFont(new Font("courier",Font.ITALIC,20));
		account.setForeground(Color.PINK);
		commandPanel = new CommandPanel();
//		homePanel = new HomePanel();
		homePanel = new PetShopPanel();
//		homePanel = new FoodShopPanel();
//		homePanel = new ToyShopPanel();
//		homePanel = new ActionPanel();
		otherPanel = new OtherPanel();
//		commandPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		homePanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		otherPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		Container c = getContentPane();
		c.add(commandPanel, BorderLayout.WEST);
		c.add(homePanel, BorderLayout.CENTER);
		c.add(otherPanel, BorderLayout.EAST);
		c.add(account,BorderLayout.NORTH);
		c.setBackground(new Color(130,57,53));
	}
}
