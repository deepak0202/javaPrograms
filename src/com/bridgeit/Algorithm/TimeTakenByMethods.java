/******************************************************************************
*  Purpose: to calucate and display time taken by diffrent methods
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import java.util.ArrayList;
import com.bridgeit.utility.Utility;

public class TimeTakenByMethods 
{
	static String[] stringArray;
	static Integer[] integerArray;
	static int[] intarray;
	static long timeTaken;
	static int again;
	static long start;
	static long end;
	public static void main(String[] args) 
	{
		ArrayList<String> arrayList = new ArrayList<>();
		ArrayList<Long> arrayList2 = new ArrayList<>();
		Utility utility = new Utility();
		do
		{
			System.out.println("enter your choise");
			System.out.println("1 for binary Search for integer");
			System.out.println("2 for binary search for String");
			System.out.println("3 for insertionSort for integer");
			System.out.println("4 for insertionSort for String");
			System.out.println("5 for bubbleSort  for integer");
			System.out.println("6 for bubbleSort for String");
			System.out.println("7 for exit");
			int choise = utility.inputInteger();
			again = choise;
			switch (choise)
			{
			case 1:
				start = Utility.start();
				integerArray = Utility.inputIntegerArray();
				System.out.println("enter the element to be serched");
				Integer search = utility.inputInteger();    
				Utility.binarySearch(integerArray, search, 0, integerArray.length-1);
				end = Utility.end();
			    timeTaken = Utility.timeLaps(start, end);
			    arrayList.add("binarySearchInteger");
			    arrayList2.add(timeTaken);
				break;

			case 2:
				 start = Utility.start();
				 stringArray = Utility.inputStringArray();
				 System.out.println("enter the element to be serched");
				 String searched = utility.inputString();
				 Utility.binarySearch(stringArray, searched, 0, stringArray.length-1);
				 end = Utility.end();
				 timeTaken = Utility.timeLaps(start, end);
				 arrayList.add("binarySearchString");
				 arrayList2.add(timeTaken);
				 break;
			case 3:
				start = Utility.start();
				intarray = Utility.inputintegerArray();
				Utility.insertionSort(intarray);
				end = Utility.end();
				timeTaken = Utility.timeLaps(start, end);
				arrayList.add("insertionSortInteger");
				arrayList2.add(timeTaken);
				break;
			case 4 :
				start = Utility.start();
				stringArray = Utility.inputStringArray();
				Utility.insertionSort(stringArray);
				end = Utility.end();
				timeTaken = Utility.timeLaps(start, end);
				arrayList.add("insertionSortInteger");
				arrayList2.add(timeTaken);
				break;
			case 5 :
				start = Utility.start();
				intarray = Utility.inputintegerArray();
				Utility.bubbleSort(intarray);
				end = Utility.end();
				timeTaken = Utility.timeLaps(start, end);
				arrayList.add("bubbleSortInteger");
				arrayList2.add(timeTaken);
				break;
			case 6 :
				start = Utility.start();
				stringArray = Utility.inputStringArray();
				Utility.bubbleSort(stringArray);
				end = Utility.end();
				timeTaken = Utility.timeLaps(start, end);
				arrayList.add("bubbleSortString");
				arrayList2.add(timeTaken);
				break;
			default:
				break;
			}
		}
		while(again < 7);
			if(arrayList2.size()!= 0)
			{
				for(int i = 0; i < arrayList2.size()-1;i++)
				{
					for(int j = i+1; j < arrayList2.size();j++)
					{
						if(arrayList2.get(i)<arrayList2.get(j))
						{
							long temp = arrayList2.get(i);
							arrayList2.set(i, arrayList2.get(j));
							arrayList2.set(j, temp);
							
							String temp1 = arrayList.get(i);
							arrayList.set(i, arrayList.get(j));
							arrayList.set(j, temp1);	
						}
					}
					
				}
			}
			for(int i = 0;i < arrayList.size();i++)
			{
				System.out.println(arrayList.get(i)+"---" +arrayList2.get(i));
			}
	}

}
