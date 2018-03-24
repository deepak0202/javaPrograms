/******************************************************************************
*  Purpose: read string words from file and then input a word and do brinary search to check wheather it is present 
*  or not
*  @author  Deepak Singh
*  @version 1.0
*  @since   05-03-2018
*
******************************************************************************/
package com.bridgeit.Algorithm;

import java.io.IOException;
import java.util.ArrayList;

import com.bridgeit.utility.Utility;

public class BrinarySerachFromFile 
{
	public static void main(String[] args) throws IOException 
	{
				Utility.readFileAndBinarySearch("stringData.text");
	}
}