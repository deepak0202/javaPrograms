
/******************************************************************************
*  Purpose: to distribute deck of cards among four players and in arranged form
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/

package com.bridgeit.objectOrientedPrograms;

import java.util.ArrayList;

import com.bridgeit.utility.Utility;

public class DeckOfCardsInQueue 
{
	public static void main(String[] args) 
	{
		ArrayList<String[]> arrayList = Utility.cardsInSequence();
		Utility.printCardsOfPlayers(arrayList);
	}
}
