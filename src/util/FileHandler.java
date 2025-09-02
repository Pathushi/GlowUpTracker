package src.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import src.model.Progress;

import java.io.*;

public class FileHandler {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Progress loadProgress(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Progress.class);
        } catch (FileNotFoundException e) {
            return null; // File not found, start new progress
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveProgress(Progress progress, String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(progress, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
