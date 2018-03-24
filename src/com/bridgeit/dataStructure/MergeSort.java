/******************************************************************************
*  Purpose: sorting of int array with the help of merge sort
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
package com.bridgeit.dataStructure;

import com.bridgeit.utility.Utility;

public class MergeSort 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the size of array");
		int length = utility.inputInteger();
		int[] array = new int[length];
		for(int i =0; i < length; i++)
		{
			System.out.println("enter " + i +"th element in array");
			array[i] =utility.inputInteger();
		}
		Utility.mergesort(array, 0, length);
		for(int i = 0; i < array.length;i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}