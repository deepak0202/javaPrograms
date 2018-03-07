/******************************************************************************
*  Purpose: print prime number which are anagram b/w 0 to 1000
*  @author  Deepak Singh
*  @version 1.0
*  @since   07-03-2018
*
******************************************************************************/

package com.bridgeit.dataStructure;

import java.util.ArrayList;
import java.util.TreeSet;

import com.bridgeit.utility.Utility;

public class AnagramIn2d 
{
	public static void main(String[] args) 
	{
	ArrayList<Integer> arrayList = Utility.primeNumberInRange(0,1000);
	TreeSet<Integer> treeSet = Utility.anagramInArraylist(arrayList);
	Utility.treesetTo2DArray(treeSet);
	}
}
