package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import myPet.PetGame;

public class Pet1Button extends JButton {
	
	public Pet1Button(){
		setText(PetGame.player.getAnimals().get(0).toString());
		Dimension size = getPreferredSize();
		size.height = 160;
		size.width = 160;
		setPreferredSize(size);
		
	}

}
