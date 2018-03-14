package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class InventoryManagement 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		Utility.readStockJsonFile();
	}
}
