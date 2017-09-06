package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import myPet.PetGame;

public class HomePanel extends JPanel {

	public HomePanel(){
		if(PetGame.player.getAnimals().size()>0){
			PetGame.animal = PetGame.player.getAnimals().get(0);
		}
		Dimension size = getPreferredSize();
		size.width = 550;
		setPreferredSize(size);
		setBackground(new Color(222,211,140));
		AnimalPicturePanel animalPicturePanel = new AnimalPicturePanel ();
		AnimalStatusPanel1 animalStatusPanel1 = new AnimalStatusPanel1();
//		animalPicturePanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		animalStatusPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(animalPicturePanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(animalStatusPanel1, gc);
		
		
	}
}
