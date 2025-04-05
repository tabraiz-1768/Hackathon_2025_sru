package modules;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProgressModule {
    private static final String PROGRESS_DIR = "out/progress/";
    private static final String PROGRESS_FILE = PROGRESS_DIR + "progress.txt";
    private Map<String, Integer> progressData;

    public ProgressModule() {
        File dir = new File(PROGRESS_DIR);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (created) {
                System.out.println("Progress directory created at: " + PROGRESS_DIR);
            } else {
                System.out.println("Failed to create progress directory!");
            }
        }
        loadProgress();
    }

    private void loadProgress() {
        progressData = new HashMap<>();
        File file = new File(PROGRESS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        progressData.put(parts[0], Integer.parseInt(parts[1]));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading progress file: " + e.getMessage());
            }
        }
    }

    public void saveProgress(String user, int progress) {
        progressData.put(user, progress);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROGRESS_FILE))) {
            for (Map.Entry<String, Integer> entry : progressData.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to progress file: " + e.getMessage());
        }
    }

    public int getUserProgress(String user) {
        return progressData.getOrDefault(user, 0);
    }

    public void viewProgress(String user) {
        int progress = getUserProgress(user);
        System.out.println("\nProgress for " + user + ": " + progress + "%");
        if (progress >= 100) {
            System.out.println("Congratulations! You have mastered the basics of sign language.");
        } else {
            System.out.println("Keep learning and practicing to improve your skills.");
        }
    }
}
