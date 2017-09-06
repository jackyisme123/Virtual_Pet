package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.PetGame;
import myPet.Toy;

public class ToyInventoryPanel extends JPanel {

	public ToyInventoryPanel(){
		Dimension size = getPreferredSize();
		size.width = 295;
		size.height = 220;
		setPreferredSize(size);
		setBackground(new Color(222,156,83));
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		JLabel toyInventory = new JLabel("Toy Inventory: ");
		toyInventory.setFont(new Font("courier",Font.BOLD,20));
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		int i = 0;
		gc.gridx = 0;
		gc.gridy = i;
		add(toyInventory, gc);
		if (PetGame.player.getToys().size() <= 0){
			JLabel empty = new JLabel("Empty");
			empty.setFont(new Font("courier",Font.ITALIC,20));
			gc.gridx = 0;
			gc.gridy = 1;
			add(empty, gc);
		}else{
			ArrayList<Toy> toys = PetGame.player.getToys();
			Collections.sort(toys, new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return new String(o1.toString()).compareTo(o2.toString());
				}
				
			});
			for(Toy toy:toys){
				i++;
				JLabel toyLabel = new JLabel();
				toyLabel.setFont(new Font("courier",Font.ITALIC,20));
				toyLabel.setText(toy.toString());
				gc.gridx = 0;
				gc.gridy = i;
				add(toyLabel, gc);
		}
		}
	}
}
