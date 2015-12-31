import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Patrick on 2015-12-27.
 */
public class Day2 {

    public static void main (String[] args) throws IOException {

        BufferedReader reader;
        String line;
        int totalWrappingPaper = 0; //Amount of wrapping paper required for all presents
        int totalRibbon = 0; //Amount of ribbon required for all presents

        //Reading a file
        reader = new BufferedReader(new FileReader("C:\\Java\\IntelliJIDEACommunityEdition15.0.2\\Workspace\\Advent of Code\\Day 2\\src\\2input.txt"));

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            //Splitting each line after reading it
            String[] lineParts = line.split("x");
            //Initializing dimensional values from their corresponding line parts
            int length = Integer.parseInt(lineParts[0]);
            int width = Integer.parseInt(lineParts[1]);
            int height = Integer.parseInt(lineParts[2]);
            //Finding the minimum area
            int minimumArea = (length * width < width * height) ? length * width : width * height;
            minimumArea = (minimumArea < height * length) ? minimumArea : height * length;
            //Finding the minimum perimeter
            int minimumPerimeter = ((2 * length + 2 * width) < (2 * width + 2 * height)) ? (2 * length + 2 * width) : (2 * width + 2 * height);
            minimumPerimeter = (minimumPerimeter < (2 * length + 2 * height)) ? minimumPerimeter : (2 * length + 2 * height);
            //Calculating the amount of wrapping paper required (surface area plus the minimum area for the slack) for the current present
            int currentWrappingPaper = 2 * length * width + 2 * width * height + 2 * height * length + minimumArea;
            //Calculating the amount of ribbon required (minimum perimeter plus the volume) for the current present
            int currentRibbon = minimumPerimeter + length * width * height;
            //Amending the counting totals
            totalWrappingPaper += currentWrappingPaper;
            totalRibbon += currentRibbon;
        }

        System.out.println("And the grand total is... " + totalWrappingPaper + " square feet of wrapping paper and " + totalRibbon + " feet of ribbon!");
    }
}
