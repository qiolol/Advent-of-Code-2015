import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Patrick on 2015-12-27.
 */
public class Day2 {

    public static void main (String[] args) {


        //PART ONE

        BufferedReader reader;
        String input = null;

        //Reading a file
        try {
            reader = new BufferedReader(new FileReader("C:\\Java\\IntelliJIDEACommunityEdition15.0.2\\Workspace\\Advent of Code\\Day 2\\2input.txt"));
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(input);
    }
}
