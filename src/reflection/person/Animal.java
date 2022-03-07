package reflection.person;

import java.io.Serializable;

public class Animal implements Serializable, MyInterface {
    private static final long serialVersionUID = 42L;

    public String species;
    private final boolean gender;
    int id;

    public Animal() {
        this.gender = false;
    }

    public Animal(String species, boolean gender, int id) {
        this.species = species;
        this.gender = gender;
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void info() {
        System.out.println("I'm an animal...");
    }
}
