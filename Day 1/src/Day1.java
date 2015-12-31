import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Patrick on 2015-12-22.
 */
public class Day1 {

    public static void main (String[] args) {


        //PART ONE

        BufferedReader br;
        int count = 0;
        String input = null;

        //Reading a file
        try {
            br = new BufferedReader(new FileReader("C:\\Java\\IntelliJIDEACommunityEdition15.0.2\\Workspace\\Advent of Code\\Day 1\\src\\1input.txt"));
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Counting
        for (int i = 0; i < input.length(); i++) {
            count = (input.charAt(i) == '(') ? ++count : --count;
        }

        System.out.println("The final floor is: " + count);


        //PART TWO

        count = 0;

        for (int i = 0; i < input.length(); i++) {
            count = (input.charAt(i) == '(') ? ++count : --count;
            if (count == -1) {
                System.out.println("Basement entered at :" + i);
                break;
            }
        }
    }

}

