package org.project;

public abstract class Animal {
    private int id;
    private double height;
    private Supervisor supervisor;

    //Constructor
    public Animal() {}
    public Animal(int id, double height) {
        this.id = id;
        this.height = height;
    }

    // Getter & Setter
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public void setSupervisor(Supervisor supervisor){
        this.supervisor = supervisor;
    }
    public Supervisor getSupervisor(){
        return this.supervisor;
    }

    // Methods
    @Override
    public String toString() {
        String supervisorName = (supervisor == null) ? "none" : supervisor.getName();
        return getClass().getSimpleName() + "{id=" + id +
                ", height=" + height +
                ", supervisor=" + supervisorName + "}";
    }

}
