import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by alexdrizosair
 */
public class Maze
{
    public class Point
    {
        int row, col;
        public Point(int r, int c)
        {
            row = r;
            col = c;
        }  //end of constructor

        public boolean equals (Object p)
        {
            Point pp = (Point) p;
            return this.row == pp.row && this.col == pp.col;
        }

        public Point moveNorth()
        {
            return new Point (this.row-1, this.col);
        }
        public Point moveSouth()
        {
            return new Point (this.row+1, this.col);
        }
        public Point moveEast()
        {
            return new Point (this.row, this.col+1);
        }
        public Point moveWest()
        {
            return new Point (this.row, this.col-1);
        }

        public String toString()
        {
            return "(" + this.row + " , " + this.col +")";
        }
    } //end of inner point class


    //instance variables
    char [] [] theMaze;
    int height,width;
    Point start;
    ArrayList <ArrayList<Point>> solutions = new ArrayList <ArrayList<Point>>();
    int numRecurs=0;
    String printSolString = " ";

    public Maze (int _height, int _width, String [] entryPoints, ArrayList<String> mazeInfo) throws IOException
    {

        height = _height;
        width = _width;
        start = new Point(Integer.parseInt(entryPoints[0]),Integer.parseInt(entryPoints[1]));

        //parse remainder of first maze data to create 2D grid of characters
        theMaze = new char [height] [width];
        for (int r = 0; r < height; r++)
        {
            String [] rowString = (mazeInfo.get(r).split(" "));

            for (int c = 0; c < rowString.length; c++)
            {
                //int tempInt = Integer.parseInt(rowString[c]);
                theMaze[r][c] = rowString[c].charAt(0);
            }  //end of inner loop j
        }   //end of outer loop i

        solve(start, new ArrayList<Point>());
    }   //end of constructor

    public boolean contains(Point p)
    {
        return p.row >= 0 && p.row < this.height && p.col >=0 && p.col < this.width;
    }

    public int get(Point p)
    {
        return this.theMaze[p.row][p.col];
    }




    public void solve(Point currP, ArrayList<Point> path)
    {
        numRecurs++;
        path.add(currP);

        if (this.get(currP) == '2')
        {
            solutions.add(path);
            return;
        }

        Point north = currP.moveNorth();
        Point south = currP.moveSouth();
        Point east = currP.moveEast();
        Point west = currP.moveWest();

        //MUST ADD NO STEPS BASE CASE

        if (this.contains(north) && !(this.get(north) == '1') && !path.contains(north))
        {
            solve(north, (ArrayList<Point>) path.clone());
        }

        if (this.contains(south) && !(this.get(south) == '1') && !path.contains(south))
        {
            solve(south, (ArrayList<Point>) path.clone());
        }

        if (this.contains(east) && !(this.get(east) == '1') && !path.contains(east))
        {
            solve(east, (ArrayList<Point>) path.clone());
        }

        if (this.contains(west) && !(this.get(west) == '1') && !path.contains(west))
        {
            solve(west, (ArrayList<Point>) path.clone());
        }




    } //end of solve method

    public String printSolution(int index)
    {
        StringBuilder str = new StringBuilder();

        for (int r =0; r < this.height; r++)
        {
            for (int c = 0; c < this.width; c++)
            {
                if (solutions.get(index).contains(this.theMaze[r][c]))
                {
                    str.append('x');
                }
                else
                {
                    str.append(this.theMaze[r][c]+ " ");
                }

            }
            str.append("\n");
        }
        return str.toString();
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();

        for (int r =0; r < this.height; r++)
        {
            for (int c = 0; c < this.width; c++)
            {
                str.append(this.theMaze[r][c]+ " ");
            }
            str.append("\n");
        }
        return str.toString();
    } //end of toString

} //end of inner Maze class
