/**
 * Alex Drizos
 * CS 0445
 * Assignment 1
 */

//imports
import java.util.*;
import java.io.IOException;

public class RandIndexQueue<T> implements Indexable<T>, MyQ<T>, Shufflable {

    /*overall variables needed*/
    private final T [] theArray; //variable declaration for the array data
    private static final int DEFAULT_SIZE = 100000;
    private int numEntries;
    private boolean initialized = false;

    /* user size specified constructor*/
    public RandIndexQueue(int size)
    {
        if (size <= DEFAULT_SIZE) {
            //the cast here is safe as the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) new Object[size];
            theArray = temp;
            numEntries = 0;
            initialized = true;
        }
        else
            throw new IllegalStateException("Attempted to create array whose capacity exceeds allowed maximum.");
    }


    /* default sized constructor*/
    public RandIndexQueue()
    {
        this(DEFAULT_SIZE);
    }

    /** code supporting Indexable implementation **/
    /*methods*/
    public T get(int i)
    {
        checkInitialization();
        T tempReturn = null;
        //gets the value at logical location i
        //returns the value
        try {
            tempReturn = theArray[i];
        }

        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Selected index is out of bounds.");
        }

        return tempReturn;
    }   // end of get method

    public void set(int i, T item)
    {
        checkInitialization();
        try {
           theArray[i] = item;
        }

        catch (IndexOutOfBoundsException e1)
        {
            System.out.println("Selected index is out of bounds.");
        }
    } //end of set method

    /** code supporting MyQ implementation **/
    /*methods*/
    public boolean addItem(T item)
    {
        assert(item!=null);

        checkInitialization();
        boolean result = true;
        if (full())
            result = false;
        else
        {
            // Assertion: result is true here
            theArray[numEntries] = item;
            numEntries++;
        }
        return result;
    } // end of addItem

    public T removeItem()
    {
        checkInitialization();
        T result = null;

        if (!empty())
        {
            result = theArray[0];

            for (int z = 0; z<numEntries - 1; z++)
            {
                theArray[z] = theArray[z+1];
            }
            theArray[numEntries-1] = null;
            numEntries--;
        }
        return result;
    }
    // end of removeItem

    public boolean full()
    {
        checkInitialization();
        if (numEntries >= theArray.length)
            return true;
        else
            return false;
    } // end of full

    public boolean empty()
    {
        if (numEntries == 0)
            return true;
        else
            return false;
    } //end of empty

    public int size()
    {
        return numEntries;
    } //end of size

    public void clear()
    {
        while (!empty())
        {
            removeItem();
        }
    } // end of clear

    /** code supporting Shufflable implementation **/
    /*methods*/
    public void shuffle()
    {
        checkInitialization();
        for (int i = 0; i < numEntries; i++) {
            // Get a random index of the array past i.
            int random = i + (int) (Math.random() * (numEntries - i));
            //int random = (int) (Math.random() * (numEntries - i));
            //assert(random < numEntries);

            // Swap the random element with the present element.
            T randomElement = theArray[random];
            theArray[random] = theArray[i];
            theArray[i] = randomElement;
        }
    }   //end of shuffle method

    public String toString()
    {
        checkInitialization();
        String tempString= ("Contents:");
        for (int i =0; i <numEntries; i++)
        {
            tempString+=(" ") +theArray[i] + (" ");
        }
        return tempString;
    }

    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException("Array object is not initialized properly.");
    }    //end check initialization
} //end of RandIndexQueue class
