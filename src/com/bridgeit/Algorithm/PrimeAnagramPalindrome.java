package com.bridgeit.Algorithm;

import java.util.ArrayList;

import com.bridgeit.Utility;

/******************************************************************************
*  Purpose: to print prime , palindrome and anagram number b/w 1 to 1000
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
public class PrimeAnagramPalindrome 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> al = new ArrayList();
		for(int i=0; i<=1000;i++)
		{
			if(Utility.prime(i) && Utility.Palindrome(i))
			{
				al.add(i);
			}
		}
		for(int i = 0; i<al.size()-1;i++)
		{
			for(int j = i+1;j<al.size();j++)
			{
				int k = al.get(i);
				int y = al.get(j);
				if(Utility.anagram(k,y))
				{
					System.out.println(k +","+ y);
				}
			}
		}
		System.out.println("done");
	}
}
