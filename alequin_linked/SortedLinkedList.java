/**
 * SortedLinkedList.java
 * 
 * This program reads a list of integer numbers from the standard input,
 * stores them in a LinkedList, sorts the list from smallest to largest,
 * and displays the sorted list.
 * 
 * Usage:
 *      Compile: javac SortedLinkedList.java
 *      Run:     java SortedLinkedList
 * 
 * To generate Javadoc:
 *      javadoc -d doc SortedLinkedList.java
 * 
 * Author: Edgardo A.
 * Date: 09/23/2024
 */

import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SortedLinkedList {

    /**
     * The main method executes the program.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a LinkedList to store integers
        LinkedList<Integer> numbers = new LinkedList<>();

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers separated by spaces (press Enter to finish):");

        try {
            // Read the entire line of input
            String inputLine = scanner.nextLine();
            // Split the input line into tokens based on whitespace
            String[] tokens = inputLine.trim().split("\\s+");

            // Parse each token into an integer and add to the LinkedList
            for (String token : tokens) {
                if (!token.isEmpty()) { // Check for empty strings
                    int number = Integer.parseInt(token);
                    numbers.add(number);
                }
            }

            // Sort the LinkedList in ascending order
            Collections.sort(numbers);

            // Display the sorted list
            System.out.println("Sorted LinkedList:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println(); // Newline for better formatting

        } catch (NumberFormatException e) {
            System.err.println("Error: Please enter valid integers separated by spaces.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input.");
        } finally {
            // Close the scanner to prevent resource leaks
            scanner.close();
        }
    }
}
