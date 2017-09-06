package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import myPet.PetGame;

public class AnimalStatusPanel extends JPanel {
	public AnimalStatusPanel() {
		Dimension size = getPreferredSize();
		size.height = 360;
		size.width = 500;
		setPreferredSize(size);

		JLabel name = new JLabel("Name: ");
		JLabel species = new JLabel("Species: ");
		JLabel favFood = new JLabel("Favourite Food: ");
		JLabel favToy = new JLabel("Favourite Toy: ");
		JLabel age = new JLabel("Age: ");
		JLabel weight = new JLabel("Weight: ");
		JLabel mood = new JLabel("Mood: ");
		JLabel actionNo = new JLabel("Action No.: ");
		JLabel tiredness = new JLabel("Tiredness: ");
		JLabel hungryLevel = new JLabel("Hungry Level: ");
		JLabel toiletLevel = new JLabel("Toilet Level: ");
		JLabel playfulness = new JLabel("Playfulness: ");
		JLabel isSick = new JLabel("Is Sick: ");
		JLabel isMad = new JLabel("Is Mad: ");
		JLabel nameValue = new JLabel();
		JLabel speciesValue = new JLabel();
		JLabel favFoodValue = new JLabel();
		JLabel favToyValue = new JLabel();
		JLabel ageValue = new JLabel();
		JLabel weightValue = new JLabel();
		JLabel moodValue = new JLabel();
		JLabel actionNoValue = new JLabel();
		JLabel tirednessValue = new JLabel();
		JLabel hungryLevelValue = new JLabel();
		JLabel toiletLevelValue = new JLabel();
		JLabel playfulnessValue = new JLabel();
		JLabel isSickValue = new JLabel();
		JLabel isMadValue = new JLabel();
		if (PetGame.animal == null) {
			nameValue.setText("N/A");
			speciesValue.setText("N/A");
			favFoodValue.setText("N/A");
			favToyValue.setText("N/A");
			ageValue.setText("N/A");
			weightValue.setText("N/A");
			moodValue.setText("N/A");
			tirednessValue.setText("N/A");
			hungryLevelValue.setText("N/A");
			toiletLevelValue.setText("N/A");
			playfulnessValue.setText("N/A");
			isSickValue.setText("N/A");
			isMadValue.setText("N/A");
			actionNoValue.setText("N/A");

		} else if (!PetGame.animal.isAlive()) {
			nameValue.setText(PetGame.animal.getName());
			speciesValue.setText(PetGame.animal.getSpecies());
			favFoodValue.setText(PetGame.animal.favorFood);
			favToyValue.setText(PetGame.animal.favorToy);
			ageValue.setText(String.valueOf(PetGame.animal.getAge()));
			weightValue.setText(String.valueOf(PetGame.animal.getWeight()));
			moodValue.setText("N/A");
			tirednessValue.setText("N/A");
			hungryLevelValue.setText("N/A");
			toiletLevelValue.setText("N/A");
			playfulnessValue.setText("N/A");
			isSickValue.setText("N/A");
			isMadValue.setText("N/A");
			actionNoValue.setText("N/A");
		} else {
			nameValue.setText(PetGame.animal.getName());
			nameValue.setForeground(Color.GREEN);
			speciesValue.setText(PetGame.animal.getSpecies());
			speciesValue.setForeground(Color.GREEN);
			favFoodValue.setText(PetGame.animal.favorFood);
			favFoodValue.setForeground(Color.GREEN);
			favToyValue.setText(PetGame.animal.favorToy);
			favToyValue.setForeground(Color.GREEN);
			ageValue.setText(String.valueOf(PetGame.animal.getAge()));
			ageValue.setForeground(Color.GREEN);
			weightValue.setText(String.valueOf(PetGame.animal.getWeight()));
			weightValue.setForeground(Color.GREEN);
			moodValue.setText(PetGame.animal.getMood());
			if(PetGame.animal.getMood().equals("Normal")){
				moodValue.setForeground(Color.GREEN);
			}else{
				moodValue.setForeground(Color.ORANGE);
			}
			tirednessValue.setText(String.valueOf(PetGame.animal.getTiredness()));
			if(PetGame.animal.getTiredness()>3){
				tirednessValue.setForeground(Color.GREEN);
			}else{
				tirednessValue.setForeground(Color.RED);
			}
			hungryLevelValue.setText(String.valueOf(PetGame.animal.getHungryLevel()));
			if(PetGame.animal.getHungryLevel()>3){
				hungryLevelValue.setForeground(Color.GREEN);
			}else{
				hungryLevelValue.setForeground(Color.RED);
			}
			toiletLevelValue.setText(String.valueOf(PetGame.animal.getToiletLevel()));
			if(PetGame.animal.getToiletLevel()>3){
				toiletLevelValue.setForeground(Color.GREEN);
			}else{
				toiletLevelValue.setForeground(Color.RED);
			}
			playfulnessValue.setText(String.valueOf(PetGame.animal.getPlayfulness()));
			if(PetGame.animal.getPlayfulness()>3){
				playfulnessValue.setForeground(Color.GREEN);
			}else{
				playfulnessValue.setForeground(Color.RED);
			}
			isSickValue.setText(String.valueOf(PetGame.animal.isSick()));
			if(!PetGame.animal.isSick()){
				isSickValue.setForeground(Color.GREEN);
			}else{
				isSickValue.setForeground(Color.RED);
			}
			isMadValue.setText(String.valueOf(PetGame.animal.isMad()));
			if(!PetGame.animal.isMad()){
				isMadValue.setForeground(Color.GREEN);
			}else{
				isMadValue.setForeground(Color.RED);
			}
			actionNoValue.setText(String.valueOf(PetGame.animal.getActionNumber()));
			actionNoValue.setForeground(Color.GREEN);
		}

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.gridx = 0;
		gc.gridy = 0;
		add(name, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		add(species, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		add(favFood, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		add(favToy, gc);

		gc.gridx = 0;
		gc.gridy = 4;
		add(age, gc);

		gc.gridx = 0;
		gc.gridy = 5;
		add(weight, gc);

		gc.gridx = 0;
		gc.gridy = 6;
		add(mood, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		add(nameValue, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		add(speciesValue, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		add(favFoodValue, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		add(favToyValue, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		add(ageValue, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		add(weightValue, gc);

		gc.gridx = 1;
		gc.gridy = 6;
		add(moodValue, gc);

		gc.gridx = 3;
		gc.gridy = 0;
		add(tiredness, gc);

		gc.gridx = 3;
		gc.gridy = 1;
		add(hungryLevel, gc);

		gc.gridx = 3;
		gc.gridy = 2;
		add(toiletLevel, gc);

		gc.gridx = 3;
		gc.gridy = 3;
		add(playfulness, gc);

		gc.gridx = 3;
		gc.gridy = 4;
		add(isSick, gc);

		gc.gridx = 3;
		gc.gridy = 5;
		add(isMad, gc);

		gc.gridx = 3;
		gc.gridy = 6;
		add(actionNo, gc);

		gc.gridx = 4;
		gc.gridy = 0;
		add(tirednessValue, gc);

		gc.gridx = 4;
		gc.gridy = 1;
		add(hungryLevelValue, gc);

		gc.gridx = 4;
		gc.gridy = 2;
		add(toiletLevelValue, gc);

		gc.gridx = 4;
		gc.gridy = 3;
		add(playfulnessValue, gc);

		gc.gridx = 4;
		gc.gridy = 4;
		add(isSickValue, gc);

		gc.gridx = 4;
		gc.gridy = 5;
		add(isMadValue, gc);

		gc.gridx = 4;
		gc.gridy = 6;
		add(actionNoValue, gc);

	}
}