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
public class MyStringBuilderAppendB
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
		public MyStringBuilder append(MyStringBuilder b)
		{
			if(length==0)
			{
				firstC = new CNode(b.firstC.data);
				length = 1;
				CNode currNode = b.firstC;
				for (int i = 1; i < b.length; i++)
				{
					CNode newNode = new CNode(currNode.next.data);
					currNode.next = newNode;
					currNode = newNode;
					length++;
				}
				lastC = currNode;

			}
			else{//works
				CNode currNode = lastC;

				CNode newNode = b.firstC;
				for (int i = 1; i < b.length+1; i++)
				{
					currNode.next = newNode;

					currNode = newNode;

					newNode = currNode.next;

					length++;
				}
				lastC = currNode;
			}
			return b;
		}
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
				length = 1;
				CNode currNode = firstC;

				// Create remaining nodes, copying from char array.
				for (int i = 1; i < c.length; i++)
				{
					CNode newNode = new CNode(c[i]);
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
				// Create  nodes, copying from char array.
				for (int i = 0; i < c.length; i++) {
					CNode newNode = new CNode(c[i]);
					currNode.next = newNode;
					currNode = newNode;
					length++;
					lastC = currNode;
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


	/**
	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
	}

	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
	}

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}


	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.
	public MyStringBuilder replace(int start, int end, String str)
	{
	}

	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder
	public String substring(int start, int end)
	{
	}

	 **/ // commented out for testing

	// Return the entire contents of the current MyStringBuilder as a String
	public String toString() //!!must change to eliminate +!!
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

