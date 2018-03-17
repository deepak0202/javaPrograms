/******************************************************************************
*  Purpose: to display how diffrent way binary serch tree can be arranged for given number of nodes
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class Tree 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter how many test do you want : ");
		int test=utility.inputInteger();
		
		for(int i=0; i<test; i++)
		{
			System.out.println("Enter the nodes : ");
			int nodes=utility.inputInteger();
			System.out.println("For "+nodes+", "+Utility.binarySearchTree(nodes));
		}	
	}
}
