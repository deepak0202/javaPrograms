/******************************************************************************
*  Purpose: to read number from file and store them in slot and selecting slot by divideing them
*           by 11 and remider will reprent there slot then take user input and check whether present
*           if present deleteit else add it then push the data to file
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/


package com.bridgeit.dataStructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.bridgeit.utility.Utility;

import java.util.List;
public class SearchNumberInSlot 
{
	public static void main(String[] args) throws IOException 
	{
		PrintWriter printWriter = new PrintWriter("numberSlot.text");
		Linkedlist linkedlist = new Linkedlist();
		HashMap<Integer, Linkedlist> hashMap = new HashMap<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("Integerdata.text"));
		String line = bufferedReader.readLine();
		while(line != null)
		{
			String[] array = line.split(" ");
			for(String words : array)
			{
				linkedlist.add(Integer.parseInt(words));
			}
			line = bufferedReader.readLine();
		}
		for(int i = 0;i<linkedlist.size();i++)
		{
			int number = linkedlist.dataAtPosition(i);
			int slot = number % 11;
			if(hashMap.containsKey(slot))
			{
				hashMap.get(slot).add(number);
			}
			else
			{
				hashMap.put(slot, new Linkedlist());
				hashMap.get(slot).add(number);
			}
		}
		System.out.println("enter the digit to be searched");
		Utility utility = new Utility();
		int search = utility.inputInteger();
		int slot = search % 11;
		if(hashMap.containsKey(slot))
		{
			if(hashMap.get(slot).search(search))
			{
				hashMap.get(slot).delete(search);
			}
			else
			{
				hashMap.get(slot).add(search);
			}
		}
		else
		{
			hashMap.put(slot, new Linkedlist());
			hashMap.get(slot).add(search);
		}
			for(int i = 0; i<11;i++) 
			{
				if(hashMap.containsKey(i))
					{
					printWriter.println("\n["+i+"] ");

					Linkedlist lk = hashMap.get(i);
					
						for(int j = 0; j < lk.size();j++)
						{
							printWriter.print(lk.dataAtPosition(j)+" ");
						}
						printWriter.println("\n");

					}
			}
		printWriter.flush();
	}
}
