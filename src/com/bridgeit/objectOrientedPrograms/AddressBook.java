/******************************************************************************
*  Purpose: to add person detail in json file ,to edit person detail present in json file,
*  to delete person detail in json file, to sort person detail by his nameand to sort person
*  detail by zip number
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/

package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import com.bridgeit.utility.Utility;

public class AddressBook 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		int start;
		do
		{
			Utility utility = new Utility();
			System.out.println("enter your choise");
			System.out.println("1 to add person detail in address book");
			System.out.println("2 to edit person detail");
			System.out.println("3 to delete person record");
			System.out.println("4 to sort address book by name");
			System.out.println("5 to sort by zip");
			System.out.println("6 to view all the content of address book");
			System.out.println("7 to exist");
			int choise = utility.inputInteger();
			start = choise;
			switch (choise) 
			{
			case 1:
				Utility.add();
				break;
			case 2:
				Utility.edit();
				break;
			case 3 :
				Utility.delete();
				break;
			case 4 :
				Utility.sortByName();
				break;
			case 5 :
				Utility.sortByZip();
				break;
			case 6:
				Utility.displayAddressBook();
				break;
			default:
				break;
			}
		}
		while(start < 7);	
	}
}
