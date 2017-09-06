package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.PetGame;

public class WinFrame extends JFrame {
	public JPanel winPanel;
	
	public WinFrame(String title){
		super(title);
		
		winPanel = new JPanel(){
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(LostFrame.class.getResource("/pics/win.jpg"));
				Image img = icon.getImage();
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
            }
			
		};
		
		winPanel.setLayout(null);
		JLabel youWin = new JLabel("Congratulations! You Win!");
		youWin.setBounds(100, 200, 800, 100);
		youWin.setForeground(Color.red);
		youWin.setFont(new Font("courier",Font.BOLD,50));
		JLabel yourScore = new JLabel();
		yourScore.setBounds(350, 300, 300, 100);
		yourScore.setFont(new Font("courier",Font.ITALIC,25));
		yourScore.setText("Your Score is " + PetGame.player.calTotalScore());
		yourScore.setForeground(Color.RED);
		JLabel highScore =new JLabel();
		highScore.setBounds(300, 400, 500, 100);
		highScore.setFont(new Font("courier",Font.ITALIC,25));
		highScore.setText("Highest Score: " + PetGame.highScoreName +"("+PetGame.highScore +")");
		highScore.setForeground(Color.RED);
		winPanel.add(youWin);
		winPanel.add(yourScore);
		winPanel.add(highScore);
		add(winPanel);
	}
	
}
