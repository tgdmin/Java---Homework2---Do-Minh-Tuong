package org.project;

import java.util.ArrayList;

public interface SupervisorChangesListener {
    void onSupervisorsListChanged(ArrayList<Animal> affectedAnimals);
}
