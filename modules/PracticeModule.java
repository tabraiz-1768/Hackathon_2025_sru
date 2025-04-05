package modules;

import java.util.Scanner;

public class PracticeModule {
    public void startPractice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Practice session started. Try signing letters and numbers!");

        System.out.print("Enter a letter to test: ");
        char input = scanner.next().charAt(0);
        System.out.println("Well done! Keep practicing.");
    }
}
