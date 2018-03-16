/******************************************************************************
*  Purpose: to print prime , palindrome and anagram number b/w 1 to 1000
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/

package com.bridgeit.Algorithm;

import java.util.ArrayList;

import com.bridgeit.utility.Utility;


public class PrimeAnagramPalindrome 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i=0; i<=1000;i++)
		{
			if(Utility.prime(i) && Utility.Palindrome(i))
			{
				arrayList.add(i);
			}
		}
		for(int i = 0; i<arrayList.size()-1;i++)
		{
			for(int j = i+1;j<arrayList.size();j++)
			{
				int k = arrayList.get(i);
				int y = arrayList.get(j);
				if(Utility.anagram(k,y))
				{
					System.out.println(k +","+ y);
				}
			}
		}
		System.out.println("done");
	}
}
