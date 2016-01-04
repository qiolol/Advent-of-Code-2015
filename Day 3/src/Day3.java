import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Patrick on 2016-01-01.
 */
public class Day3 {

    public static void main(String[] args) throws IOException {

        //PART ONE
        if (args[0].equals("Part1")) {

            BufferedReader reader;
            ArrayList<String> housesVisited = new ArrayList<String>(); //History array, to contain all of the houses visited so far
            int x = 0; //The X coordinate
            int y = 0; //The Y coordinate
            housesVisited.add(new House(x, y).getPair()); //First house, at the origin, is added to the history array
            int visitCount = 1; //Total number of house visits, starting with the first house
            int revisitCount = 0; //Total number of houses revisited

            //Reading input
            reader = new BufferedReader(new FileReader("C:\\Java\\IntelliJIDEACommunityEdition15.0.2\\Workspace\\Advent of Code\\Day 3\\src\\3input.txt"));
            int charIterator;
            while ((charIterator = reader.read()) != -1) {

                char character = (char) charIterator;
                //Direction handling
                if (character == '>') {         //East
                    x += 1;
                } else if (character == '<') {    //West
                    x -= 1;
                } else if (character == '^') {    //North
                    y += 1;
                } else if (character == 'v') {    //South
                    y -= 1;
                }

                House newHouse = new House(x, y); //The new house being visited
                visitCount++;

                //Counting how many houses were visited at least once
                String currentCoordinates = newHouse.getPair(); //Getting the coordinates of the current house

                for (int i = 0; i < visitCount - 1; i++) {
                    if (housesVisited.get(i).equals(currentCoordinates)) {
                        revisitCount++;
                        break;
                    }
                }

                housesVisited.add(newHouse.getPair()); //Storing the coordinates of the new house in the history array

            }

            System.out.println("The first year, " + visitCount + " visits were made,");
            System.out.println(revisitCount + " redundant visits were made,");
            System.out.println("and " + (visitCount - revisitCount) + " unique houses were visited.");
        }

        //PART TWO
        else if (args[0].equals("Part2")) {

            BufferedReader reader;
            ArrayList<String> housesVisited = new ArrayList<String>(); //History array, to contain all of the houses visited so far
            int meatX = 0, roboX = 0, x = 0; //The X coordinate for MeatSanta, RoboSanta, and common, respectively
            int meatY = 0, roboY = 0, y = 0; //The Y coordinate for MeatSanta, RoboSanta, and common, respectively
            housesVisited.add(new House(x, y).getPair()); //First house, at the origin, is added to the history array
            int visitCount = 1; //Total number of house visits, starting with the first house
            int revisitCount = 0; //Total number of houses revisited

            //Reading input
            reader = new BufferedReader(new FileReader("C:\\Java\\IntelliJIDEACommunityEdition15.0.2\\Workspace\\Advent of Code\\Day 3\\src\\3input.txt"));
            int charIterator;
            while ((charIterator = reader.read()) != -1) {

                char character = (char) charIterator;
                //Direction handling for MeatSanta
                if (visitCount % 2 == 1) {
                    if (character == '>') {         //East
                        meatX += 1;
                    } else if (character == '<') {    //West
                        meatX -= 1;
                    } else if (character == '^') {    //North
                        meatY += 1;
                    } else if (character == 'v') {    //South
                        meatY -= 1;
                    }
                    x = meatX;
                    y = meatY;
                }
                //Direction handling for RoboSanta
                else {
                    if (character == '>') {         //East
                        roboX += 1;
                    } else if (character == '<') {    //West
                        roboX -= 1;
                    } else if (character == '^') {    //North
                        roboY += 1;
                    } else if (character == 'v') {    //South
                        roboY -= 1;
                    }
                    x = roboX;
                    y = roboY;
                }

                House newHouse = new House(x, y); //The new house being visited
                visitCount++;

                //Counting how many houses were visited at least once
                String currentCoordinates = newHouse.getPair(); //Getting the coordinates of the current house

                for (int i = 0; i < visitCount - 1; i++) {
                    if (housesVisited.get(i).equals(currentCoordinates)) {
                        revisitCount++;
                        break;
                    }
                }

                housesVisited.add(newHouse.getPair()); //Storing the coordinates of the new house in the history array

            }

            System.out.println("The second year, " + visitCount + " visits were made,");
            System.out.println(revisitCount + " redundant visits were made,");
            System.out.println("and " + (visitCount - revisitCount) + " unique houses were visited.");
        }
    }
}