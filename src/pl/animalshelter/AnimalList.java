package pl.animalshelter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AnimalList extends JList<Animal>{
    private DefaultListModel defaultListModel;
    private Animal animal;
    private static int nextId;

    public AnimalList(DrawInfomation drawInfomation) {
        defaultListModel = new DefaultListModel();
        this.setModel(defaultListModel);
        setMinimumSize(new Dimension(100,200));
        setPreferredSize(new Dimension(200,400));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(new MouseHandler(drawInfomation));
    }

    public AnimalList(DrawInfomation drawInfomation, ArrayList<Animal> animals) {
        defaultListModel = new DefaultListModel();
        this.setModel(defaultListModel);
        for (int i = 0; i < animals.size(); i++) {
            defaultListModel.addElement(animals.get(i));
        }
        nextId = animals.size();

        setMinimumSize(new Dimension(100, 100));
        setPreferredSize(new Dimension(200, 200));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(new MouseHandler(drawInfomation));
    }

    public void addAnimal(Animal animal) {
        defaultListModel.addElement(animal);
    }

    public ArrayList<Animal> getActualAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < defaultListModel.size(); i++) {
            animals.add((Animal) defaultListModel.get(i));
        }
        return animals;
    }

    private class MouseHandler extends MouseAdapter {
        private DrawInfomation drawInfomation;
        public MouseHandler(DrawInfomation drawInfomation) {
            this.drawInfomation = drawInfomation;
        }

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
    }
}
