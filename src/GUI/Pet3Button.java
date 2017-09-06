package GUI;

import java.awt.Dimension;

import javax.swing.JButton;

import myPet.PetGame;

public class Pet3Button extends JButton {

	public Pet3Button(){
		setText(PetGame.player.getAnimals().get(2).toString());
		Dimension size = getPreferredSize();
		size.height = 160;
		size.width = 160;
		setPreferredSize(size);
		
	}
}
