package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Queue;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class TransectionInQueue 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		Queue<JSONObject> queue = Utility.shareTransectionInQueue();
		System.out.println(queue.toString());
	}
}
