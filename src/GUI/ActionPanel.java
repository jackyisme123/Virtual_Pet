package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import myPet.PetGame;

public class ActionPanel extends JPanel {
	
	public ActionPanel(){
		if(PetGame.player.getAnimals().size()>0){
			PetGame.animal = PetGame.player.getAnimals().get(0);
		}
		Dimension size = getPreferredSize();
		size.width = 550;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		AnimalPicturePanel1 animalPicturePanel1 = new AnimalPicturePanel1 ();
		ActionOptionPanel actionOptionPanel = new ActionOptionPanel();
//		animalPicturePanel1.setBorder(BorderFactory.createRaisedBevelBorder());
//		actionOptionPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(animalPicturePanel1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(actionOptionPanel, gc);
		
		
	}

	}

