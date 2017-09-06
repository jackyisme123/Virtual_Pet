package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.Food;
import myPet.PetGame;

public class FoodInventoryPanel extends JPanel {

	public FoodInventoryPanel(){
		Dimension size = getPreferredSize();
		size.width = 295;
		size.height = 280;
		setPreferredSize(size);
		setBackground(new Color(222,156,83));
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		JLabel foodInventory = new JLabel("Food Inventory: ");
		foodInventory.setFont(new Font("courier",Font.BOLD,20));
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		int i = 0;
		gc.gridx = 0;
		gc.gridy = i;
		add(foodInventory, gc);
		if (PetGame.player.getFoods().size() <= 0){
			JLabel empty = new JLabel("Empty");
			empty.setFont(new Font("courier",Font.ITALIC,20));
			gc.gridx = 0;
			gc.gridy = 1;
			add(empty, gc);
		}else{
			ArrayList<Food> foods = PetGame.player.getFoods();
			Collections.sort(foods, new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return new String(o1.toString()).compareTo(o2.toString());
				}
				
			});
			for(Food food:foods){
				i++;
				JLabel foodLabel = new JLabel();
				foodLabel.setFont(new Font("courier",Font.ITALIC,20));
				foodLabel.setText(food.toString());
				gc.gridx = 0;
				gc.gridy = i;
				add(foodLabel, gc);
		}
		}
	}
}
