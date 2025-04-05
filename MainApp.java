// Main.java
import modules.*;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserModule userModule = new UserModule();
        AlphabetModule alphabetModule = new AlphabetModule();
        NumberModule numberModule = new NumberModule();
        PracticeModule practiceModule = new PracticeModule();
        ProgressModule progressModule = new ProgressModule();
        HelpModule helpModule = new HelpModule();

        System.out.println("Welcome to the Sign Language Learning App!");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> userModule.registerUser(scanner);
                case 2 -> loggedIn = userModule.login(scanner);
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        String currentUser = userModule.getUsername();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Learn Alphabets");
            System.out.println("2. Learn Numbers");
            System.out.println("3. Practice");
            System.out.println("4. View Progress");
            System.out.println("5. Help");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    alphabetModule.learnAlphabets();
                    progressModule.saveProgress(currentUser, progressModule.getUserProgress(currentUser) + 20);
                }
                case 2 -> {
                    numberModule.learnNumbers();
                    progressModule.saveProgress(currentUser, progressModule.getUserProgress(currentUser) + 20);
                }
                case 3 -> {
                    practiceModule.startPractice();
                    progressModule.saveProgress(currentUser, progressModule.getUserProgress(currentUser) + 30);
                }
                case 4 -> progressModule.viewProgress(currentUser);
                case 5 -> helpModule.displayHelp();
                case 6 -> {
                    System.out.println("Thank you for using the app. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
