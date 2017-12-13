package pl.animalshelter;

import java.util.ArrayList;

public class AnimalShelter {
    private ArrayList<Animal> animals;

    public AnimalShelter() {
        animals = new ArrayList<>();
    }

    public void addNewAnimal(Animal a) {
        animals.add(a);
        System.out.println(animals);
    }
}
