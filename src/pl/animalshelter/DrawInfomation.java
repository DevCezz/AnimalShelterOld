package pl.animalshelter;

import javax.swing.*;
import java.awt.*;

public class DrawInfomation extends JPanel {
    private JLabel idAnimal;
    private JLabel nameAniamal;
    private JLabel kindAnimal;
    private JLabel ageAnimal;
    private Animal animal;

    public DrawInfomation() {
        this.setLayout(new GridLayout(4,2));

        JLabel id = new JLabel("ID: ");
        id.setHorizontalAlignment(SwingConstants.CENTER);
        add(id);
        idAnimal = new JLabel("" + 0);
        add(idAnimal);

        JLabel name = new JLabel("Imię: ");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        add(name);
        nameAniamal = new JLabel("brak");
        add(nameAniamal);

        JLabel kind = new JLabel("Rodzaj: ");
        kind.setHorizontalAlignment(SwingConstants.CENTER);
        add(kind);
        kindAnimal = new JLabel("brak");
        add(kindAnimal);

        JLabel age = new JLabel("Wiek: ");
        age.setHorizontalAlignment(SwingConstants.CENTER);
        add(age);
        ageAnimal = new JLabel("" + 0);
        add(ageAnimal);
    }

    public void updateInformation(Animal animal) {
        if (animal != null) {
            idAnimal.setText("" + animal.getId_animal());
            nameAniamal.setText(animal.getName());
            kindAnimal.setText(animal.getKindOfAnimal());
            ageAnimal.setText("" + animal.getAge());
        }
        else {
            idAnimal.setText("");
            nameAniamal.setText("");
            kindAnimal.setText("");
            ageAnimal.setText("");
        }
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
