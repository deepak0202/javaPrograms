package com.bridgeit.Algorithm;

import java.util.Arrays;
import com.bridgeit.Utility;

/******************************************************************************
*  Purpose: to sort the array useing insertion sort algo
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class InsertionSort 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the length of the array");
		int length = utility.inputInteger();
		String[] array = new String[length];
		for(int i = 0; i<length;i++)
		{
			System.out.println("enter the " + i + "th element in the array");
			array[i]= utility.inputString();
		}
		String[] sortedArrary = Utility.insertionSort(array);
		System.out.println(Arrays.toString(sortedArrary));
	}
}