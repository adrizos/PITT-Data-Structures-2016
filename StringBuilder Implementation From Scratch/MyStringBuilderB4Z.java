//imports
import java.util.*;

// CS 0445 Spring 2016
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a singly linked list of nodes.  See more comments below on the specific
// requirements for the class.

// For more details on the general functionality of most of these methods, 
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilderB4Z
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder initialized with the chars in String s
	public MyStringBuilder(String s) //this one should is correct since it was given!
	{
		if (s == null || s.length() == 0) // Special case for empty String
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			// Create front node to get started
			firstC = new CNode(s.charAt(0));
			length = 1;
			CNode currNode = firstC;
			// Create remaining nodes, copying from String.  Note
			// how each new node is simply added to the end of the
			// previous one.  Trace this to see what is going on.
			for (int i = 1; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
	{
		if (s == null || s.length == 0) // Special case for empty char array
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			// Create front node to get started
			firstC = new CNode(s[0]);
			length = 1;
			CNode currNode = firstC;
			// Create remaining nodes, copying from char array.
			for (int i = 1; i < s.length; i++)
			{
				CNode newNode = new CNode(s[i]);
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
	}


	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		firstC=null;
		lastC=null;
		length=0;
	}


	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
		if (length == 0) {
			firstC = new CNode(b.firstC.data);
			length = 1;
			CNode currNode = b.firstC;
			for (int i = 1; i < b.length; i++) {
				CNode newNode = new CNode(currNode.next.data);
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;

		} else {// works
			CNode currNode = lastC;

			CNode bNode = b.firstC;
			for (int i = 1; i < b.length + 1; i++) {

				CNode newNode = new CNode(bNode.data);
				currNode.next = newNode;

				currNode = newNode;

				newNode = currNode.next;
				bNode = bNode.next;
				length++;
			}
			lastC = currNode;
		}
		return this;
	}

	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		if (s == null ) // Special case for null ref
		{
			throw new NullPointerException("attempting to add empty string");
		}
		else // non null ref
		{
			//convert string argument to temp char array to be passed into nodes
			char [] tempCArray = s.toCharArray();
			if (isEmpty()) // if stringbuilder is empty
			{
				// Create front node to get started
				firstC = new CNode(tempCArray[0]);
				length = 1;
				CNode currNode = firstC;

				// Create remaining nodes, copying from temp char array.
				for (int i = 1; i < tempCArray.length; i++)
				{
					CNode newNode = new CNode(tempCArray[i]);
					currNode.next = newNode;
					currNode = newNode;
					length++;
					lastC = currNode;
				}
			}
			//is stringbuilder is not empty
			else {
				CNode currNode = lastC;
				//if string builder is not empty
				// Create  nodes, copying from temp char array.
				for (int i = 0; i < tempCArray.length; i++) {
					CNode newNode = new CNode(tempCArray[i]);
					currNode.next = newNode;
					currNode = newNode;
					length++;
					lastC = currNode;
				}
			}

		}
		return this;

	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
		if (c == null || c.length == 0) // Special case for empty char array
		{					 			  // or null reference
			throw new NullPointerException("attempting to add empty character array");
		}
		else
		{

			if (isEmpty()) // if stringbuilder is empty
			{
				// Create front node to get started
				firstC = new CNode(c[0]);
				CNode currNode = firstC;
                length++;

				// Create remaining nodes, copying from char array.
				for (int i = 1; i < c.length; i++)
				{
					CNode newNode = new CNode(c[i]);
					currNode.next = newNode;
					currNode = newNode;
					lastC = currNode;
                    length++;
				}
			}
			//is stringbuilder is not empty
			else {
				CNode currNode = lastC;
				//if string builder is not empty
				// Create  nodes, copying from char array.
				for (int i = 0; i < c.length; i++) {
					CNode newNode = new CNode(c[i]);
					currNode.next = newNode;
					currNode = newNode;
					lastC = currNode;
                    length++;
				}

			}

		}
		return this;
	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		CNode newNode = new CNode(c);
		if (isEmpty())
		{
			firstC = newNode;
			lastC = newNode;
		}	//if stringbuilder object is empty
		else
		{
			CNode currNode = lastC;
			currNode.next=newNode;
			currNode = newNode;
			lastC = currNode;
		}	// if stringbuilder object is not empty
		length++;
		return this;
	}



	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		boolean found = false;
		CNode nodeAtIndex = firstC;
		CNode currNode = firstC;
		for (int i = 0; i <length; i++)
		{
			if (i == index)
			{
				found = true;
				nodeAtIndex = currNode;
				break;
			}
			currNode = currNode.next;
		}	//end of looping through characters in obejct
		if (!found)
			throw new IndexOutOfBoundsException();
		return nodeAtIndex.data;
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}


	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{

		//if the end value is greater remove up until the end
		if (start >=0 && end > length)
			end = length-1;
		//if the start or end values are invalid
		if (start < 0 || start >= length-1 || end <= start)
			return this;
		//if start and end would delete entire chain?
		int numToDelete = end-start; //for length--
		//the values are ok and proceed to deletion asper instructed
		if (start !=0 && end != length-1)
		{
			CNode startNode=null;
			CNode endNode=null;
			CNode currNode = firstC;
			//traverse the list
			for (int i = 0; i <length; i++)
			{
				if (i == start-1)
					startNode = currNode;
				if (i == end)
				{
					endNode = currNode;
					startNode.next = endNode;
				}
				currNode = currNode.next; //increment currNode
			}	//end of traversing list
		}//end of normal deletion case

		//start is at position 0 and end is not at the last node
		else if (start == 0 && end != length-1)
		{
			CNode endNode;
			CNode currNode = firstC;
			//traverse the list
			for (int i = 0; i <length; i++)
			{
				if (i == end)
				{
					endNode = currNode;
					firstC = endNode;
					break;
				}
				currNode = currNode.next; //increment currNode
			}	//end of traversing list
		}

		//start position is at 0 and end is also the last node
		else if (start == 0 && end == length-1)
		{
			CNode endNode;
			CNode currNode = firstC;
			//traverse the list
			for (int i = 0; i <length; i++)
			{
				if (i == end)
				{
					endNode = currNode;
					firstC = endNode;
					break;
				}
				currNode = currNode.next; //increment currNode
			}	//end of traversing list
		}
		//start position is not zero but end is last position
		else if (start != 0 && end == length-1)
		{
			CNode endNode;
			CNode startNode=null;
			CNode currNode = firstC;
			//traverse the list
			for (int i = 0; i <length; i++)
			{
				if (i == start-1)
				{
					startNode = currNode;
					startNode.next = null;
					lastC = startNode;
					break;
				}
				currNode = currNode.next; //increment currNode
			}	//end of traversing list
		}
		length-=end-start;
		return this;
	}//end of delete


	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		//check for invalid index
		if (index < 0 || index > length-1)
			return this;
		else if (index != 0 && index != length-1)
		{
			CNode currNode = firstC;
			//traverse the list
			for (int i = 0; i <length; i++)
			{
				if (i == index-1)
				{
					currNode.next=currNode.next.next;
					break;
				}
				currNode = currNode.next; //increment currNode
			}	//end of traversing list
		}

		else if (index == 0)
		{
			firstC = firstC.next;
		}

		//user wished to delete last char
		else if (index == length-1)
		{
			CNode currNode = firstC;
			//traverse the list
			for (int i = 0; i <length; i++)
			{
				if (i == index-1)
				{
					currNode.next = null;
					lastC = currNode;
					break;
				}
				currNode = currNode.next; //increment currNode
			}	//end of traversing list
		}
		length--;
		return this;
	} //end of deletCharAt


	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		int index =-1; //index at which str is first found in linked list string of chars
		int sI = 0; //str index
		int matchCount=0; // counter for char matches
		int tempSBI=0;
		CNode currNode = firstC;

        for (int sBI = 0; sBI < length; sBI++) //sBI stringBuilder index
		{

            if (str.charAt(sI) == currNode.data) //if char found
			{
				if (matchCount == 0)
                {
                    index = sBI;
                    //System.out.println("first char found!!");
                }

				matchCount++;

			}
			else if (str.charAt(sI) != currNode.data)
			{
				index = -1;sI=0;matchCount=0;
				//continue;
				if (matchCount == str.length())
					break;
			}

			if (str.length()-1 == matchCount) // str found
            {

                //return index;
				break;
            }

			/**if (currNode.data ==' ') // reset on blank spaces between words
			{
				sI=0;index=-1;matchCount=0;
                System.out.println("WHITE SPACE FOUND");
				continue;
			}
            **/
			if (sI == str.length()-1 && matchCount<str.length()) //not found, reset for next word
			{
				sI=0;index=-1;matchCount=0;
				System.out.println("Not found on a string in SB");
				//continue;
			}
			sI++;
			currNode=currNode.next; //increment nodes
		}
		return index;
	}


	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{

        CNode currNode = firstC;

        if (offset == length)
        {
            append(str);
            length+=str.length();
            return this;
        }
        else if (offset > 0 && offset < length)
        {
            for (int i = 0; i <length; i++)
            {
                if (i == offset-1) //add in str in the middle
                {
                    CNode continueNode = currNode.next;
                    for (int p = 0; p <str.length(); p++)
                    {
                        currNode.next = new CNode(str.charAt(p));
                        currNode = currNode.next;
                    }
                    currNode.next = continueNode;
                    break;
                }
                currNode = currNode.next; //increment nodes
            }
            length+=str.length();
            return this;
        }
        else if (offset == 0)
        {
            CNode continueNode = firstC;
            firstC = new CNode(str.charAt(0));
                currNode = firstC;
                for (int p = 1; p <str.length(); p++)
                {
                    currNode.next = new CNode(str.charAt(p));
                    currNode = currNode.next;
                }
                currNode.next = continueNode;
            length+=str.length();
            return this;
        }
        else
            return this;
    } //end of insert str


	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
         CNode currNode = firstC;

         if (offset == length)
         {
            append(c);
            length++;
            return this;
         }
         else if (offset > 0 && offset < length)
         {
            for (int i = 0; i <length; i++)
            {
                if (i == offset-1) //add in char in the middle
                {
                    CNode continueNode = currNode.next;
                    currNode.next = new CNode(c);
                    currNode = currNode.next;
                    currNode.next = continueNode;
                    break;
                }
            currNode = currNode.next; //increment nodes
            }
            length++;
            return this;
         }
         else if (offset == 0)
         {
             CNode continueNode = firstC;
             firstC = new CNode(c);
             firstC.next = continueNode;
             length++;
             return this;
         }
         else
            return this;
    } //end of insert char c


	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{

        CNode currNode = firstC;

        if (offset == length)
        {
            append(c);
            length+=c.length;
            return this;
        }
        else if (offset > 0 && offset < length)
        {
            for (int i = 0; i <length; i++)
            {
                if (i == offset-1) //add in str in the middle
                {
                    CNode continueNode = currNode.next;
                    for (int p = 0; p <c.length; p++)
                    {
                        currNode.next = new CNode(c[p]);
                        currNode = currNode.next;
                    }
                    currNode.next = continueNode;
                    break;
                }
                currNode = currNode.next; //increment nodes
            }
            length+=c.length;
            return this;
        }
        else if (offset == 0)
        {
            CNode continueNode = firstC;
            firstC = new CNode(c[0]);
            currNode = firstC;
            for (int p = 1; p <c.length; p++)
            {
                currNode.next = new CNode(c[p]);
                currNode = currNode.next;
            }
            currNode.next = continueNode;
            length+=c.length;
            return this;
        }
        else
            return this;


    } //end of insert char [] c


    // Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.
	public MyStringBuilder replace(int start, int end, String str)
	{
	    if (start <0 || start > end)
            return this;
        if (end > length)
            end = length-1;

        this.delete(start,end).insert(start,str);


        return this;
    } //end of replace


	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder
	public String substring(int start, int end)
	{
	    String str = "";
        char [] tempChar = new char[(end)-start];
        CNode currNode = firstC;
        if (end >length)
            end =length-1;
        if (start > end || start < 0 || start > length)
            return str;
        else
        {
            for (int i = 0; i <length; i++)
            {
                if (i == start)
                {
                    for (int p = 0; p <tempChar.length; p++)
                    {
                        tempChar[p] = currNode.data;
                        currNode =currNode.next;
                    }
                    break;
                }

                currNode = currNode.next;
            }

        }
        str = new String(tempChar);
        return str;
    }



	// Return the entire contents of the current MyStringBuilder as a String
	public String toString()
	{
		CNode currNode= firstC;
		char [] temp = new char [length];
		int counter=0;
		if (length == 0)
			return "";
		while (currNode.next !=null)
		{
			temp[counter]=currNode.data;
			currNode = currNode.next;
			counter++;
		}
		temp[counter]=currNode.data;
		String result = new String(temp);
		return result;
	}


	/** additional private methods **/
	private boolean isEmpty()
	{
		if (length<1)
			return true;
		return false;

	}	//end of isEmpty

	private CNode getNodeAt(int position)
	{
		assert !isEmpty() && (1 <= position) && (position < length);
		CNode currNode = firstC;
		for (int i = 0; i <position; i++)
		{
			currNode = currNode.next;
		}
		assert currNode !=null;
		return currNode;
	}	//end of getNodeAt

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	} // end of CNode inner class
} //end of MyStringBuilder class

