package pl.animalshelter;

import javax.swing.*;

public class Animal {
    private int id_animal;
    private String name;
    private String kindOfAnimal;
    private int age;
    private ImageIcon photo;
    private static int next_id = 1;

    public Animal(String name, String kindOfAnimal, int age, String path) {
        id_animal = next_id++;
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.age = age;
        this.photo = new ImageIcon(path);
    }

    public Animal(int id_animal, String name, String kindOfAnimal, int age, String path) {
        this.id_animal = id_animal;
        next_id++;
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.age = age;
        this.photo = new ImageIcon(path);
    }

    public int getAge() {
        return age;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    @Override
    public String toString() {
        return name;
    }
}
