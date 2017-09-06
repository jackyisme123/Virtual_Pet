package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PetShopPanel extends JPanel {
	public PetShopPanel(){
		Dimension size = getPreferredSize();
		size.width = 550;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		PetVarietyPanel petVarietyPanel = new PetVarietyPanel();
		PetNamePanel petNamePanel = new PetNamePanel();
		
//		petVarietyPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		petNamePanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(petVarietyPanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(petNamePanel, gc);
		
	}
}
