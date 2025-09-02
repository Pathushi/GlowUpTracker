package service;

import model.Progress;
import model.Habit;
import util.FileHandler;

public class TrackerService {
    private Progress progress;
    private final String DATA_FILE = "data/progress.json";

    public TrackerService() {
        progress = FileHandler.loadProgress(DATA_FILE);
        if (progress == null) progress = new Progress();
    }

    public Progress getProgress() { return progress; }

    public void addHabit(Habit habit) {
        progress.addHabit(habit);
        save();
    }

    public void updateHabit(Habit habit, boolean completed) {
        habit.setCompleted(completed);
        save();
    }

    public void save() {
        FileHandler.saveProgress(progress, DATA_FILE);
    }
}
