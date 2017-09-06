package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import myPet.DayPanel;

public class OtherPanel extends JPanel {

	public OtherPanel(){
		Dimension size = getPreferredSize();
		size.width = 300;
		setPreferredSize(size);
		setBackground(new Color(222,156,83));
		DayPanel dayPanel = new DayPanel();
		FoodInventoryPanel foodInventoryPanel = new FoodInventoryPanel();
		ToyInventoryPanel toyInventoryPanel = new ToyInventoryPanel();
//		dayPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		foodInventoryPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		toyInventoryPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(dayPanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(foodInventoryPanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(toyInventoryPanel, gc);
		
	}
}
