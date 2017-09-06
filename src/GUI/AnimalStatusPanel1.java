package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class AnimalStatusPanel1 extends JPanel {
	public AnimalStatusPanel1(){
		Dimension size = getPreferredSize();
		size.height = 380;
		size.width = 520;
		setPreferredSize(size);
		add(new AnimalStatusPanel());
		setBackground(new Color(222,211,140));
	}

}
