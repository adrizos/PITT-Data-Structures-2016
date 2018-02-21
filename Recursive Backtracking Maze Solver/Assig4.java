

/**
 * Alex Drizos
 * CS 0445 Spring 2016
 * Assignment 4 - Maze
 */

//imports
import java.io.IOException;
import java.util.*;
import java.io.*;


public class Assig4 {

    public static void main (String args []) throws IOException
    {
        //variables
        int width =0;
        int height = 0;
        String fileName = args[0]; //takes command line file name
        File file = new File (fileName); // create file object
        Scanner fileScan = new Scanner(file); //create scanner for text file
        ArrayList <Maze> mazeList = new ArrayList<>();
        ArrayList <String> mazeInfo = new ArrayList<>();

        //parse input file to gather set up data
        // first line dimensions (rows, columns)
        // second line entry point dimensions (row,column)
        while (fileScan.hasNextLine())
        {
            String [] dimensions = (fileScan.nextLine()).split(" ");
            height = Integer.parseInt(dimensions[0]);
            width = Integer.parseInt(dimensions[1]);

            String [] entryPoints = (fileScan.nextLine()).split(" ");

            for (int r = 0; r < height; r++)
            {
                mazeInfo.add(fileScan.nextLine());

            }   //end of outer loop i

            //create maze object
            mazeList.add(new Maze(height,width,entryPoints,mazeInfo));
        }   //end of loop to seperate mazes


        int numMazes = mazeList.size();

        for (int q = 0; q < numMazes; q++)
        {
            System.out.println("\n\n----------------------------------------\n");

            System.out.println("The new board is: \n"+ mazeList.get(q));

            System.out.println("Searching for solutions starting at: (" + mazeList.get(q).start.row + "," + mazeList.get(q).start.col + ")\n");


            //print solution points list and grid
            int counter = 0;
            int shortestNumSegments;
            int min = mazeList.get(q).solutions.get(0).size();
            int minIndex=0;
            for (ArrayList <Maze.Point> path : mazeList.get(q).solutions)
            {
                System.out.println("Solution found with " + mazeList.get(q).solutions.get(counter).size() + " segments");
                System.out.println(mazeList.get(q).printSolution(counter));
                System.out.print("Path: ");
                for (Maze.Point p : path)
                {
                    System.out.print(p + " ");
                }

                System.out.println("\n");
                if (mazeList.get(q).solutions.get(counter).size() < min)
                {
                    min = mazeList.get(q).solutions.get(counter).size();
                    minIndex = counter;
                }

                counter++;
            }

            System.out.println("There were a total of " + mazeList.get(q).solutions.size() + " solutions found");
            System.out.println("A total of " + mazeList.get(q).numRecurs + " recursive calls were made");
            System.out.println("The shortest solution had " + min + " segments");
            System.out.println(mazeList.get(q).printSolution(minIndex));
            for (int t = 0; t < mazeList.get(q).solutions.get(minIndex).size(); t++ )
            {
                System.out.print(mazeList.get(q).solutions.get(minIndex).get(t) + " ");
            }
        }





    }//end of main





} //end of class
