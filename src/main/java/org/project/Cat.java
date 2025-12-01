package org.project;

public class Cat extends Animal implements Make_Sound {
    // Constructor
    public Cat(int id, double height) {
        super(id, height);
    }

    //Method
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}
