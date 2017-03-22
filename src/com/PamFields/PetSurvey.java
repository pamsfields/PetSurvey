package com.PamFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Pam on 3/22/2017.
 */
public class PetSurvey extends JFrame{
    private JCheckBox DogCheckBox;
    private JPanel rootPanel;
    private JCheckBox FishCheckBox;
    private JCheckBox CatCheckBox;
    private JLabel SurveyResultsLabel;
    private JButton quitButton;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    PetSurvey(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setSize(new Dimension(350,200));
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("the deg checkbox was checked or unchecked");
                dog = DogCheckBox.isSelected();
                updateResults();
            }
        });
        FishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("the fish checkbox was checked or unchecked");
                fish = FishCheckBox.isSelected();
                updateResults();
            }
        });
        CatCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("the cat checkbox was checked or unchecked");
                cat = CatCheckBox.isSelected();
                updateResults();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?",
                        "Confirm quit",
                        JOptionPane.OK_CANCEL_OPTION);
            }
        });
    }

    private void updateResults() {
        String hasDog = dog ? "a dog": "no dog";
        String hasCat = cat ? "a cat": "no cat";

        String hasFish;
        if (fish){
            hasFish= "a fish";
        } else{
            hasFish= "no fish";
        }
        String results = "The user has "+hasDog+" and "+hasCat+" and "+hasFish;
        SurveyResultsLabel.setText(results);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
