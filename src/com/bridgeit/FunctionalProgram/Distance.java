/******************************************************************************
*  Purpose: take coordinate as input from command line arguments
*           and find distance b/w origin and the given coordinates
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.FunctionalProgram;

import com.bridgeit.utility.Utility;

public class Distance 
{
	public static void main(String[] args) 
	{
		System.out.println("enter x value " + args[0]);
		int x = Integer.parseInt(args[0]);
		System.out.println("enter y value " + args[1]);
		int y = Integer.parseInt(args[1]);
		System.out.println(Utility.euclideanDistance(x, y));
	}

}
