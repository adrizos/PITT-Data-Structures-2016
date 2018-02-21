/**
 * Alex Drizos
 * CS 0445
 * Assignment 5
 */
//imports
import java.io.*;
import java.util.*;


public class Assig5
{

    public static void main (String [] args) throws IOException
    {
        //variables
        String fileName = args[0]; //takes command line file name
        File file = new File (fileName); // create file object
        Scanner fileScan = new Scanner(file); //create scanner for text file
        ArrayList <String> fileArray = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in); //scanner for user entry
        Scanner keyboard2 = new Scanner(System.in); //scanner for user string
        Scanner keyboard3 = new Scanner(System.in); //scanner for user huffman string
        int userChoice = 0; // user operation choice
        Boolean forward = true; // value for user entry while loop
        String userEntry = " "; // user entered string for encoding
        String encodedString = ""; //string for encoded results
        String compressed = ""; //string for user huffman string

        //read in file
        while (fileScan.hasNext())
        {
            fileArray.add(fileScan.nextLine());
        } //end of loop to read file

        //create huffman tree object
        HuffmanTree huffmanTree = new HuffmanTree(fileArray);
        huffmanTree.buildEncodingTable(huffmanTree.root, "");
        //inform user
        System.out.println("The Huffman Tree has been restored\n");

        //get user entry
        System.out.print("Please choose from the following:\n");
        System.out.println("1) Encode a text string\n" +
                "2) Decode a Huffman string\n" +
                "3) Quit");
        userChoice = keyboard.nextInt();

        //establish user choice loop
        while (forward)
        {
            if (userChoice == 1) //encode a text string
            {
                //get users string from selection of letters
                System.out.print("Enter a String from the following characters - ABCDEF: ");
                userEntry = keyboard2.next().toUpperCase();

                //encode selected string
                for (int i = 0; i < userEntry.length(); i++)
                {
                    encodedString += huffmanTree.table.get(userEntry.charAt(i)) + "\n";
                } //end of loop to cycle through user's string

                //print huffman string
                System.out.println(encodedString);

            }
            if (userChoice == 2) //decode a Huffman string
            {
                //show user encoding table
                for(Character key : huffmanTree.table.keySet())
                {
                    System.out.println(key + " : " + huffmanTree.table.get(key));
                }

                //get user huffman string
                System.out.println("Please enter a Huffman string (one line, no spaces): ");
                compressed = keyboard3.nextLine();

                //decode huffman string and print, requires tree traversal in object
                System.out.println("Text String: \n" + huffmanTree.decodeHString(huffmanTree.root, compressed));

            }
            if (userChoice == 3)
            {
                System.out.println("\nGood-bye");
                System.exit(0); //end program run
            }

            //get user entry again
            System.out.print("Please choose from the following:\n");
            System.out.println("1) Encode a text string\n" +
                    "2) Decode a Huffman string\n" +
                    "3) Quit");
            userChoice = keyboard.nextInt();

            //reset values
            encodedString = ""; // reset this value for possible second entry
        }

        /**
        //print table
        for(Character key : huffmanTree.table.keySet())
        {
            System.out.println(key + " : " + huffmanTree.table.get(key));
        } **/

    } //end of main



} //end of Assig5 class
