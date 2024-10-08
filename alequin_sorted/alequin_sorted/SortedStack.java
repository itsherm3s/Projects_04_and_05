/**
 * SortedStack.java
 * 
 * This program reads a list of integer numbers from the standard input,
 * stores them in a Stack, sorts the stack from smallest to largest,
 * and displays the sorted stack.
 * 
 * Usage:
 *      Compile: javac SortedStack.java
 *      Run:     java SortedStack
 * 
 * To generate Javadoc:
 *      javadoc -d doc SortedStack.java
 * 
 * Author: Edgardo A.
 * Date: 09/30/2024
 */

 import java.util.InputMismatchException;
 import java.util.Scanner;
 import java.util.Stack;
 
 public class SortedStack {
 
     /**
      * The main method executes the program.
      * 
      * @param args Command-line arguments (not used).
      */
     public static void main(String[] args) {
         // Create a Stack to store integers
         Stack<Integer> numbers = new Stack<>();
 
         // Create a Scanner object to read input from the user
         Scanner scanner = new Scanner(System.in);
 
         System.out.println("Enter integers separated by spaces (press Enter to finish):");
 
         try {
             // Read the entire line of input
             String inputLine = scanner.nextLine();
             // Split the input line into tokens based on whitespace
             String[] tokens = inputLine.trim().split("\\s+");
 
             // Parse each token into an integer and add to the Stack
             for (String token : tokens) {
                 if (!token.isEmpty()) { // Check for empty strings
                     int number = Integer.parseInt(token);
                     numbers.push(number);
                 }
             }
 
             // Sort the Stack in ascending order
             // Use a temporary Stack to hold sorted numbers
             Stack<Integer> sortedStack = new Stack<>();
             while (!numbers.isEmpty()) {
                 int temp = numbers.pop();
                 // While the temporary stack is not empty and the top element
                 // is greater than the temp, pop from the temporary stack
                 while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                     numbers.push(sortedStack.pop());
                 }
                 sortedStack.push(temp);
             }
 
             // Display the sorted stack
             System.out.println("Sorted Stack:");
             while (!sortedStack.isEmpty()) {
                 System.out.print(sortedStack.pop() + " ");
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
 