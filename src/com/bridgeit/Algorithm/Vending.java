package com.bridgeit.Algorithm;

import java.util.HashSet;
import com.bridgeit.Utility;

/******************************************************************************
*  Purpose: print the notes return by vending machine and and min number of notes to be return
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class Vending 
{
	static HashSet h = new HashSet();
	static int count;
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter a number");
		 int change= utility.inputInteger();
		 Utility.vending(change,count,h);
	}
}
