import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Patrick on 2016-07-05.
 */
public class Day6 {

    boolean[][] booleanGrid = new boolean[1000][1000];

    public void turnOff(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                booleanGrid[x][y] = false;
            }
        }

    }

    public void turnOn(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                booleanGrid[x][y] = true;
            }
        }
    }

    public void toggle(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (booleanGrid[x][y] == true) {
                    booleanGrid[x][y] = false;
                }
                else if (booleanGrid[x][y] = false) {
                    booleanGrid[x][y] = true;
                }
            }
        }
    }

    public void partOne() throws IOException, InterruptedException {
        // Setting up the graphics and initializing a window
        PixelGrid aGrid = new PixelGrid();

        aGrid.display();

        // Reading input
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\IJ Projects\\Advent-of-Code\\Day 6\\src\\6input.txt"));
        String line = null;

        // Parsing line by line
        String[][] coordinateStrings = new String[2][2]; // Temporary storage of coordinate pairs as strings
        int[][] coordinateInts = new int[2][2]; // Temporary storage of coordinate pairs as ints
        int instructionID = 0; // A number storing and dictating the type of instruction (0/1/2 for turnOff/turnOn/toggle)

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("turn off")) {
                instructionID = 0;
                line = line.substring(9);
            }
            else if (line.startsWith("turn on")) {
                instructionID = 1;
                line = line.substring(8);
            }
            else if (line.startsWith("toggle")){
                instructionID = 2;
                line = line.substring(7);
            }
            // Splitting the coordinate pairs
            coordinateStrings[0] = line.split("through");
            // Splitting the pairs into individual coordinates
            coordinateStrings[1] = coordinateStrings[0][1].split(",");
            coordinateStrings[0] = coordinateStrings[0][0].split(",");
            // Trimming strings
            coordinateStrings[0][0] = coordinateStrings[0][0].trim();
            coordinateStrings[0][1] = coordinateStrings[0][1].trim();
            coordinateStrings[1][0] = coordinateStrings[1][0].trim();
            coordinateStrings[1][1] = coordinateStrings[1][1].trim();
            // Storing the strings as ints in the int array
            coordinateInts[0][0] = Integer.valueOf(coordinateStrings[0][0]);
            coordinateInts[0][1] = Integer.valueOf(coordinateStrings[0][1]);
            coordinateInts[1][0] = Integer.valueOf(coordinateStrings[1][0]);
            coordinateInts[1][1] = Integer.valueOf(coordinateStrings[1][1]);
            // Calling the appropriate method for both this and the graphics class's logic
            if (instructionID == 0) {
                turnOff(coordinateInts[0][0], coordinateInts[0][1],
                        coordinateInts[1][0], coordinateInts[1][1]);
                aGrid.turnOff(coordinateInts[0][0], coordinateInts[0][1],
                        coordinateInts[1][0], coordinateInts[1][1]);
            }
            else if (instructionID == 1) {
                turnOn(coordinateInts[0][0], coordinateInts[0][1],
                        coordinateInts[1][0], coordinateInts[1][1]);
                aGrid.turnOn(coordinateInts[0][0], coordinateInts[0][1],
                        coordinateInts[1][0], coordinateInts[1][1]);
            }
            else if (instructionID == 2) {
                toggle(coordinateInts[0][0], coordinateInts[0][1],
                        coordinateInts[1][0], coordinateInts[1][1]);
                aGrid.toggle(coordinateInts[0][0], coordinateInts[0][1],
                        coordinateInts[1][0], coordinateInts[1][1]);
            }
            aGrid.repaint();
        }

        // After processing all instructions, counting how many lights are still on
        int onCount = 0;

        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (booleanGrid[x][y]) {
                    onCount++;
                }
            }
        }
        System.out.println(onCount + " lights are still lit.");
     }

    public static void main(String[] args) throws IOException, InterruptedException {
        Day6 day6 = new Day6();

        day6.partOne(); // Get the party started.
    }

}
