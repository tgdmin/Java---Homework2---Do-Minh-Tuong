package org.project;

import javax.management.openmbean.TabularData;
import java.util.ArrayList;
import java.util.HashMap;

public class Zoo {
    private ArrayList<Animal> animals;
    private ArrayList<Supervisor> supervisors;
    // hash map
    private HashMap<Integer, Animal> animalMap;
    private HashMap<Integer, Supervisor> supervisorMap;
    private ArrayList<SupervisorChangesListener>  supervisorChangesListeners;

    //Constructor
    public Zoo() {
        animals = new ArrayList<Animal>();
        supervisors = new ArrayList<Supervisor>();
        supervisorChangesListeners = new ArrayList<SupervisorChangesListener>();

        animalMap = new HashMap<>();
        supervisorMap = new HashMap<>();

    }
    public Zoo(ArrayList<Animal> given_animals) {
        animals = given_animals;
        supervisors = new ArrayList<Supervisor>();
        supervisorChangesListeners = new ArrayList<SupervisorChangesListener>();
        // initialize HashMaps
        animalMap = new HashMap<>();
        supervisorMap = new HashMap<>();
        // preload existing animals into the hash map
        if (given_animals != null) {
            for (Animal a : given_animals) {
                animalMap.put(a.getId(), a);
            }
        }
    }

    // Observer
    public void addSupervisorChangesListener(SupervisorChangesListener listener) {
        supervisorChangesListeners.add(listener);
    }
    public void removeSupervisorChangesListener(SupervisorChangesListener listener) {
        supervisorChangesListeners.remove(listener);
    }
    private void notifySupervisorChanges(ArrayList<Animal> Animals) {
        for (SupervisorChangesListener listener : supervisorChangesListeners) {
            listener.onSupervisorsListChanged(Animals);
        }
    }

    //Simple Method
    //Manage Animal
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public Animal findAnimal(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }
    public Animal deleteAnimal(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animals.remove(animal);
                return animal;
            }
        }
        return null;
    }

    //Manage Supervisor
    public void addSupervisor(Supervisor supervisor) {
        supervisors.add(supervisor);
    }
    public Supervisor findSupervisor(int id) {
        for (Supervisor supervisor : supervisors) {
            if (supervisor.getId() == id) {
                return supervisor;
            }
        }
        return null;
    }
    public void assignSupervisor(int animal_id, Supervisor supervisor) {
        Animal animal = findAnimal(animal_id);
        animal.setSupervisor(supervisor);
        System.out.println("Assigned animal " + animal.getId() + " to supervisor " + supervisor.getId());
        //Notify Listener
        ArrayList<Animal> changed = new ArrayList<>();
        changed.add(animal);
        notifySupervisorChanges(changed);
    }

    //Complex Method
    public ArrayList<Animal> getAnimalsViaSupervisorId(int id) {
        ArrayList<Animal> animalsViaSupervisor = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getSupervisor().getId() == id) {
                animalsViaSupervisor.add(animal);
            }
        }
        return animalsViaSupervisor;
    }
    public ArrayList<Animal> getAnimalsViaSupervisorName(String name) {
        ArrayList<Animal> animalsViaSupervisor = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getSupervisor().getName().equals(name)) {
                animalsViaSupervisor.add(animal);
            }
        }
        return animalsViaSupervisor;
    }
    public ArrayList<Animal> getAnimalsTallerThan(double height) {
        ArrayList<Animal> animalsTallerThan = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getHeight() >= height) {
                animalsTallerThan.add(animal);
            }
        }
        return animalsTallerThan;
    }
    public ArrayList<Animal> getAnimalsMakeSound() {
        ArrayList<Animal> animalsMakeSound = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Make_Sound) {
                animalsMakeSound.add(animal);
            }
        }
        return animalsMakeSound;
    }

    public ArrayList<Animal> getAnimalsByClass(String animal_class) {
        ArrayList<Animal> animalsByClass = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getClass().getSimpleName().equals(animal_class)) {
                animalsByClass.add(animal);
            }
        }
        return animalsByClass;
    }
}

