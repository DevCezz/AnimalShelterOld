package pl.animalshelter;

import javax.swing.*;
import java.awt.*;

public class AnimalList extends JList<Animal>{
    private DefaultListModel<Animal> animalListModel;

    public AnimalList() {
        animalListModel = new DefaultListModel<>();
        setModel(animalListModel);
        setMinimumSize(new Dimension(100,100));
        setPreferredSize(new Dimension(200,200));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }


    public AnimalList(Animal[] animals) {
        super(animals);
        animalListModel = new DefaultListModel<>();
        setModel(animalListModel);
        setMinimumSize(new Dimension(100,100));
        setPreferredSize(new Dimension(200,200));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addAnimal(Animal animal) {
        DefaultListModel<Animal> temp = (DefaultListModel<Animal>) this.getModel();  //NIE DZIAłA!!!!!
        temp.addElement(animal);
        repaint();
        System.out.println("blll");
    }
}
