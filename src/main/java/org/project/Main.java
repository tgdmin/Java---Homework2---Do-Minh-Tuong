package org.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addSupervisorChangesListener(new ZooLogger());

        // Create Supervisors
        Supervisor alice = new Supervisor(1, "Alice");
        Supervisor bob = new Supervisor(2, "Bob");

        zoo.addSupervisor(alice);
        zoo.addSupervisor(bob);

        // Create Animals
        Animal cat   = new Cat(101, 0.30);
        Animal dog   = new Dog(102, 0.55);
        Animal horse = new Horse(103, 1.75);
        Animal hippo = new Hippo(104, 1.60);
        Animal fish  = new Fish(105, 0.06);

        zoo.addAnimal(cat);
        zoo.addAnimal(dog);
        zoo.addAnimal(horse);
        zoo.addAnimal(hippo);
        zoo.addAnimal(fish);

        // Assign supervisors
        zoo.assignSupervisor(101, alice); // cat
        zoo.assignSupervisor(102, alice); // dog
        zoo.assignSupervisor(103, bob);   // horse
        zoo.assignSupervisor(104, bob);   // hippo
        zoo.assignSupervisor(105, alice); // fish

        // find and delete
        System.out.println("\nFind animal id=102 → " + zoo.findAnimal(102));
        System.out.println("Delete animal id=102 → " + zoo.deleteAnimal(102));
        System.out.println("Find animal id=102 again → " + zoo.findAnimal(102));

        // find Animals by supervisor
        System.out.println("\nAnimals supervised by Alice:");
        for (Animal a : zoo.getAnimalsViaSupervisorName("Alice")) {
            System.out.println(a);
        }

        System.out.println("\nAnimals supervised by Bob:");
        for (Animal a : zoo.getAnimalsViaSupervisorId(2)) {
            System.out.println(a);
        }

        // Taller than
        System.out.println("\nAnimals taller than 1.0m:");
        for (Animal a : zoo.getAnimalsTallerThan(1.0)) {
            System.out.println(a);
        }

        // Animals that can make sounds
        System.out.println("\nAnimals that can make sounds:");
        for (Animal a : zoo.getAnimalsMakeSound()) {
            System.out.println(a);
            ((Make_Sound) a).makeSound();  // cast to interface to call the sound
        }

        // Find Animals by class
        System.out.println("\nAnimals of the class Cat");
        for (Animal a : zoo.getAnimalsByClass("Cat")) {
            System.out.println(a);
        }
    }
}

