package pl.animalshelter;

import javax.swing.*;

public class Animal {
    private String name;
    private String kindOfAnimal;
    private int age;
    private ImageIcon photo;

    public Animal(String name, String kindOfAnimal, int age, String path) {
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

    @Override
    public String toString() {
        return name;
    }
}
