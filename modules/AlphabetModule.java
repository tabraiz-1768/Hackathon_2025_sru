package modules;

import java.io.*;

public class AlphabetModule {
    private static final String ALPHABETS_FILE = "data/alphabets.txt";

    public void learnAlphabets() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ALPHABETS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Could not load alphabets.");
        }
    }
}
