package GUI;

import java.awt.Dimension;

import javax.swing.JButton;

public class EmptyButton extends JButton {
	public EmptyButton(){
		setText("Empty");
		Dimension size = getPreferredSize();
		size.height = 160;
		size.width = 160;
		setPreferredSize(size);
		
	}
}
