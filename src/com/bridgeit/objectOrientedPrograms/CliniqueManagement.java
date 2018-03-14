package com.bridgeit.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class CliniqueManagement 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		Utility utility = new Utility();
		int start;
		do
		{
			System.out.println("enter your choise");
			System.out.println("enter 1 to add doctor to Clinique");
			System.out.println("enter 2 to add patient");
			System.out.println("enter 3 to serach and book a doctor");
			System.out.println("enter 7 to exist");
			int choise = utility.inputInteger();
			start = choise;
			switch (choise) 
			{
			case 1:
				Utility.addDoctor();
				break;
			case 2:
				Utility.addPatients();
				break;
			case 3:
				JSONObject patient=null;
				System.out.println("enter the patient id");
				String patientId = utility.inputString();
				JSONObject jsonObjectpatient = Utility.readFromJsonFile("patients.json");
				JSONArray jsonArraypatient = (JSONArray) jsonObjectpatient.get("patients");
				boolean patientPresent = false;
				for(int i = 0; i < jsonArraypatient.size();i++)
				{
					 patient = (JSONObject) jsonArraypatient.get(i);
					String id = (String) patient.get("id");
					if(id.equals(patientId))
					{
						patientPresent = true;
						break;
					}
				}
				if(patientPresent)
				{
					Utility.serachAndbookdoctor(patient);
				}
				else
				{
					System.out.println("you are not registered first get registered to avail this");
				}
				break;

			default:
				break;
			}
		}
		while(start < 7);
		
	}

}
