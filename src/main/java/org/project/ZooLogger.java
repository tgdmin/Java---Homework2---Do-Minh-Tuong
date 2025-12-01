package org.project;

import java.util.ArrayList;

public class ZooLogger implements SupervisorChangesListener {
    @Override
    public void onSupervisorsListChanged(ArrayList<Animal> affectedAnimals) {
        System.out.println("[Listener] Supervisor assignments changed:");
        for (Animal a : affectedAnimals) {
            String supervisor = a.getSupervisor().getName();
            System.out.println("  - " + a.getClass().getSimpleName() + " id=" + a.getId() + " now supervised by " + supervisor);
        }
    }
}
