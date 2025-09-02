package model;

public class Habit {
    private String name;
    private String frequency; // daily, weekly
    private boolean completed;

    public Habit(String name, String frequency) {
        this.name = name;
        this.frequency = frequency;
        this.completed = false;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
