import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Patrick on 2016-01-07.
 */
public class Day4 {

    public static void main (String[] args) throws IOException, NoSuchAlgorithmException {

        //Reading the input and putting it in a string
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\IntelliJIDEACommunityEdition15.0.2\\Workspace\\Advent of Code\\Day 4\\src\\4input.txt"));
        String inputString = reader.readLine();
        StringBuffer hashString = new StringBuffer("GOGO"); //String which will contain the hash, initialized with four junk chars for the while loop's condition check
        MessageDigest md = MessageDigest.getInstance("MD5"); //Hashing thing
        Integer numericSuffix = 0;  //Series of numbers added to the end of the input string, starting at 0 and to be incremented

        //While loop which seeks a hash with a given number of zeroes
        while (!(hashString.toString().startsWith("000000")))
        {
            hashString.delete(0, hashString.length()); //Wiping hashString of junk chars as well as previous hashes
            String inputAndSuffix = inputString + numericSuffix.toString(); //The string of input characters and suffix numbers
            byte[] hash = md.digest(inputAndSuffix.getBytes()); //Array of the string's hashed bytes

            //WARNING: Magic below! In tempHexString, the signed byte is cast to a signed int (the value now in FOUR bytes). In the case of negatives,
            // two's complement means that these will print with a bunch of f's in hex (e.g., -73 is ffffffb7), so the values are ANDed by 0xff
            // (255 or, in binary, 11111111). This gets rid of the f's, leaving only the two hex values, or one byte (e.g., b7), needed.
            for (byte b : hash)
            {
                String tempHexString = Integer.toHexString((int) (b & 0xff));
                //This is bad biz. In turning the byte value to a hex String, it strips the values of their leading zeroes if they're less than 16. For example,
                // "0b" becomes "b" , and so on, which corrupts the hashes. To fix this, we add a leading zero to any String with a character length of one.
                if (tempHexString.length() < 2) {
                    tempHexString = "0" + tempHexString;
                }
                hashString.append(tempHexString); //Finally, we add the value to the hash string.
            }

            numericSuffix++;

        }

        System.out.println("The winning hash is " + hashString + ", provided by the answer " + (numericSuffix - 1) + "!");

    }

}
