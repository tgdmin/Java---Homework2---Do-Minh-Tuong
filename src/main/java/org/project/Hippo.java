package org.project;

public class Hippo extends Animal implements Make_Sound {
    // Constructor
    public Hippo(int id, double height) {
        super(id, height);
    }

    // Method
    @Override
    public void makeSound() {
        System.out.println("Gnar gnar");
    }
}
