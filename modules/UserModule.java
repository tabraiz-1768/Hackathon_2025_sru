// UserModule.java
package modules;

import java.io.*;
import java.util.Scanner;

public class UserModule {
    private static final String USERS_FILE = "data/users.txt";
    private String username;

    public String getUsername() {
        return username;
    }

    public void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String newUser = scanner.next();
        System.out.print("Enter password: ");
        String newPassword = scanner.next();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(newUser + "," + newPassword);
            writer.newLine();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error: Unable to register user.");
        }
    }

    public boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String inputUsername = scanner.next();
        System.out.print("Enter password: ");
        String inputPassword = scanner.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2 &&
                        credentials[0].equals(inputUsername) &&
                        credentials[1].equals(inputPassword)) {
                    username = inputUsername;
                    System.out.println("Login successful!");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read user data.");
        }

        System.out.println("Invalid username or password. Try again.");
        return false;
    }
}
