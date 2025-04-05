package modules;

import java.io.*;

public class NumberModule {
    private static final String NUMBERS_FILE = "data/numbers.txt";

    public void learnNumbers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NUMBERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Could not load numbers.");
        }
    }
}
