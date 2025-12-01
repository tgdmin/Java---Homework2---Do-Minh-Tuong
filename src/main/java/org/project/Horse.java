package org.project;

public class Horse extends Animal implements Make_Sound {
    // Constructor
    public Horse(int id, double height) {
        super(id, height);
    }

    //Method
    @Override
    public void makeSound() {
        System.out.println("Hee hee");
    }
}

