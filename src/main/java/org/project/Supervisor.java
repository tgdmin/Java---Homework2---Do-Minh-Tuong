package org.project;

public class Supervisor {
    private int id;
    private String name;

    //Constructor
    public Supervisor() {}
    public Supervisor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getter & Setter
    public void  setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
