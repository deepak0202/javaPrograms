/******************************************************************************
*  Purpose: add share company details to the linkedList and print them
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/
package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class TransactionsInList 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		java.util.LinkedList<JSONObject> linkedList = Utility.shareTransectionInList();
		for(int i = 0; i < linkedList.size(); i++)
		{
			System.out.println(linkedList.get(i));
		}
		
	}

}
