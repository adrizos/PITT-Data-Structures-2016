/**Alex Drizos
 * cs0445
 * Assig2B
 * Spring 2016
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class Assig2B {

    public static void main(String args[]) throws IOException
    {
        FileReader in = new FileReader(args[0]);
        int count = 0;
        double totalTime=0;
        double averageTimeAll=0;
        double sBTime=0;
        double mSBTime=0;
        double sTime=0;
        double time1=0;
        double time2=0;

        System.out.println("");//spacing

        for(int i = 0; i<3; i++)
        {

            if(i == 0) //perform the three operations using StringBuilder class
            {

                StringBuilder sB = new StringBuilder();
                BufferedReader br = new BufferedReader(in);
                count = 0;

                /**read in each character from the file and append to sB**/
                time1 = System.nanoTime(); //time clock started for append
                while(br.read()!=-1)
                {
                    sB.append((char)br.read());
                    count++; //keep track of num appended
                }
                time2 = System.nanoTime(); //time clock stopped for append
                sBTime+=(time2-time1); //sum total string builder time thus far
                System.out.println("StringBuilder\nAppend Time: " + (time2-time1) + "\nAverage Append Time: " + getAvg(time1,time2,count)+"\n");

                /**delete each character until no more exist**/
                time1 = System.nanoTime(); //time clock started for delete
                while(sB.length()>0)
                {
                    sB.delete(0, 1);
                }
                time2 = System.nanoTime(); //time clock stopped for delete
                sBTime+=(time2-time1); //sum total string builder time thus far
                System.out.println("StringBuilder\nDelete Time: " + (time2-time1) + "\nAverage Delete Time: " + getAvg(time1,time2,count)+"\n");

                /**insert each character from the list again into the middle**/
                time1 = System.nanoTime(); //time clock started for insert
                int len = 0; //separate counter to keep track of middle position
                while(br.read()!=-1)
                {
                    sB.insert(len/2,(char) br.read());
                    len++;
                }
                time2 = System.nanoTime(); //time clock stopped
                sBTime+=(time2-time1); //sum total string builder time thus far
                System.out.println("StringBuilder\nInsert Time: " + (time2-time1) + "\nAverage Insert Time: " + getAvg(time1,time2,count) +"\n");
                totalTime+=sBTime; //sum overall time thus far for all objects
                System.out.println("\tStringBuilder\n\tTotal Time: " + (sBTime) + "\n\tAverage Time: "+ sBTime/count + "\n\n");

            }

            if(i == 1) // perform the three operations using my version, MyStringBuilder
            {
                MyStringBuilder mSB = new MyStringBuilder();
                BufferedReader br = new BufferedReader(in);

                /**read in each character from the file and append to mSB**/
                time1 = System.nanoTime(); //time clock started for append
                while(br.read()!=-1)
                {
                    mSB.append((char)br.read());
                }
                time2 = System.nanoTime(); //time clock stopped for append
                mSBTime+=time2-time1; //sum total time MyStringBuilder thus far
                System.out.println("MyStringBuilder\nAppend Time: " + (time2-time1) + "\nAverage Append Time: " + getAvg(time1,time2,count) +"\n");

                /**delete each character until no more exist**/
                time1 = System.nanoTime(); //time clock started for delete
                while(mSB.length()>0)
                {
                    mSB.delete(0, 1);
                }
                time2 = System.nanoTime(); //time clock stopped for delete
                mSBTime+=time2-time1; //sum total time MyStringBuilder thus far
                System.out.println("MyStringBuilder\nDelete Time: " + (time2-time1) + "\nAverage Delete Time: " + getAvg(time1,time2,count)+"\n");

                /**insert each character from the list again into the middle**/
                int len = 0;
                BufferedReader br1 = new BufferedReader(in);
                time1 = System.nanoTime(); //time clock started for insert
                while(br.read()!=-1)
                {
                    mSB.insert(len/2, (char)br1.read());
                    len++;
                }
                time2 = System.nanoTime(); //time clock stopped for insert
                mSBTime+=time2-time1;//sum total time MyStringBuilder thus far
                totalTime+=mSBTime;//sum overall time thus far for all objects
                System.out.println("MyStringBuilder\nInsert Time: " + (time2-time1) + "\nAverage Time: " + getAvg(time1,time2,count)+"\n");
                System.out.println("\tMyStringBuilder\n\tTotal Time: " + (mSBTime) + "\n\tAverage Time: "+ mSBTime/count + "\n\n");

            }


            if(i == 2) // perform the three operations with the String class
            {
                String str = new String();
                BufferedReader br = new BufferedReader(in);

                /**read in each character from the file and add to new string**/
                time1 = System.nanoTime(); //time clock started for add
                while(br.read()!=-1)
                {
                    str+=(br.read());
                }
                time2 = System.nanoTime(); //time clock stopped
                sTime+=time2-time1;
                System.out.println("String\nAppend Time: " + (time2-time1) + "\nAverage Append Time: " + getAvg(time1,time2,count)+"\n");

                /**delete each character until no more exist**/
                time1 = System.nanoTime(); //time clock started for delete
                String temp="";
                while(str.length()>0)
                {
                    for(int z = 1; z<str.length(); z++)
                    {
                        temp+=Character.toString(str.charAt(z));

                    }
                }
                time2 = System.nanoTime(); //time clock stopped for delete
                sTime+=time2-time1;
                System.out.println("String\nDelete Time: " + (time2-time1) + "\nAverage Delete Time: " + getAvg(time1,time2,count)+"\n");

                /**insert each character from the list again into the middle**/
                time1 = System.nanoTime(); //time clock started for insert
                int leng = 0;
                BufferedReader br1 = new BufferedReader(in);
                while(br.read()!=-1)
                {

                    leng++;
                }
                time2 = System.nanoTime(); //time clock stopped for insert
                sTime+=time2-time1;
                totalTime+=sTime;
                System.out.println("String\nInsert Time: " + (time2-time1) + "\nAverage Time: " + getAvg(time1, time2, count)+"\n");
                System.out.println("\tString\n\tTotal Time: " + (sTime) + "\n\tAverage Time: "+ sTime/count + "\n\n");
            }

        }
        in.close(); //close file

        System.out.println("Total Program Testing\nTotal Time: " + (totalTime) + "\nAverage Time: " +  totalTime/(count*9)+ "\n\n");
        System.out.println("");//spacing
    }

    public static double getAvg(double first, double second, int divisor)
    {
        double avg = (second-first)/divisor;
        return avg;
    }
}