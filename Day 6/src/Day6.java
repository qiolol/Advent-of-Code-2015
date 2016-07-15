import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Patrick on 2016-07-05.
 */
public class Day6 {

    boolean[][] booleanGrid = new boolean[1000][1000]; // For Part One
    int[][] intGrid = new int[1000][1000]; // For Part Two

    public void turnOff(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                booleanGrid[x][y] = false;
                if (intGrid[x][y] > 0) {
                    intGrid[x][y]--;
                }
            }
        }

    }

    public void turnOn(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                booleanGrid[x][y] = true;
                intGrid[x][y]++;
            }
        }
    }

    public void toggle(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (booleanGrid[x][y] == true) {
                    booleanGrid[x][y] = false;
                }
                else {
                    booleanGrid[x][y] = true;
                }
                intGrid[x][y] += 2;
            }
        }
    }

    public void partOneAndTwo() throws IOException, InterruptedException {
        // Setting up the graphics and initializing a window
        PixelGrid aGrid = new PixelGrid();

        aGrid.display();

        // Reading input
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\IJ Projects\\Advent-of-Code\\Day 6\\src\\6input.txt"));
        String line = null;

        // Parsing line by line
        String[][] coordinateStrings = new String[2][2]; // Temporary storage of coordinate pairs as strings
        int instructionID = 0; // A number storing and dictating the type of instruction (0/1/2 for turnOff/turnOn/toggle)
        int delay = 0; // Desired delay between instructions

        while ((line = reader.readLine()) != null) {
            Thread.sleep(delay);
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
            // Calling the appropriate method for both this and the graphics class's logic
            if (instructionID == 0) {
                turnOff(Integer.valueOf(coordinateStrings[0][0]), Integer.valueOf(coordinateStrings[0][1]),
                        Integer.valueOf(coordinateStrings[1][0]), Integer.valueOf(coordinateStrings[1][1]));
                aGrid.turnOff(Integer.valueOf(coordinateStrings[0][0]), Integer.valueOf(coordinateStrings[0][1]),
                        Integer.valueOf(coordinateStrings[1][0]), Integer.valueOf(coordinateStrings[1][1]));
            }
            else if (instructionID == 1) {
                turnOn(Integer.valueOf(coordinateStrings[0][0]), Integer.valueOf(coordinateStrings[0][1]),
                        Integer.valueOf(coordinateStrings[1][0]), Integer.valueOf(coordinateStrings[1][1]));
                aGrid.turnOn(Integer.valueOf(coordinateStrings[0][0]), Integer.valueOf(coordinateStrings[0][1]),
                        Integer.valueOf(coordinateStrings[1][0]), Integer.valueOf(coordinateStrings[1][1]));
            }
            else if (instructionID == 2) {
                toggle(Integer.valueOf(coordinateStrings[0][0]), Integer.valueOf(coordinateStrings[0][1]),
                        Integer.valueOf(coordinateStrings[1][0]), Integer.valueOf(coordinateStrings[1][1]));
                aGrid.toggle(Integer.valueOf(coordinateStrings[0][0]), Integer.valueOf(coordinateStrings[0][1]),
                        Integer.valueOf(coordinateStrings[1][0]), Integer.valueOf(coordinateStrings[1][1]));
            }
            aGrid.repaint();
        }

        // After processing all instructions,
        int onCount = 0; // counting how many lights are still on for Part One
        int brightnessCount = 0; // and the collective brightness for Part Two

        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (booleanGrid[x][y]) {
                    onCount++;
                }
                brightnessCount += intGrid[x][y];
            }
        }
        System.out.println("Part One: " + onCount + " lights are still lit.");
        System.out.println("Part Two: " + brightnessCount + " is the total brightness of all lights.");
     }

    public static void main(String[] args) throws IOException, InterruptedException {
        Day6 day6 = new Day6();

        day6.partOneAndTwo(); // Get the party started.
    }

}
