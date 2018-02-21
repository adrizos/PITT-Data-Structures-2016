/**
 * Alex Drizos
 * CS 0445
 * Assignment 5
 */

//imports
import java.util.*;

public class HuffmanTree // class to create huffman trees
{
    private class Node
    {
        Node right;
        Node left;
        char data;
        public Node()
        {

        }//end of constructor
    }
    //variables
    ArrayList <String>  treeData;
    Node root;
    HashMap<Character, String> table = new HashMap<>();

    public HuffmanTree (ArrayList<String> fileArray)
    {
        treeData = fileArray;
        root = new Node();
        build(root, 0);

    }

    private int build(Node currNode, int index)
    {
        if (treeData.get(index).charAt(0) == 'L')
        {
            currNode.data = treeData.get(index).charAt(2); //account for space
            return index;
        }
        currNode.left = new Node();
        currNode.right = new Node();

        int leftMax = build(currNode.left, index+1); // GO LEFT
        int rightMax = build(currNode.right, leftMax+1); // GO RIGHT


        return rightMax;
    }  //end of build method

    public void buildEncodingTable(Node currNode, String path)
    {
        if (currNode.data != 0) // Check if character is empty, AKA this is a interior node.
        {
            table.put(currNode.data, path);
            return;
        }
        buildEncodingTable(currNode.left, path+"0"); //go left
        buildEncodingTable(currNode.right, path+"1"); //go right
    }

    public String decodeHString(Node currNode, String compressed)
    {
        int index = 0;
        String newStr = "";
        while (index < compressed.length())
        {
            if (compressed.charAt(index) == '0') //go left
            {
                currNode = currNode.left;
                index++;
            }

            //else go right
            //else if (compressed.valueOf(compressed.charAt(index)).equals("1"))
            else if (compressed.charAt(index) == '1')
            {
                currNode = currNode.right;
                index++;
            }

            if ((currNode.left == null) && (currNode.right == null)) //currNode is a leaf
            {
                newStr+= currNode.data;
                currNode = this.root; //reset so we can find next value
            }
        }
        return newStr;

    }
} //end of private inner HuffmanTree class

