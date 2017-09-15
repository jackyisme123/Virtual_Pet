package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstFrame extends JFrame{
	
	private NewPlayerPanel newPlayerPanel;
	private PlayerNoPanel playerNoPanel;
	private ImageIcon background;
	private JPanel imagePanel;
	public FirstFrame(String title){
		super(title);
	background = new ImageIcon(FirstFrame.class.getResource("/pics/background_ff_1.jpg"));
	JLabel bgLabel = new JLabel(background);
	bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
	imagePanel = (JPanel) getContentPane();
	imagePanel.setOpaque(false);
	
	imagePanel.setLayout(new BorderLayout());	
	JLabel welcome = new JLabel("Welcome To Pet World, Please Create Or Choose A Player!!!", JLabel.CENTER);
	welcome.setFont(new Font("alias",Font.BOLD,26));
	welcome.setForeground(Color.YELLOW);
	newPlayerPanel = new NewPlayerPanel();
	playerNoPanel = new PlayerNoPanel();
	
//	welcome.setBorder(BorderFactory.createRaisedBevelBorder());
//	newPlayerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//	playerNoPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//	Container c = imagePanel.getContentPane();
	imagePanel.add(welcome, BorderLayout.NORTH);
	imagePanel.add(playerNoPanel, BorderLayout.WEST);
	imagePanel.add(newPlayerPanel, BorderLayout.CENTER);
	
//	c.setBackground(new Color(3,54,73));
	getLayeredPane().setLayout(null);
	getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
	setSize(background.getIconWidth(), background.getIconHeight());
	setResizable(false);
	setVisible(true);
	}
}
