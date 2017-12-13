package pl.animalshelter;

public class Animal {
    private String name;
    private String kindOfAnimal;
    private int age;

    public Animal(String name, String kindOfAnimal, int age) {
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.age = age;
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
}
