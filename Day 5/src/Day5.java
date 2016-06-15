import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Patrick on 2016-06-10.
 */
public class Day5 {

    // String counters
    static int totalCount = 0; // Superfluous, only used in partOne()
    static int niceCount = 0; // partOne()
    static int niceCount2 = 0; // partTwo()

    public static void main(String[] args) throws IOException {
        // Reading input
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\IJ Projects\\Advent-of-Code\\Day 5\\src\\5input.txt"));
        String line = null;

        // Iterating over and analyzing each string down the list
        while ((line = reader.readLine()) != null) {
            partOne(line);
            partTwo(line);
        }
        // Returning final counts
        System.out.println("Part One: " + niceCount + " out of " + totalCount + " strings were found to be nice.");
        System.out.println("Part Two: " + niceCount2 + " out of " + totalCount + " strings were found to be nice.");
    }

    /*
     Part One: counting the number of strings in a list that
     - Have at least three vowels (aeiou)
     - Contain at least one letter appearing twice in a row (e.g., "xx" in "axxaa")
     - Do not contain the strings "ab", "cd", "pq", or "xy"
      */
    public static void partOne(String stringIn) {
        int vowelCount = 0;
        int repetitions = 0;

        // If the current string contains the forbidden substrings,
        if (stringIn.contains("ab")
                || stringIn.contains("cd")
                || stringIn.contains("pq")
                || stringIn.contains("xy")) {
            // do nothing.
        }
        // Otherwise, count vowels and letter repetitions.
        else {
            char prevChar = '0';

            for (int i = 0; i < stringIn.length(); i++) {
                // Counting vowels
                if (stringIn.charAt(i) == 'a'
                        || stringIn.charAt(i) == 'e'
                        || stringIn.charAt(i) == 'i'
                        || stringIn.charAt(i) == 'o'
                        || stringIn.charAt(i) == 'u') {
                    vowelCount++;
                }
                // Counting repetitions
                if (i == 0) {
                    prevChar = stringIn.charAt(i); // Storing the present char for subsequent comparison
                }
                else {
                    if (stringIn.charAt(i) == prevChar) {
                        repetitions++;
                    }
                    prevChar = stringIn.charAt(i); // Updating present char
                }
            }
        }
        // Finally, deciding whether the string was "nice" or not
        if (vowelCount > 2 && repetitions > 0) {
            niceCount++;
        }
        totalCount++;
    }

    /*
    Part Two: counting the number of strings in a list that
    - Contain a pair of any two letters that at appears at least twice without overlapping (e.g., "xy" in "xyaaxy" but not "aa" in "xaaax")
    - Contain at least one letter which repeats with exactly one letter between (e.g., "bab" in "aababa")
     */
    public static void partTwo(String stringIn) {
        int pairCount = 0;
        int staggeredRepeats = 0;

        // Counting repeating pairs
        for (int i = 0; i < stringIn.length(); i++ ) {
            for (int j = i + 1; j < stringIn.length(); j++) {
                if (stringIn.charAt(i) == stringIn.charAt(j)) {
                    // Counting repeating pairs
                    if ((j < (stringIn.length() - 1)) // If the bound is respected,
                            && (stringIn.charAt(i + 1) == stringIn.charAt(j + 1)) // and the char after i matches that after j,
                            && ((i + 1) != j)) { // but the char after i is not j (to preclude counts of overlapping),
                        pairCount++; // a repeating pair is detected.
                    }
                    // Counting staggered repeats
                    if (j - i == 2) {
                        staggeredRepeats++;
                    }
                }
            }
        }
        // Finally, deciding whether the string was nice or not
        if (pairCount > 0 && staggeredRepeats > 0) {
            niceCount2++;
        }
    }

}