package com.bridgeit.Algorithm;

import java.util.Arrays;
import com.bridgeit.Utility;

/******************************************************************************
*  Purpose: to sort the array useing bubble sort algo
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class BubbleSort 
{
	public static void main(String[] args) 
	{
		Utility utility = new Utility();
		System.out.println("enter the length of the array");
		int length = utility.inputInteger();
		int[] array = new int[length];
		for(int i = 0; i < length; i++)
		{
			System.out.println("enter the" + i + "th element in the array");
			array[i] = utility.inputInteger();
		}
		int[] sortedArray = Utility.bubbleSort(array);
		System.out.println(Arrays.toString(sortedArray));
	}
}
