package org.project;

public class Dog extends Animal implements Make_Sound {
    // Constructor
    public Dog(int id, double height) {
        super(id, height);
    }

    // Method
    @Override
    public void makeSound() {
        System.out.println("Goof goof");
    }
}
