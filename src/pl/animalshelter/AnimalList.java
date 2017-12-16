package pl.animalshelter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AnimalList extends JList<Animal>{
    private DefaultListModel defaultListModel;
    private Animal animal;

    public AnimalList(DrawInfomation drawInfomation) {
        defaultListModel = new DefaultListModel();
        this.setModel(defaultListModel);
        setMinimumSize(new Dimension(100,200));
        setPreferredSize(new Dimension(200,400));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animal = (Animal) ((JList)e.getSource()).getSelectedValue();
                drawInfomation.updateInformation(animal);
                drawInfomation.setAnimal(animal);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                animal = (Animal) ((JList)e.getSource()).getSelectedValue();
                drawInfomation.updateInformation(animal);
                drawInfomation.setAnimal(animal);
            }
        });
    }
    public AnimalList(ArrayList<Animal> animals) {
        defaultListModel = new DefaultListModel();
        for (int i = 0; i < animals.size(); i++)
            defaultListModel.addElement(animals.get(i));

        this.setModel(defaultListModel);
        setMinimumSize(new Dimension(100, 100));
        setPreferredSize(new Dimension(200, 200));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addAnimal(Animal animal) {
        defaultListModel.addElement(animal);
    }
}
