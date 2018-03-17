/******************************************************************************
*  Purpose: to add share company object in linked list and to add new company and to
*  remove exsting one
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

public class ShareInList 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		int start;
		Utility utility = new Utility();
		System.out.println("enter your choise");
		do
		{
			System.out.println("enter 1 to add all share company in linkedlist and display them");
			System.out.println("enter 2 to add new share share company");
			System.out.println("enter 3 to delete existing share company");
			System.out.println("enter 4 to exist");
			int choise = utility.inputInteger();
			start = choise;
			switch (choise) {
			case 1:
				java.util.LinkedList<JSONObject> linkedList = Utility.addCompanytoList();
				for(int i = 0; i < linkedList.size();i++)
				{
					System.out.println(linkedList.get(i));
				}
				break;
            case 2:
            	Utility.addShareCompany();
				break;
            case 3:
            	Utility.deleteShareCompany();
	            break;
			default:
				break;
			}
		}
		while(start < 4);
		
	}

}
