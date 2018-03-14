package com.bridgeit.objectOrientedPrograms;

import java.util.ArrayList;

import com.bridgeit.utility.Utility;

public class DeckOfCardsInQueue 
{
	public static void main(String[] args) 
	{
		ArrayList<String[]> arrayList = Utility.cardsInSequence();
		String[] array = arrayList.get(0);
		System.out.println("cards of player 1");
		for(int i = 0; i < 13; i++)
		{
			System.out.println(array[i]);
		}
		System.out.println();
		System.out.println("cards of player 2");
		array = arrayList.get(1);
		for(int i = 0; i < 13; i++)
		{
			 System.out.println(array[i]);
		}
		System.out.println();
		System.out.println("cards of player 3");
		array = arrayList.get(2);
		for(int i = 0; i < 13; i++)
		{
			System.out.println(array[i]);
		}
		System.out.println();
		System.out.println("card of player 4");
		array = arrayList.get(3);
		for(int i = 0; i < 13; i++)
		{
			System.out.println(array[i]);
		}
	}
}
