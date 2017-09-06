package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LostFrame extends JFrame {

	JPanel losePanel;
	public LostFrame(String title){
				super(title);
				losePanel = new JPanel(){
					protected void paintComponent(Graphics g) {
						ImageIcon icon = new ImageIcon(LostFrame.class.getResource("/pics/lose.jpg"));
						Image img = icon.getImage();
		                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
		            }
					
				};
				losePanel.setLayout(null);
				JLabel youLose = new JLabel("Sorry! You Lose!");
				youLose.setBounds(250, 200, 500, 100);
				youLose.setForeground(Color.red);
				youLose.setFont(new Font("courier",Font.BOLD,50));
				JLabel kg = new JLabel();
				kg.setBounds(400, 300, 200, 100);
				kg.setFont(new Font("courier",Font.BOLD,25));
				kg.setForeground(Color.red);
				kg.setText("Keep Going!");
				losePanel.add(youLose);
				losePanel.add(kg);
				add(losePanel);
			}
			
		}

