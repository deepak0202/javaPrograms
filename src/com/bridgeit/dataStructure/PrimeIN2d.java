/******************************************************************************
*  Purpose: to print number in 2d array 
*  the first dimension represents the range 0-100, 100-200, and so on.
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import java.util.ArrayList;

import com.bridgeit.utility.Utility;

public class PrimeIN2d 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> arrayList = Utility.primeNumberInRange(0, 1000);
		Utility.arraylistTo2DArray(arrayList);
	}
}
