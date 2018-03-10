package com.bridgeit.objectOrientedPrograms;



import java.io.IOException;
import java.text.ParseException;
import com.bridgeit.utility.Utility;

public class Stock 
{
	
	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException 
	{
		Utility.writeStockJsonFile();
		Utility.readStockJsonFile();
	}
}