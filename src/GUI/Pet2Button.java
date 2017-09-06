package GUI;

import java.awt.Dimension;

import javax.swing.JButton;

import myPet.PetGame;

public class Pet2Button extends JButton {

	public Pet2Button(){
		setText(PetGame.player.getAnimals().get(1).toString());
		Dimension size = getPreferredSize();
		size.height = 160;
		size.width = 160;
		setPreferredSize(size);
		
	}
}
