package module24;

import java.io.*;
import java.util.*;

public class UniqueWordsCounter {
   // public static void main(String[] args) throws FileNotFoundException {
    
        // Create a scanner to read the text file
        Scanner scanner = new Scanner(new File("C:\\Users\\jonat\\IdeaProjects\\JH ZP12 M2\\src\\module24\\illiad.txt"));

        // Create a hash set to store unique words
        Set<String> uniqueWords = new HashSet<String>();

        // Iterate over each line in the text file
        while (scanner.hasNextLine()) {
            // Get the next line of text
            String line = scanner.nextLine();

            // Split the line into words
            String[] words = line.split("[^\\w']+");

            // Iterate over each word in the line
            for (String word : words) {
                // Convert the word to lowercase and remove leading/trailing punctuation
                word = word.toLowerCase().replaceAll("^\\W+|\\W+$", "");

                // Check if the word is a valid word (i.e. not empty)
                if (!word.isEmpty()) {
                    // Add the word to the hash set (if it is not already in the set)
                    uniqueWords.add(word);
                }
            }
        }

        
        System.out.println("The number of unique words in the text is: " + uniqueWords.size());
   // }
}
