package src.model;

import java.util.ArrayList;
import java.util.List;

public class Progress {
    private List<Habit> habits;

    public Progress() {
        habits = new ArrayList<>();
    }

    public List<Habit> getHabits() { return habits; }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    public void removeHabit(Habit habit) {
        habits.remove(habit);
    }
}
