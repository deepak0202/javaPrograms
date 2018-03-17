package com.bridgeit.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.dataStructure.LinkedList;
import com.bridgeit.dataStructure.Linkedlist;
import com.bridgeit.dataStructure.Person;
import com.bridgeit.dataStructure.Queue1;
import com.bridgeit.dataStructure.Stack;
import com.bridgeit.objectOrientedPrograms.PredefineData;
import com.bridgeit.objectOrientedPrograms.UserDetails;;

public class Utility 
{
	public static Scanner scanner;
	
	
	 
	 
	/**
	 *  
	 */
	public Utility()
	{
		scanner = new Scanner(System.in);
		
	}
	/**
	 * @return string input given by the user
	 */
	public  String inputString()
	{
		try
		{
			return scanner.next();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return "";
	}
	public  long inputLong()
	{
		try
		{
			return scanner.nextLong();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return 0;
	}
	
	
	
	public  String inputStringLine()
	{
		try
		{
			scanner.nextLine();
			return scanner.nextLine();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return "";
	}
	/**
	 * @return int value given by the user
	 */
	public int inputInteger()
	{
		try
		{
			return scanner.nextInt();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/**
	 * @return double value given by the user
	 */
	public double inputDouble()
	{
		try
		{
			return scanner.nextDouble();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0.0;
	}
	/**
	 * @return boolean value given by the user
	 */
	public boolean inputBoolean()
	{
		try
		{
			return scanner.nextBoolean();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * @param stake = total amount of money gamble have
	 * @param goal = total amount of money gamble want to reach
	 * @param time = max number of times gamble will play
	 *  it print wining and loss percent of gambler
	 */
	
	public static void gambler(int stake,int goal,int time)
	{
		int won = 0;
		int loss = 0;
		int heplayed = 0;
		for(int i = 1; i <=time;i++)
		{
			heplayed++;
			if(Math.random() <0.5)
			{
				stake--;
				loss++;
			}
			else
			{
				stake++;
				won++;
			}
			if(stake == 0 || stake == goal)
			{
				break;
			}
		}
		System.out.println("number of wins " + won);
		double winPercent =(double)(won*100)/(double)heplayed;
		System.out.println("percent of won " + winPercent);
		double lossPercent = (double) (loss*100)/(double) heplayed;
		System.out.println("percent of loss " + lossPercent);
	}
	/**
	 * @param numberOfCoupon = number of coupon user wants to genrate
	 * print distinct coupon number
	 */
	public static HashSet<Integer> coupon(int numberOfCoupon)
	{
		int y = 0;
		int min = 1;
		Random r = new Random();
		HashSet<Integer> h = new HashSet<Integer>();
		while(h.size()!= numberOfCoupon)
		{
			y =min + r.nextInt(numberOfCoupon);

				h.add(y);
		}
		return h;
	}
	/**
	 * @param array = name of array whose triplete we want to genrate
	 * print triplet whose sum is zero
	 */
	public static void triplet(int[] array)
	{
		int length = array.length;
		for(int i = 0;i<length-2;i++)
		{
			if(array[i] + array[i+1]+array[i+2]==0)
			{
				System.out.println(array[i] + " " + array[i+1] + " " + array[i+2]);
				
			}
		}
	}
	/**
	 * @param a = value present in quadratic equation with x^2
	 * @param b = value present in quadratic equation with x
	 * @param c = alone number present in quadratic equation
	 * print the roots of quadratic equation and tell whether they are real,equal or imaginary
	 */
	public static void quadratic(double a,double b,double c)
	{
		double delta = b*b - 4*a*c;
		if(delta >0)
		{
			System.out.println("roots real and unequal");
			double Root1 = (-b + Math.sqrt(delta))/(2*a);
			double Root2 = (-b - Math.sqrt(delta))/(2*a);
			System.out.println("1st root " + Root1);
			System.out.println("2nd root " + Root2);
		}
		else if(delta == 0)
		{
			System.out.println("roots real and equal");
			double Root = (-b + Math.sqrt(delta))/(2*a);
			System.out.println("both root are " + Root);
		}
		else
		{
			System.out.println("roots are imaginary");
		}
	}
	/**
	 * take input as integer or boolean or double type array and print repective type
	 */
	public static void array2d()
	{
		Utility utility = new Utility();
		System.out.println("enter 1 for integer");
		System.out.println("enter 2 for double");
		System.out.println("enter 3 for boolean");
		int ca= utility.inputInteger();
		System.out.println("enter no of rows");
		int row = utility.inputInteger();
		System.out.println("enter no of colum");
		int colums = utility.inputInteger();
		switch (ca) 
		{
		case 1:
			Integer[][] array= new Integer[row][colums];
			for(int i = 0; i<row;i++)
			{
				for(int j = 0; j<colums;j++)
				{
					System.out.println("enter x["+i+"]["+j+"] element of array");
					array[i][j] = utility.inputInteger();
				}
			}
			printArray(array, row, colums);
			break;
			case 2:
				Double[][] array2 = new Double[row][colums];
				for(int i = 0; i<row;i++)
				{
					for(int j = 0; j<colums;j++)
					{
						System.out.println("enter x["+i+"]["+j+"] element of array");
						array2[i][j] = utility.inputDouble();
					}
				}
				printArray(array2, row, colums);
				break;
				case 3:
					Boolean[][] array3 = new Boolean[row][colums];
					for(int i = 0; i<row;i++)
					{
						for(int j = 0; j<colums;j++)
						{
							System.out.println("enter x["+i+"]["+j+"] element of array");
							array3[i][j] = utility.inputBoolean();
						}
					}
					printArray(array3, row, colums);
					break;
					default:
						System.out.println("enter correct number");
						break;
		}
	}
	/**
	 * @param array = name of the 2d array which we want to print
	 * @param row = number of rows in that array
	 * @param colums = number of colums in that array
	 */
	public  static <T> void printArray(T[][] array,int row,int colums) 
	{
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < row; i++) 
		{
			for(int j = 0;j<colums;j++)
			{
			printWriter.print(array[i][j]+" ");
			printWriter.flush();
			}
			printWriter.println();
		}
		
	}
	/**
	 * @param t = temperature in Fahrenheit
	 * @param v = wind speed in  miles per hours
	 * calculate and print the wind chill 
	 */
	public static void windChill(double t,double v)
	{
		if(t>50 || v>120 || v<3)
		{
			System.out.println("can't calculate for these value");
		}
		else
		{
			double windChill = 35.74 + (0.6215*t)+ (((0.4275*t)-35.75) *Math.pow(v, 0.16));
			System.out.println(windChill);
		}
	}
	/**
	 * @param x x-axis coordinate
	 * @param y y-axis coordinate
	 * @return distance b/w origin and the given coordinates
	 */
	public static double euclideanDistance(int x,int y)
	{
		double distance = Math.sqrt((x*x)+(y*y));
		return distance;
	}
	/**
	 * @param number = number till which power of two has to be calculate
	 * generate table of 2 pow 1 to 2 pow till number entered by user
	 */
	public static void power(int number)
	{
		int value =0;
		if(number<0|| number>31)
		{
			System.out.println("stack overflow");
		}
		else
		{
			for(int i = 0;i<=number;i++)
			{
				value = (int) Math.pow(2, i);
				System.out.println("2^"+i+" = " + value);
			}
		}
	}
	/**
	 * @param number = represent till which number we have to find harmonic series sum
	 * it print the sum of n harmonic number
	 */
	public static void harmonic(double number)
	{
		double sum = 0;
		if(number==0)
		{
			System.out.println("enter a non zero number");
		}
		else
		{
			for(int i = 1; i<= number; i++)
			{
				sum+=(double)1/i;
			}
			System.out.println(sum);
		}
	}
	/**
	 * @param number = takes number whose primeFactorization we have to found
	 * print prime factor of the number
	 */
	public static void primeFactorization(int number)
	{
		for(int i = 1;i<number;i++)
		{
			if(number%i==0 && prime(i))
			{
				System.out.println(i);
			}
		}
	}
	/**
	 * @param number = number which has to be checked whether prime or not
	 * @return boolean if number prime then true else false
	 */
	public static boolean prime(int number)
	{
		boolean b = false;
		for(int i = 2; i < number; i ++)
		{
			if(number % i ==0)
			{
				b = false;
				break;
			}
			else
			{
				b= true;
			}
		}
		if(number == 2)
		{
			b= true;
		}
		return b;
	}
	/**
	 * method to play tictoe game with computer
	 */
	public static void tictoe()
	{
		Utility utility = new Utility();
		String[][] x = new String[3][3];
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j <3;j++)
			{
				x[i][j]=" ";
			}
		}
		int row = 0;
		int colum = 0;
		int min = 0;
		boolean playerchance = true;
		boolean computerchance = true;
		Random random = new Random();
		tictoedisplay(x);
		l :
		while(true)
		{
			if(placeLeft(x) != 0)
			{
				while(playerchance)
				{
					System.out.println("player x enter your position");
					int position = utility.inputInteger();
					switch (position)
					{
					case 1:
						row = 0;
						colum = 0;
						break;
					case 2:
						row = 0;
						colum = 1;
						break;
					case 3:
						row = 0;
						colum = 2;
						break;
					case 4:
						row = 1;
						colum = 0;
						break;
					case 5:
						row = 1;
						colum = 1;
						break;
					case 6:
						row = 1;
						colum = 2;
						break;
					case 7:
						row = 2;
						colum = 0;
						break;
					case 8:
						row = 2;
						colum = 1;
						break;
					case 9:
						row = 2;
						colum = 2;
						break;

					default:
						System.out.println("enter b/w 1 to 9");
						continue;
						
					}
					if(x[row][colum].equals(" "))
					{
						x[row][colum]="x";
						playerchance = false;
						computerchance = true;
					}
					else
					{
						System.out.println("enter diffent cell this one already occupy");
					}
				}
				tictoedisplay(x);
				if((x[0][0]==x[0][1] && x[0][1]==x[0][2] && x[0][2].equals("x"))||
						   (x[1][0]==x[1][1] && x[1][1]==x[1][2] && x[1][2].equals("x"))||
						   (x[2][0]==x[2][1] && x[2][1]==x[2][2] && x[2][2].equals("x"))||
						   (x[0][0]==x[1][0] && x[1][0]==x[2][0] && x[2][0].equals("x"))||
						   (x[0][1]==x[1][1] && x[1][1]==x[2][1] && x[2][1].equals("x"))||
						   (x[0][2]==x[1][2] && x[1][2]==x[2][2] && x[2][2].equals("x"))||
						   (x[0][0]==x[1][1] && x[1][1]==x[2][2] && x[2][2].equals("x"))||
						   (x[0][2]==x[1][1] && x[1][1]==x[2][0] && x[2][0].equals("x")))
						{
							System.out.println("player wins");
							break l;
						}
			}
			else
			{
				System.out.println("draw");
				break l;
			}
			if(placeLeft(x) != 0)
			{
				while(computerchance)
				{
					row = min +random.nextInt(3);
					colum =min+ random.nextInt(3);
					if(x[row][colum].equals(" "))
					{
						x[row][colum]="o";
						playerchance = true;
						computerchance= false;
					}
				}
				tictoedisplay(x);
				if((x[0][0]==x[0][1] && x[0][1]==x[0][2] && x[0][2].equals("o"))||
						   (x[1][0]==x[1][1] && x[1][1]==x[1][2] && x[1][2].equals("o"))||
						   (x[2][0]==x[2][1] && x[2][1]==x[2][2] && x[2][2].equals("o"))||
						   (x[0][0]==x[1][0] && x[1][0]==x[2][0] && x[2][0].equals("o"))||
						   (x[0][1]==x[1][1] && x[1][1]==x[2][1] && x[2][1].equals("o"))||
						   (x[0][2]==x[1][2] && x[1][2]==x[2][2] && x[2][2].equals("o"))||
						   (x[0][0]==x[1][1] && x[1][1]==x[2][2] && x[2][2].equals("o"))||
						   (x[0][2]==x[1][1] && x[1][1]==x[2][0] && x[2][0].equals("o")))
						{
							System.out.println("computer wins");
							break l;
						}
			}
			else
			{
				System.out.println("draw");
				break l;
			}
		}
		System.out.println("game over");
	}
	/**
	 * @param x = input 2d array of String type
	 * @return integer  number of " " in the array
	 */
	public static int placeLeft(String[][] x)
	{
		int count = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(x[i][j].equals(" "))
				{
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * @param x = to print the table of tietoe game on console
	 */
	public static void tictoedisplay(String[][] x)
	{
		System.out.println(x[0][0]+"|"+x[0][1]+"|"+x[0][2]);
		System.out.println("------");
		System.out.println(x[1][0] +"|"+x[1][1]+"|"+x[1][2]);
		System.out.println("------");
		System.out.println(x[2][0]+"|"+x[2][1]+"|"+x[2][2]);
	}
	/**
	 * @param name = String which has to be printed with msg
	 * check whether String is greater then 3 character if it is them print it with msg
	 */
public	static void hello(String name)
	{
	if(name.length()>=3)
	{
	System.out.println("Hello " + name + ", How are you?");
	}
	else
	{
	System.out.println("enter string haveing 3 or more charater");
	}

	}


	/**
	 * @param numberOfTimes = number of times we have to flip the coin
	 * print the percent of head and tail occurrence
	 */
	public static void flipCoin(int numberOfTimes)
	{
	int tail = 0;
	int head = 0;
	for(int i = 1; i<=numberOfTimes;i++)
	{
	if(Math.random() <0.5)
	{
	tail++;
	}
	else
	{
	head++;
	}
	}
	double headPercent = (head * 100) /numberOfTimes;
	double tailPercent = (tail * 100) /numberOfTimes;
	System.out.println("Head percent" + headPercent + "v/s tail Percent" + tailPercent);
	}


	/**
	 * @param year= year which is to be checked whether leap or not
	 * @return boolean if year is leap then true else false
	 */
	public static boolean leap(int year)
	{
	if(year%4==0)
			{
				if(year%100==0)
				{
					if(year%400==0)
					{
						return true;
					}
					else
					{
						return false;
					}
					
				}
				else
				{
					return true;
				}
			}
			else
			{
				return false;
			}
	}
	/**
	 * @return current time of system
	 */
	public static long start()
	{
		return  System.currentTimeMillis();
	}
	/**
	 * @return  current time of system
	 */
	public static long end()
	{
		return  System.currentTimeMillis();
	}
	/**
	 * @param start =  time value 
	 * @param end = time value
	 * @return diffrence bettween start and end
	 */
	public static long timeLaps(long start, long end)
	{
		return end - start;
	}
	
	/**
	 * @param x = name of the integer type array to be sorted
	 * @return sorted array of integer type
	 */
	public	static int[] sort(int[] x)
		{
			int l = x.length;
			for(int i = 0; i <l-1;i++)
			{
				for(int j = i+1;j<l;j++)
				{
					if(x[i] > x[j])
					{
						int temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
				}
			}
			return x;
		}
		/**
		 * @param x = name of String type array to be sorted
		 * @return sorted array of String type
		 */
	public	static String[] sort(String[] x)
		{
			int l = x.length;
			for(int i = 0; i <l-1;i++)
			{
				for(int j = i+1;j<l;j++)
				{
					if(x[i].compareTo(x[j])>0)
					{
						String temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
				}
			}
			return x;
		}

		/**
		 * @param x = String type array in which String is to be searched
		 * @param key = string to be Search
		 * @return boolean true if key is found else false
		 */
	public	static boolean serarch(String[] x,String key)
		{
			for(int i = 0;i<x.length;i++)
			{
				if(key.equals(x[i]))
				{
					return true;
				}
				
			}
			return false;
		}

		/**
		 * @param string1 = String to be checked anagram with other string
		 * @param string2 = String to be checked anagram with other string
		 * @return boolean true if Strings are anagram else false
		 */
		public static boolean anagram(String string1,String string2)
		{
			String string3 = string1.replaceAll(" +", "").toLowerCase();
			String string4 = string2.replaceAll(" +", "").toLowerCase();
			char[] ch1 = string3.toCharArray();
			char[] ch2 = string4.toCharArray();
			int length1 = ch1.length;
			int length2 = ch2.length;
			for(int i = 0; i < length1; i++)
			{
				l :
				for(int j = 0; j < length2; j++)
				{
					if(ch1[i]==ch2[j])
					{
						for(int k = j; k <length2-1;k++)
						{
						ch2[k]= ch2[k+1];
						}
						length2--;
						break l;
					}
				}
			}
			if(length2==0)
			{
			return true;
			}
			else
			{
				return false;
			}
		}

		/**
		 * @param change = amount for which min number of change to be found
		 * @param count = total number of notes return in starting take it as 0
		 * @param hashSet = refrence variable of hashset
		 * print the notes return by vending machine and and min number of notes to be return
		 * its a recursive method
		 */
		public static void vending(int change,int count,HashSet<Integer> hashSet)
		{
			int[] notes = {1000,500,100,50,10,5,2,1};
			for(int i = 0; i<notes.length;i++)
			{
				if(change>= notes[i])
				{
					change = change - notes[i];
					count++;
					hashSet.add(notes[i]);
					break;
				}	
			}
			if(change == 0)
			{
				 System.out.println(count);
				 System.out.println(hashSet);
				return;
			}
			vending(change,count,hashSet);
		}
		/**
		 * @param number = number to be checked whether palindrome or not
		 * @return boolean true if number is palindrome else false
		 */
		public static boolean Palindrome(int number)
		{
			String numberString = Integer.toString(number);
			String s1 ="";
			for(int i = numberString.length()-1;i>=0;i--)
			{
				s1+=numberString.charAt(i);
			}
			if(s1.equals(numberString))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		/**
		 * @param n1 = number to be checked with other number whether it is anagram or not
		 * @param n2 = number to be checked with other number whether it is anagram or not
		 * @return boolean true if both number anagram else false
		 */
		public static boolean anagram(int n1,int n2)
		{
			String s3 = Integer.toString(n1);
			String s4 = Integer.toString(n2);
			char[] ch1 = s3.toCharArray();
			char[] ch2 = s4.toCharArray();
			int l1 = ch1.length;
			int l2 = ch2.length;
			for(int i = 0; i < l1; i++)
			{
				l :
				for(int j = 0; j < l2; j++)
				{
					if(ch1[i]==ch2[j])
					{
						for(int k = j; k <l2-1;k++)
						{
						ch2[k]= ch2[k+1];
						}
						l2--;
						break l;
					}
				}
			}
			if(l2==0)
			{
			return true;
			}
			else
			{
				return false;
			}
			
		}
		/**
		 * @param v = value of temperature to be changed
		 * @param c = determine whether value is in Celsius  or in Fahrenheit 
		 * @return temperature in celsius if imput is in fahrenheit vice-versa
		 */
		public static double temperaturConversion(double v,String c)
		{
			if(c=="f")
			{
				return  ((v*9)/5) + 32;
			}
			else
			{
				return ((v-32)*5)/9;
			}
		}
		/**
		 * @param x = name of the array to be sorted
		 * @return sorted integer type array by useing insertionSort algorithm
		 */
		public static int[] insertionSort(int[] x)
		{
			int key=0;
			int j=0;
			for(int i = 0; i < x.length;i++)
			{
				j= i-1;
				key = x[i];
			while(j>=0 && x[j]>key)
			{
				x[j+1] = x[j];
				j--;
			}
			x[j+1] = key;
			}
			return x;
		}
		/**
		 * @param array = String type of array which is to be sorted
		 * @return String type sorted array use insertion sort algo 
		 */
		public static String[] insertionSort(String[] array)
		{
			String key="";
			int j=0;
			for(int i = 0; i < array.length;i++)
			{
				j= i-1;
				key = array[i];
				
			while(j>=0 && array[j].compareTo(key)>0)
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
			}
			return array;
		}
		/**
		 * @param array = integer type array which is to be sort 
		 * @return sorted array useing bubblesort algo
		 */
	public	static int[] bubbleSort(int[] array)
		{
			for(int i = 0; i < array.length-1;i++)
			{
				for(int j = 0; j<array.length-i-1;j++)
				{
					if(array[j] > array[j+1])
					{
						int temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
			return array;
		}
		/**
		 * @param x =String type array which is to be sort 
		 * @return sorted array useing bubblesort algo
		 */
	public	static String[] bubbleSort(String[] x)
		{
			for(int i = 0; i < x.length-1;i++)
			{
				for(int j = 0; j<x.length-i-1;j++)
				{
					
					if(x[j].compareTo(x[j+1])>0)
					{
						String temp = x[j];
						x[j] = x[j+1];
						x[j+1] = temp;
					}
				}
			}
			return x;
		}
		/**
		 * @param m = month 
		 * @param d = day of month
		 * @param y = year
		 * return integer value 0 for sunday 1 for monday and so on
		 */
		public static int dayOfWeek(int m,int d,int y)
		{
			int y0 = y-((14-m)/12);
			int x = y0 + (y0/4) - (y0/100) + (y0/400);
			int m0 = m + (12*((14-m)/12)) -2;
			int d0 = (d+x+((31*m0)/12)) % 7;
			return d0;
			
		}
       /**
     * @param dayOfWeek = int value of week day
     * print the week day
     */
    public static void printDayOfWeek(int dayOfWeek)
       {
    	   switch (dayOfWeek) 
			{
			case 0:
				System.out.println("sunday");
				break;
			case 1:
				System.out.println("monday");
				break;
			case 2:
				System.out.println("tuesday");
				break;
			case 3:
				System.out.println("wednesday");
				break;
			case 4:
				System.out.println("thusday");
				break;
			case 5:
				System.out.println("friday");
				break;
			case 6:
				System.out.println("saturday");
				break;
			default:
				System.out.println("enter correct input");
				break;
			}
       }

		/**
		 * @param p=principle amount
		 * @param y = time in years
		 * @param R = rate of interest
		 * @return monthly amount to be payed
		 */
		public static double monthlyPayment(double p,double y,double R)
		{
			double r = R/(12 *100);
			double n = 12 * y;
			double pay = (p*r)/(1-Math.pow(1+r, -n));
			return pay;
		}
		/**
		 * @param c = number whose sqrt to be found
		 * print the sqrt of number
		 */
		public static void sqrt(int c)
		{
			if(c>=0)
			{
				double epsilon = 1e-15;
				double t = c;
				
				while((Math.abs(t-(c/t))) >epsilon *t)
				{
					t = (c/t + t)/2.0;
				}
				System.out.println(t);
			}
			else
			{
				System.out.println("enter a positive number");
			}
		}
		/**
		 * @param number = number which is to be converted to binary
		 * convert the number into binary number
		 */
		public static void toBinary(int number)
		{
			String binary = "";
			while(number != 0)
			{
				int reminder = number % 2;
				number = number/2;
				binary = reminder + binary;
			}
			System.out.println(binary);
			int number1 = 0;
			int j = 0;
			int digit = 0;
			int binary1 = Integer.parseInt(binary);
			String respretation = "";
			while(binary1 != 0)
			{
				digit = binary1 % 10;
				if(digit == 1)
				{
					number1 += Math.pow(2, j);
					respretation ="+ " +(int)Math.pow(2, j) + respretation;
				}
				binary1 = binary1/10;
				j++;
			}
			String finalreprsentation = number1 + " = " + respretation.substring(1, respretation.length());
			System.out.println(finalreprsentation);
		}
		/**
		 * @param number = number to be converted into binary
		 * convert number into binary then swap it from center then convert new binary to number
		 */
		public static void binary(int number)
		{
			String binary = "";
			while(number != 0)
			{
				int reminder = number % 2;
				number = number/2;
				binary = reminder + binary;
			}
			for(int i = binary.length();i<8;i++)
			{
				binary = 0 + binary;
			}
			String nible1 = binary.substring(0, 4);
			String nible2 = binary.substring(4, 8);
			String newBinary = nible2+nible1;
			int number1 = Integer.parseInt(newBinary);
			int j = 0;
			int number2 = 0;
			int digit = 0;
			while(number1 != 0)
			{
				digit = number1 % 10;
				if(digit == 1)
				{
					number2 += Math.pow(2, j);
				}
				j++;
				number1 = number1/10;
			}
			System.out.println(number2);
	}
		 /**
		 * @param str = string input 
		 * @param l = index to be kept constant
		 * @param r = length of string
		 * print all permutation of string pass 
		 */
		public static void permute(String str, int start, int end)
		    {
		        if (start == end)
		            System.out.println(str);
		        else
		        {
		            for (int i = start; i <= end; i++)
		            {
		                str = swap(str,start,i);
		                permute(str, start+1, end);
		                str = swap(str,start,i);
		            }
		        }
		    }
		 /**
		 * @param str=name of the string whose charater are to be swaped
		 * @param first= index of character to be swaped
		 * @param j= index of character to be swaped
		 * @return new string with its character swaped
		 */
		public static String swap(String str, int first, int j)
		    {
		        char temp;
		        char[] charArray = str.toCharArray();
		        temp = charArray[first] ;
		        charArray[first] = charArray[j];
		        charArray[j] = temp;
		        return String.valueOf(charArray);
		    }
	/**
	 * @throws IOException while reading file if file is not present
	 */
	public	static void testDataTolinklistController() throws IOException
		{
			LinkedList linkedlist = new LinkedList();
			LinkedList refernces = textDataToLinklist("linkedlistdata.text", linkedlist);
			Utility utility = new Utility();
			System.out.println("enter the word to be serched in linkedlist");
			String wordToBeSerched = utility.inputString();
			if(refernces.search(wordToBeSerched))
			{
				refernces.delete(wordToBeSerched);
			}
			else
			{
				refernces.add(wordToBeSerched);
			}
			linkedlistdatatofile(refernces);
		}
	/**
	 * @param fileName from which file we will read data
	 * @param refernces linkedlist refrense variable
	 * @return linkedlist refrence variable in which file data is stored
	 * @throws IOException while trying to read daa from file if file is not found
	 */
	public	static LinkedList textDataToLinklist(String fileName, LinkedList refernces) throws IOException
		{
			BufferedReader bufferedReadder = new BufferedReader(new FileReader(fileName));
			String line = bufferedReadder.readLine();
			while(line != null)
			{
				String[] array = line.split(" ");
				for(String data : array)
				{
					refernces.add(data);
				}
				line = bufferedReadder.readLine();
			}
			bufferedReadder.close();
			return refernces;
		}
	/**
	 * @param refernces refrence variable of linklist in which data is stored
	 * @throws IOException if while writeing data to file file is not present
	 * put linklist data in the file 
	 */
	public	static void linkedlistdatatofile(LinkedList refernces) throws IOException
		{
			File file = new File("linkedlistdata1.text");
			file.createNewFile();
			PrintWriter printWriter = new PrintWriter("linkedlistdata1.text");
			for(int i = 0; i < refernces.size();i++)
			{
				printWriter.print((String)refernces.dataAtPosition(i));
				printWriter.print(" ");
			}
			printWriter.flush();
			printWriter.close();
		}
	/**
	 * @throws IOException for file not found
	 * read integer from file and save it in sorted linked list them take integer as input
	 * if present in linked list delete it else add it in linked list 
	 * then print data of linkedlist in file 
	 */
	public static void readIntegerController() throws IOException
	{
		Linkedlist linkedlist = new Linkedlist();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("Integerdata.text"));
		String line = bufferedReader.readLine();
		while(line != null)
		{
			String[] array = line.split(" ");
			for(String words : array)
			{
				linkedlist.add(Integer.parseInt(words));
			}
			line = bufferedReader.readLine();
		}
		Utility utility = new Utility();
		System.out.println("enter the digit to be searched");
		int digit = utility.inputInteger();
		if(linkedlist.search(digit))
		{
			linkedlist.delete(digit);
		}
		else
		{
			linkedlist.add(digit);
		}
		integerDataToFile(linkedlist,"integerdata1.text");
		bufferedReader.close();
	}
	/**
	 * @param refrences = refrence variable of linkedlist 
	 * @param fileName = name of file in which data is to be pushed
	 * @throws IOException = handleing exception if file is not found
	 * put data in linkedlist to file
	 */
	public static void integerDataToFile(Linkedlist refrences,String fileName) throws IOException
	{
		File file = new File("integerdata1.text");
		file.createNewFile();
		PrintWriter printWriter = new PrintWriter(fileName);
		for(int i = 0; i< refrences.size();i++)
		{
			printWriter.print(refrences.dataAtPosition(i));
			printWriter.print(" ");
		}
		printWriter.flush();
		printWriter.close();
	}
	/**
	 * @param ArithmeticExpression = string ArithmeticExpression which is to be checked balance or not
	 * @return boolean true if expression is balanced else false
	 */
	public static	boolean simpleBalancedParentheses(String ArithmeticExpression)
	{
		Stack stack = new Stack();
		for(int i = 0; i < ArithmeticExpression.length();i++)
		{
			if(ArithmeticExpression.substring(i, i+1).equals("("))
			{
				stack.push(1);
			}
			else if(ArithmeticExpression.substring(i, i+1).equals(")"))
					{
					try 
					{
						stack.pop();
					}
					catch (NullPointerException e) 
					{
						return false;
					}
					}
		}
		if(stack.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @param month 
	 * @param year
	 * @return int values cospondeing to week day of 1st of that month
	 */
	public static int dayOfMonthStarting(int month,int year)
	{
		int y = year;
		int m = month;
		int d = 1;
		int y0 = y-((14-m)/12);
		int x = y0 + (y0/4) - (y0/100) + (y0/400);
		int m0 = m + (12*((14-m)/12)) -2;
		int d0 = (d+x+((31*m0)/12)) % 7;
		return d0;
	}
/**
 * @param month
 * @param year
 * print the month calender of given month and year
 */
public static	void printMonthCalender(int month,int year)
	{
		int monthstart = 0;
		String[][] x = new String[7][7];
		x[0][0]="S";x[0][1]="M";x[0][2]="T";x[0][3]="W";x[0][4]="TH";x[0][5]="F";x[0][6]="SA";
		for(int i = 1; i <=6;i++)
		{
			for(int j = 0; j <= 6;j++)
			{
				x[i][j]=" ";
			}
		}
		int maxdays = 0;
		if(month == 1 || month== 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			maxdays = 31;
		}
		else if(month ==4 || month == 6 || month == 9 || month == 11)
		{
			maxdays = 30;
		}
		else
		{
			if(leap(year))
			{
				maxdays = 29;
			}
			else
			{
				maxdays = 28;
			}
		}
		for(int i = 1; i <= 5; i++)
		{
			int begin = 0;
			if(i==1)
			{
				 begin = dayOfMonthStarting(month, year);
				
			}
			
			for(int j = begin;j<=6;j++)
			{
				x[i][j]=Integer.toString(++monthstart);
				if(monthstart == maxdays)
				{
					break;
				}
			}
		}
		for(int i = 0; i <=6;i++)
		{
			for(int j = 0; j <=6;j++)
			{
				System.out.print(x[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
/**
 * @param month
 * @param year
 * @return return number of days present in month of given month and year
 */
public static int maxDays(int month,int year)
{
	int maxdays = 0;
	if(month == 1 || month== 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
	{
		maxdays = 31;
	}
	else if(month ==4 || month == 6 || month == 9 || month == 11)
	{
		maxdays = 30;
	}
	else
	{
		if(leap(year))
		{
			maxdays = 29;
		}
		else
		{
			maxdays = 28;
		}
	}
	return maxdays;
}
/**
 * @param month
 * @param year
 * print month calender with useing stack
 */
public static void calenderWithStack(int month,int year)
{
	Stack week = new Stack();
	int start = Utility.dayOfMonthStarting(month, year);
	int maxDay = Utility.maxDays(month, year);
	int numberOfObject;
	int date = 0;
	if(maxDay + start>35)
	{
		numberOfObject = 6;
	}
	else
	{
		numberOfObject = 5;
	}
	for(int i = 0; i < numberOfObject;i++)
	{
		week.add(new Stack());
	}
	for(int i = 0; i < numberOfObject;i++)
	{
		Stack stack =week.dataAtPosition(i);
		if(i==0)
		{
			for(int j = 0; j <start; j++)
			{
				stack.add(" ");
			}
			for(int j = start;j<7;j++)
			{
				stack.add(++date);
			}
		}
		else
		{
			for(int j = 0; j <7;j++)
			{
				stack.add(++date);
				if(date == maxDay)
				{
					break;
				}
			}	
		}
	}
	System.out.println("SUN"+"\t"+"M"+"\t"+"TU"+"\t"+"WED"+"\t"+"TH"+"\t"+"FRI"+"\t"+"SAt");
	for(int i = 0; i < numberOfObject; i++)
	{
		Stack stack =  week.dataAtPosition(i);
		int length = stack.size();
		for(int j = 0; j <length; j++)
		{
			
			String s1 = stack.dataAtPosition(j).toString();
			System.out.print(s1);
			System.out.print("\t");
		}
		System.out.println();
	}
}
/**
 * @param start = starting number from where prime number is to found
 * @param end = number till which prime number to be found
 * @return arraylist containing prime number b/w start to end range
 */
public static ArrayList<Integer> primeNumberInRange(int start, int end)
{
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	for(int i = start;i<=end;i++)
	{
		if(prime(i))
		{
			arrayList.add(i);
		}
	}
	return arrayList;
}
/**
 * @param arrayList = refrence of arraylist which will be converted to 2d array
 */
public static void arraylistTo2DArray(ArrayList<Integer> arrayList)
{
	int slot = 100;
	String[][] array = new String[10][25];
	for(int i = 0; i <10; i++)
	{
		for(int j = 0; j < 25; j++)
		{
			array[i][j] = " ";
		}
	}
	int row = 0;
	int colum = 0;
	for(int i = 0; i <arrayList.size();i++)
	{
		
		 int data = arrayList.get(i);
		 if(data>slot)
		 {
			 slot +=100;
			 row++;
			 colum = 0;
		 }
		 array[row][colum++] = Integer.toString(data);
	}
	for(int i = 0; i <10; i++)
	{
		for(int j = 0; j <25;j++)
		{
			System.out.print(array[i][j] + "\t");
		}
		System.out.println();
	}
	
}
/**
 * @param arrayList= refrence of arraylist storeing some data
 * @return treeset haveing anagram
 */
public static TreeSet<Integer> anagramInArraylist(ArrayList<Integer> arrayList)
{
	TreeSet<Integer> treeSet = new TreeSet<>();
	for(int i = 0; i < arrayList.size()-1;i++)
	{
		for(int j = i +1; j< arrayList.size();j++)
		{
			if(anagram(arrayList.get(i), arrayList.get(j)))
			{
				treeSet.add(arrayList.get(i));
				treeSet.add(arrayList.get(j));
			}
		}
	}
	return treeSet;
}
/**
 * @param treeSet refrence of tree set to be converted to 2d array
 */
public static void treesetTo2DArray(TreeSet<Integer> treeSet)
{
	int slot = 100;
	Object[] array1 = treeSet.toArray();
	String[][] array = new String[10][25];
	for(int i = 0; i <10; i++)
	{
		for(int j = 0; j < 25; j++)
		{
			array[i][j] = " ";
		}
	}
	int row = 0;
	int colum = 0;
	for(int i = 0; i <array1.length;i++)
	{
		 int data = (Integer)array1[i];
		 if(data>slot)
		 {
			 slot +=100;
			 row++;
			 colum = 0;
		 }
		 array[row][colum++] = Integer.toString(data);
	}
	for(int i = 0; i <10; i++)
	{
		for(int j = 0; j <25;j++)
		{
			System.out.print(array[i][j] + "\t");
		}
		System.out.println();
	}
}
/**
 * @param node = number of node of binary search tree
 * @return posible outcome for binary serach tree
 */
public static long binarySearchTree(int node)
{
	long sum=0;
	if(node<=1)
	{
		return 1;
	}
	else
	{
		for(int i=1; i<=node; i++)
		{
			sum=sum+(binarySearchTree(i-1)*binarySearchTree(node-i));
		}
		return sum;
	}
}
/**
 * @throws FileNotFoundException
 * to take the user input about the inventory and add it to json file
 */
@SuppressWarnings("unchecked")
public static void writeInventoryJsonFile() throws FileNotFoundException
{
	Map<Object, Object> map;
	Utility utility = new Utility();
	PrintWriter printWriter = new PrintWriter("inventory.json");
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArrayOfRice = new JSONArray();
	JSONArray jsonArrayOfPulse = new JSONArray();
	JSONArray jsonArrayOfWheat = new JSONArray();
	
	System.out.println("enter number of rice varity you want to enter in inventory");
	int numberOfrice = utility.inputInteger();
	
	for(int i = 1; i <= numberOfrice; i++)
	{
		map = new LinkedHashMap<>();
		System.out.println("enter the name of rice of " + i);
		String riceName = utility.inputString();
		System.out.println("enter weight of rice of" + i);
		double weight = utility.inputDouble();
		System.out.println("enter the price of rice of " + i);
		double price = utility.inputDouble();
		map.put("name", riceName);
		map.put("weight", weight);
		map.put("price", price);
		jsonArrayOfRice.add(map);
	}
	
	System.out.println("enter number of pulse varity you want to enter in inventory");
	int numberOfPulse = utility.inputInteger();
	
	for(int i = 1; i<=numberOfPulse;i++)
	{
		map = new LinkedHashMap<>();
		System.out.println("enter the name of pulse of " + i);
		String pulseName = utility.inputString();
		System.out.println("enter the weight of pulse of " + i);
		double weight = utility.inputDouble();
		System.out.println("enter the price of pulse of " + i);
		double price = utility.inputDouble();
		map.put("name", pulseName);
		map.put("weight", weight);
		map.put("price", price);
		jsonArrayOfPulse.add(map);
	}
	
	System.out.println("enter number of wheat varity you want to enter in inventory");
	int numberOfWheat = utility.inputInteger();
	
	for(int i = 1; i<=numberOfWheat; i++)
	{
		map = new LinkedHashMap<>();
		System.out.println("enter the name of wheat of " + i);
		String wheatName = utility.inputString();
		System.out.println("enter the weight of wheat of " + i);
		double weight = utility.inputDouble();
		System.out.println("enter the price of wheat of " + i);
		double price = utility.inputDouble();
		map.put("name", wheatName);
		map.put("weight", weight);
		map.put("price", price);
		jsonArrayOfWheat.add(map);
	}
	
	jsonObject.put("rice", jsonArrayOfRice);
	jsonObject.put("pulse", jsonArrayOfPulse);
	jsonObject.put("wheat", jsonArrayOfWheat);
	
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();
	
}
/**
 * @param filename = string argument of json file name
 * @return the json object present in the file 
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static JSONObject readFromJsonFile(String filename) throws FileNotFoundException, IOException, ParseException
{
	Object obj = new JSONParser().parse(new FileReader(filename));
    JSONObject jo = (JSONObject) obj;
    return jo;
}
/**
 * @param jsonObject = Json object haveing details of inventory
 * print calculated data of inventory 
 */
@SuppressWarnings("rawtypes")
public static void inventoryData(JSONObject jsonObject)
{
	JSONArray rice = (JSONArray) jsonObject.get("rice");
	JSONArray wheat = (JSONArray) jsonObject.get("wheat");
	JSONArray pulse = (JSONArray) jsonObject.get("pulse");
	
	for(int i = 0; i <rice.size();i++)
	{
	Map map = (Map) rice.get(i);
	String name = (String) map.get("name");
	double weight = (double) map.get("weight");
	double price = (double) map.get("price");
	double sum = weight * price;
	System.out.println("total price for rice of varity " + name + " is " + sum);
	}
	System.out.println();
	
	for(int i = 0; i < wheat.size();i++)
	{
		Map map = (Map) wheat.get(i);
		String name = (String) map.get("name");
		double wieght = (double) map.get("weight");
		double price = (double) map.get("price");
		double sum = wieght * price;
		System.out.println("total price for wheat of varity " + name + " is " + sum);
	}
	System.out.println();
	
	for(int i = 0; i < pulse.size();i++)
	{
		Map map = (Map) pulse.get(i);
		String name = (String) map.get("name");
		double wieght = (double) map.get("weight");
		double price = (double) map.get("price");
		double sum = wieght * price;
		System.out.println("total price for pulse of varity " + name + " is " + sum);
	}
}
/**
 * @throws IOException
 * @throws ParseException
 * to json object haveing details of stock in stock.json file
 */
@SuppressWarnings("unchecked")
public static void writeStockJsonFile() throws IOException, ParseException
{
	Map<Object, Object> map;
	Utility utility = new Utility();
	JSONArray jsonArray = new JSONArray();
	JSONObject jsonObject = new JSONObject();
	
	System.out.println("enter the number of stock you want to enter");
	int numberOfStock = utility.inputInteger();
	
	File file = new File("stock.json");
	if(file.length()==0)
	{
	for(int i = 1; i <= numberOfStock; i++)
	{
		System.out.println("enter the stock name of " + i);
		String name = utility.inputString();
		System.out.println("enter the number of share of " + name);
		double numberOfShare = utility.inputDouble();
		System.out.println("enter the price of " + name);
		double price = utility.inputDouble();
		map = new LinkedHashMap<>();
		map.put("name", name);
		map.put("numberOfShare", numberOfShare);
		map.put("price", price);
		jsonArray.add(map);
	}
	
	jsonObject.put("stock", jsonArray);
	
	}
	else
	{
		boolean present = false;
		int index = 0;
		JSONObject jsonObject1 = readFromJsonFile("stock.json");
		JSONArray jsonArray2 = (JSONArray) jsonObject1.get("stock");
		
		for(int k = 1; k <= numberOfStock; k++)
		{
			System.out.println("enter the stock name of ");
			String name = utility.inputString();
			System.out.println("enter the number of share of " + name);
			double numberOfShare = utility.inputDouble();
			System.out.println("enter the price of " + name);
			double price = utility.inputDouble();
			
			for(int i = 0; i < jsonArray2.size();i++)
			{
				map = (Map<Object, Object>) jsonArray2.get(i);
				if(map.containsValue(name))
				{
					present = true;		
					index = i;
					break;
				}
			}
			map = new LinkedHashMap<>();
			map.put("name", name);
			map.put("numberOfShare", numberOfShare);
			map.put("price", price);
			if(present)
			{
				jsonArray2.set(index, map);
				present = false;
			}
			else
			{
				jsonArray2.add(map);
			}
		}
		jsonObject.put("stock", jsonArray2);
	}
	
	PrintWriter printWriter = new PrintWriter("stock.json");
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();		
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * read data from stock and print calculated data
 */
@SuppressWarnings("rawtypes")
public static void readStockJsonFile() throws FileNotFoundException, IOException, ParseException
{
	Map map;
	double stockTotalPrice = 0;
	 JSONObject jsonObject = readFromJsonFile("stock.json");
	 JSONArray jsonArray = (JSONArray) jsonObject.get("stock");
	 System.out.println("stockName" + "\t" + "Numberofshare" + "\t" + "priceofshare" + "\t" + "total price");
	 for(int i = 0; i< jsonArray.size();i++)
	 {
		 map =(Map) jsonArray.get(i);
		 String stockName = (String) map.get("name");
		 int numberOfShare = (int)(double) map.get("numberOfShare");
		 double price = (double) map.get("price");
		 double sharePriceTotal = ((double)numberOfShare) * price;
		 System.out.println(stockName +"\t"+"\t" +"\t"+ numberOfShare +"\t" + price + "\t"+"\t" + sharePriceTotal);
		 stockTotalPrice += sharePriceTotal;
	 }
	 System.out.println("------------------------------------");
	 System.out.println("value of total stock : " + stockTotalPrice);
}

/**
 * @param fileName = string argument haveing filename
 * @param jsonObject = object which data will be printed in json file
 * @throws FileNotFoundException
 */
public static void printJsonObjectToFile(String fileName, JSONObject jsonObject) throws FileNotFoundException
{
	PrintWriter printWriter = new PrintWriter(fileName);
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();
}
/**
 * @throws FileNotFoundException 
 * @throws IOException
 * @throws ParseException
 * use to add person detaial as json object in address.json file
 */
@SuppressWarnings("unchecked")
public static void add() throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	System.out.println("enter the first name of person");
	String firstName = utility.inputString();
	System.out.println("enter the last name of person");
	String lastName = utility.inputString();
	System.out.println("enter the city of person");
	String city = utility.inputString();
	System.out.println("enter the state of person");
	String state = utility.inputString();
	System.out.println("enter zip code");
	String zip = utility.inputString();
	System.out.println("enter the phone number of person");
	String phoneNumber = utility.inputString();
	System.out.println("enter the address of person");
	String address = utility.inputStringLine();
	
	JSONObject jsonObject = readFromJsonFile("address.json");
	JSONArray jsonArray = (JSONArray) jsonObject.get("address");
	
	JSONObject person = new JSONObject();
	person.put("firstName", firstName);
	person.put("lastName", lastName);
	person.put("city", city);
	person.put("state", state);
	person.put("zip", zip);
	person.put("phoneNumber", phoneNumber);
	person.put("address", address);
	jsonArray.add(person);
	
	jsonObject.put("address", jsonArray);
	
	printJsonObjectToFile("address.json", jsonObject);
	System.out.println("person detail added in address book");
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to edit detail of person present in address.json file 
 */
@SuppressWarnings("unchecked")
public static void edit() throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	int index = 0;
	JSONObject person = null;
	boolean present = false;
	System.out.println("enter the name of the person");
	String firstName = utility.inputString();
	JSONObject jsonObject = readFromJsonFile("address.json");
	JSONArray jsonArray = (JSONArray) jsonObject.get("address");
	for(int i = 0; i < jsonArray.size();i++)
	{
		 person = (JSONObject) jsonArray.get(i);
		String personFirstName = (String) person.get("firstName");
		if(personFirstName.equals(firstName))
		{
			index = i;
			present = true;
			break;
		}
	}
	if(present)
	{
		int start;
		do
		{
			System.out.println("enter 1 to edit lastName");
			System.out.println("enter 2 to edit city");
			System.out.println("enter 3 to edit state");
			System.out.println("enter 4 to edit zip");
			System.out.println("enter 5 to edit phoneNumber");
			System.out.println("enter 6 to edit address");
			System.out.println("enter 7 to stop editing");
			int choise = utility.inputInteger();
			start = choise;
			switch (choise) 
			{
			case 1:
				System.out.println("enter the last name");
				String lastName = utility.inputString();
				person.put("lastName", lastName);
				break;
			case 2:
				System.out.println("enter the city");
				String city = utility.inputString();
				person.put("city", city);
				break;
			case 3 :
				System.out.println("enter the state");
				String state = utility.inputString();
				person.put("state", state);
				break;
			case 4:
				System.out.println("enter zip");
				String zip = utility.inputString();
				person.put("zip", zip);
				break;
			case 5 :
				System.out.println("enter phoneNumber");
				String phoneNumber = utility.inputString();
				person.put("phoneNumber", phoneNumber);
				break;
			case 6 : 
				System.out.println("enter address");
				String address = utility.inputStringLine();
				person.put("address", address);
				break;
			default:
				break;
			}
		}
		while(start < 7);
		jsonArray.set(index, person);
		jsonObject.put("address", jsonArray);
		printJsonObjectToFile("address.json", jsonObject);
		System.out.println("person detail edited");
	}
	else
	{
		System.out.println("person not persent");
	}
	
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to delete person detail persent in address.json file
 */
@SuppressWarnings("unchecked")
public static void delete() throws FileNotFoundException, IOException, ParseException
{
	System.out.println("enter the name of the person to be deleted");
	Utility utility = new Utility();
	String firstName = utility.inputString();
	int index = 0;
	JSONObject person = null;
	boolean present = false;
	
	JSONObject jsonObject = readFromJsonFile("address.json");
	JSONArray jsonArray = (JSONArray) jsonObject.get("address");
	for(int i = 0; i < jsonArray.size();i++)
	{
		 person = (JSONObject) jsonArray.get(i);
		String personFirstName = (String) person.get("firstName");
		if(personFirstName.equals(firstName))
		{
			index = i;
			present = true;
			break;
		}
	}
	if(present)
	{
		jsonArray.remove(index);
		jsonObject.put("address", jsonArray);
		printJsonObjectToFile("address.json", jsonObject);
		System.out.println("person detail deleted");
	}
	else
	{
		System.out.println("person not persent in address book");
	}
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to sort the person detail present address.json file by there name
 */
@SuppressWarnings("unchecked")
public static void sortByName() throws FileNotFoundException, IOException, ParseException
{
	JSONObject jsonObject = readFromJsonFile("address.json");
	JSONArray jsonArray = (JSONArray) jsonObject.get("address");
	JSONObject person1 = null;
	JSONObject person2 = null;
	String firstName1;
	String firstName2;
	
	for(int i = 0; i < jsonArray.size()-1;i++)
	{
		for(int j = i+1; j< jsonArray.size();j++)
		{
			person1 = (JSONObject) jsonArray.get(i);
			person2 = (JSONObject) jsonArray.get(j);
			firstName1 = (String) person1.get("firstName");
			firstName2 = (String) person2.get("firstName");
			if (firstName1.compareToIgnoreCase(firstName2) >0)
			{
				jsonArray.set(i, person2);
				jsonArray.set(j, person1);
			}
		}
	}
	jsonObject.put("address", jsonArray);
	printJsonObjectToFile("address.json", jsonObject);
	for(int i = 0; i < jsonArray.size(); i++)
	{
		System.out.println(jsonArray.get(i));
	}
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to sort the person detail by zip number in address.json file
 */
@SuppressWarnings("unchecked")
public static void sortByZip() throws FileNotFoundException, IOException, ParseException
{
	JSONObject jsonObject = readFromJsonFile("address.json");
	JSONArray jsonArray = (JSONArray) jsonObject.get("address");
	JSONObject person1 = null;
	JSONObject person2 = null;
	String zip1;
	String zip2;
	long intzip1;
	long intzip2;
	for(int i = 0; i < jsonArray.size()-1;i++)
	{
		for(int j = i+1; j< jsonArray.size();j++)
		{
			person1 = (JSONObject) jsonArray.get(i);
			person2 = (JSONObject) jsonArray.get(j);
			zip1 = (String) person1.get("zip");
			zip2 = (String) person2.get("zip");
			intzip1 = Long.parseLong(zip1);
			intzip2 = Long.parseLong(zip2);
			if(intzip1>intzip2)
			{
				jsonArray.set(i, person2);
				jsonArray.set(j, person1);
			}
		}
	}
	jsonObject.put("address", jsonArray);
	printJsonObjectToFile("address.json", jsonObject);
	for(int i = 0; i < jsonArray.size(); i++)
	{
		System.out.println(jsonArray.get(i));
	}
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to view all the content of  diffrent person present address.json file
 */
public static void displayAddressBook() throws FileNotFoundException, IOException, ParseException
{
	JSONObject jsonObject = readFromJsonFile("address.json");
	JSONArray jsonArray = (JSONArray) jsonObject.get("address");
	for(int i = 0; i < jsonArray.size(); i++)
	{
		System.out.println(jsonArray.get(i));
	}
	
}
/**
 * @return arraylist haveing four string[] array each storeing players of cards
 */
public static ArrayList<String[]> deckOfCards()
{
	String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	
	String[] player1 = new String[13];
	String[] player2 = new String[13];
	String[] player3 = new String[13];
	String[] player4 = new String[13];
	
	String[][] doubleCheck = new String[4][13];
	Random random = new Random();
	int min = 0;
	int row = 0;
	int colum = 0;
	int indexOfPlayer = 0;
	boolean player1Chance = true;
	boolean player2Chance = false;
	boolean player3Chance = false;
	boolean player4Chance = false;
	
	while(indexOfPlayer < 13)
	{
		while(player1Chance)
		{
			row = min + random.nextInt(4);
			colum = min + random.nextInt(13);
			if(doubleCheck[row][colum]== null)
			{
				player1[indexOfPlayer]=rank[colum] + " of " + suits[row];
				doubleCheck[row][colum] = "present";
				player2Chance = true;
				player1Chance = false;
			}
		}
		while(player2Chance)
		{
			row = min + random.nextInt(4);
			colum = min + random.nextInt(13);
			if(doubleCheck[row][colum] == null)
			{
				player2[indexOfPlayer] = rank[colum] + " of " + suits[row];
				doubleCheck[row][colum] = "present";
				player3Chance = true;
				player2Chance = false;
			}
		}
		while(player3Chance)
		{
			row = min + random.nextInt(4);
			colum = min + random.nextInt(13);
			if(doubleCheck[row][colum] == null)
			{
				player3[indexOfPlayer] = rank[colum] + " of " + suits[row];
				doubleCheck[row][colum] = "present";
				player4Chance = true;
				player3Chance = false;
			}
		}
		while(player4Chance)
		{
			row = min + random.nextInt(4);
			colum = min + random.nextInt(13);
			if(doubleCheck[row][colum] == null)
			{
				player4[indexOfPlayer++] = rank[colum] + " of " + suits[row];
				doubleCheck[row][colum] = "present";
				player1Chance = true;
				player4Chance = false;
			}
		}	
	}
	ArrayList<String[]> arrayList = new ArrayList<>();
	arrayList.add(player1);
	arrayList.add(player2);
	arrayList.add(player3);
	arrayList.add(player4);
	return arrayList;
 }
/**
 * @return return the array haveing cards of four player in sequence
 */
public static ArrayList<String[]> cardsInSequence()
{
	ArrayList<String[]> arrayList = deckOfCards();
	ArrayList<String[]> swapList = new ArrayList<>();
	int[][] cardsIndex = new int[4][13];
	for(int i = 0; i < 4; i++)
	{
		String[] array = arrayList.get(i);
		for(int j = 0; j < 13; j++)
		{
			String cards = array[j];
			String cardRank = cards.substring(0, cards.indexOf(" "));
			if(cardRank.equals("2"))
			{
				cardsIndex[i][j] = 2; 
			}
			else if(cardRank.equals("3"))
			{
				cardsIndex[i][j] = 3;
			}
			else if(cardRank.equals("4"))
			{
				cardsIndex[i][j] = 4;
			}
			else if(cardRank.equals("5"))
			{
				cardsIndex[i][j] = 5;
			}
			else if(cardRank.equals("6"))
			{
				cardsIndex[i][j] = 6;
			}
			else if(cardRank.equals("7"))
			{
				cardsIndex[i][j] = 7;
			}
			else if(cardRank.equals("8"))
			{
				cardsIndex[i][j] = 8;
			}
			else if(cardRank.equals("9"))
			{
				cardsIndex[i][j] = 9;
			}
			else if(cardRank.equals("10"))
			{
				cardsIndex[i][j] = 10;
			}
			else if(cardRank.equals("Jack"))
			{
				cardsIndex[i][j] = 11;
			}
			else if(cardRank.equals("Queen"))
			{
				cardsIndex[i][j] = 12;
			}
			else if(cardRank.equals("King"))
			{
				cardsIndex[i][j] = 13;
			}
			else
			{
				cardsIndex[i][j] = 1;
			}
		}
	}
	for(int k = 0; k< 4; k++)
	{
		String[] cardsOfPlayer = arrayList.get(k);
		for(int i = 0;i<12;i++)
		{
			for(int j = i +1; j < 13; j++)
			{
				if(cardsIndex[k][i]>cardsIndex[k][j])
				{
					int temp = cardsIndex[k][i];
					cardsIndex[k][i] = cardsIndex[k][j];
					cardsIndex[k][j] = temp;
					
					String temp1 = cardsOfPlayer[i];
					cardsOfPlayer[i] = cardsOfPlayer[j];
					cardsOfPlayer[j] = temp1;
				}
			}
		}
		swapList.add(cardsOfPlayer);
	}
return swapList;	
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to add docter detail in doctor.json file
 */
@SuppressWarnings("unchecked")
public static void addDoctor() throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
	JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
	boolean itrate = true;
	String id = null;
	boolean idPresent = false;
	
	while(itrate)
	{
		idPresent = false;
		System.out.println("enter the id of doctor");
	    id = utility.inputString();
		for(int i = 0; i < jsonArrayDoctor.size();i++)
		{
			JSONObject doctorObject = (JSONObject) jsonArrayDoctor.get(i);
			String doctorId = (String) doctorObject.get("id");
			if(doctorId.equals(id))
			{
				idPresent = true;
				System.out.println("this id is use by another doctor use diffrent one");
				break;
			}
		}
		if(!idPresent)
		{
			itrate = false;
		}
	}
	System.out.println("enter the name of doctor");
	String doctorName = utility.inputString();
	System.out.println("enter the specialization of doctor");
	String doctorSpecialization = utility.inputString();
	System.out.println("enter availability of doctor");
	System.out.println("you can only enter three choice");
	System.out.println("am if doctor is present in morning");
	System.out.println("pm if doctor is present in evening");
	System.out.println("both if doctor is present both the time");
	String availability = utility.inputString();
	JSONObject newDoctorObject = new JSONObject();
	
	JSONObject appointment = readFromJsonFile("appointment.json");
	appointment.put(id, new JSONObject());
	
	
	newDoctorObject.put("id", id);
	newDoctorObject.put("name", doctorName);
	newDoctorObject.put("specialization", doctorSpecialization);
	newDoctorObject.put("availability", availability);
	jsonArrayDoctor.add(newDoctorObject);
	jsonObjectDoctor.put("doctor", jsonArrayDoctor);
	printJsonObjectToFile("doctor.json", jsonObjectDoctor);
	printJsonObjectToFile("appointment.json", appointment);
	}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to add patient detail in patient.json file
 */
@SuppressWarnings("unchecked")
public static void addPatients() throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	JSONObject jsonObjectPatients = readFromJsonFile("patients.json");
	JSONArray jsonArraypatients = (JSONArray) jsonObjectPatients.get("patients");
	boolean itrate = true;
	String id = null;
	boolean idPresent = false;
	
	while(itrate)
	{
		idPresent = false;
		System.out.println("enter the id of patients");
	    id = utility.inputString();
		for(int i = 0; i < jsonArraypatients.size();i++)
		{
			JSONObject patientsObject = (JSONObject) jsonArraypatients.get(i);
			String patientsId = (String) patientsObject.get("id");
			if(patientsId.equals(id))
			{
				idPresent = true;
				System.out.println("this id is use by another patients use diffrent one");
				break;
			}
		}
		if(!idPresent)
		{
			itrate = false;
		}
	}
	System.out.println("enter the name of patients");
	String Name = utility.inputString();
	System.out.println("enter the mobil number of patients");
	String mobilNumber = utility.inputString();
	System.out.println("enter the age of patients");
	String age = utility.inputString();
	JSONObject newpatientsObject = new JSONObject();
	newpatientsObject.put("id", id);
	newpatientsObject.put("name", Name);
	newpatientsObject.put("mobilNumber", mobilNumber);
	newpatientsObject.put("age", age);
	jsonArraypatients.add(newpatientsObject);
	jsonObjectPatients.put("patients", jsonArraypatients);
	printJsonObjectToFile("patients.json", jsonObjectPatients);	
}
/**
 * @param pateint
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to serch doctor by name or id or specialization and book them if wanted and updateing 
 * appointment.json file
 */
public static void serachAndbookdoctor(JSONObject pateint) throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	System.out.println("enter 1 to serch doctor by name");
	System.out.println("enter 2 to serch doctor by id");
	System.out.println("enter 3 to serch doctor by specialization");
	int choise = utility.inputInteger();
	switch (choise) 
	{
	case 1:
	System.out.println("enter the name of the doctor");	
	serachDoctorByName(utility.inputString(),pateint);
		break;
	case 2:
		System.out.println("enter the id of doctor");
		serachDoctorById(utility.inputString(), pateint);
		break;
	case 3:
		System.out.println("enter the specilization of doctor");
		serachDoctorBySpecialization(utility.inputString(), pateint);
		break;

	default:
		break;
	}
}
/**
 * @param doctorSpecialization = string argument to take doctor Specialization
 * @param pateint = json object argument to keep track which patient is serching the doctor
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static void serachDoctorBySpecialization(String doctorSpecialization,JSONObject pateint) throws FileNotFoundException, IOException, ParseException
{
	ArrayList<JSONObject> doctorList = new ArrayList<>();
	Utility utility = new Utility();
	JSONObject doctor = null;
	boolean doctorPresent = false;
	JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
	JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
	for(int i = 0; i < jsonArrayDoctor.size();i++)
	{
	    doctor = (JSONObject) jsonArrayDoctor.get(i);
		String specialization = (String) doctor.get("specialization");
		if(specialization.equals(doctorSpecialization))
		{
			doctorPresent = true;
			doctorList.add(doctor);
		}	
	}
	if(doctorPresent)
	{
		System.out.println("list of doctor for " + doctorSpecialization);
		for(int i = 0; i< doctorList.size();i++)
		{
			System.out.println(doctorList.get(i));
		}
		System.out.println("enter the id of one doctor from above list");
		String doctorId = utility.inputString();
		System.out.println("enter 1 to see doctor is avalable on specific date or not");
		System.out.println("or any thing else to go back");
		int chosie = utility.inputInteger();
		switch (chosie) 
		{
		case 1:
			checkavalbilityOfdocterbyId(doctorId,pateint);
			break;
		default:
			break;
		}
	}
	else
	{
		System.out.println("the doctor you serched is not avaliable");
	}
}

/**
 * @param doctorId = string argument to take id of docter which is to be serched
 * @param pateint = json object of patient who is serching the doctor
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static void serachDoctorById(String doctorId,JSONObject pateint) throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	JSONObject doctor = null;
	boolean doctorPresent = false;
	JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
	JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
	for(int i = 0; i < jsonArrayDoctor.size();i++)
	{
	    doctor = (JSONObject) jsonArrayDoctor.get(i);
		String id = (String) doctor.get("id");
		if(id.equals(doctorId))
		{
			doctorPresent = true;
			break;
		}	
	}
	if(doctorPresent)
	{
		System.out.println(doctor);
		System.out.println();
		System.out.println("enter 1 to see doctor is avalable on specific date or not");
		System.out.println("or any thing else to go back");
		int chosie = utility.inputInteger();
		switch (chosie) 
		{
		case 1:
			checkavalbilityOfdocterbyId(doctorId,pateint);
			break;
		default:
			break;
		}
	}
	else
	{
		System.out.println("the doctor you serched is not avaliable");
	}
}
/**
 * @param doctorName = string argument to take docter name which is been serched
 * @param pateint = json object of patient who is serching docter
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static void serachDoctorByName(String doctorName,JSONObject pateint) throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	JSONObject doctor = null;
	boolean doctorPresent = false;
	JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
	JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
	for(int i = 0; i < jsonArrayDoctor.size();i++)
	{
	    doctor = (JSONObject) jsonArrayDoctor.get(i);
		String name = (String) doctor.get("name");
		if(name.equals(doctorName))
		{
			doctorPresent = true;
			break;
		}	
	}
	if(doctorPresent)
	{
		String doctorId = (String) doctor.get("id");
		System.out.println(doctor);
		System.out.println();
		System.out.println("enter 1 to see doctor is avalable on specific date or not");
		System.out.println("or any thing else to go back");
		int chosie = utility.inputInteger();
		switch (chosie) 
		{
		case 1:
			checkavalbilityOfdocterbyId(doctorId,pateint);
			break;

		default:
			break;
		}
	}
	else
	{
		System.out.println("the doctor you serched is not avaliable");
	}
}
/**
 * @param id = to take doctor id
 * @param patient = json object of patient who is serching the doctor
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
@SuppressWarnings("unchecked")
static void checkavalbilityOfdocterbyId(String id,JSONObject patient) throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	System.out.println("enter the date in format of DDMMYYYY");
	String date = utility.inputString();
	JSONObject jsonObjectappointment = readFromJsonFile("appointment.json");
	JSONObject jsonObjectforId = (JSONObject) jsonObjectappointment.get(id);
	if(jsonObjectforId.get(date) == null)
	{
		System.out.println("doctor is available enter 1 to book on that date");
		int choise = utility.inputInteger();
		switch (choise) 
		{
		case 1:
			JSONArray patentarray = new JSONArray();
			patentarray.add(patient);
			jsonObjectforId.put(date, patentarray);
			jsonObjectappointment.put(id, jsonObjectforId);
			printJsonObjectToFile("appointment.json", jsonObjectappointment);
			System.out.println("your appointment is fixed");
			break;
		default:
			break;
		}
	}
	else
	{
		JSONArray oldpatientarray = (JSONArray) jsonObjectforId.get(date);
		if(oldpatientarray.size()<5)
		{
			System.out.println("doctor avalable on that day enter 1 to book on that day");
			System.out.println("or enter any other number to go back");
			int choise = utility.inputInteger();
			switch (choise) 
			{
			case 1:
				oldpatientarray.add(patient);
				jsonObjectforId.put(date, oldpatientarray);
				jsonObjectappointment.put(id, jsonObjectforId);
				printJsonObjectToFile("appointment.json", jsonObjectappointment);
				System.out.println("your appointment is fixed");
				break;

			default:
				break;
			}
		}
		else
		{
			System.out.println("doctor is booked on that date try different date");
		}
	}
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to serch patient by name ,id ,mobil number
 */
public static void searchPatient() throws FileNotFoundException, IOException, ParseException
{
	ArrayList<JSONObject> arrayListPatient = new ArrayList<>();
	boolean patientPresent = false;
	JSONObject jsonObjectpatient = readFromJsonFile("patients.json");
	JSONArray jsonArraypatient = (JSONArray) jsonObjectpatient.get("patients");
	Utility utility = new Utility();
	JSONObject patient = null;
	System.out.println("enter 1 to serch patient by name");
	System.out.println("enter 2 to serch patient by id");
	System.out.println("enter 3 to serach patient by mobil number");
	int choise = utility.inputInteger();
	switch (choise) {
	case 1:
		System.out.println("enter the patient name");
		String name = utility.inputString();
		for(int i = 0; i < jsonArraypatient.size();i++)
		{
			patient = (JSONObject) jsonArraypatient.get(i);
			String patientName = (String) patient.get("name");
			if(name.equals(patientName))
			{
				patientPresent = true;
				arrayListPatient.add(patient);
			}
		}
		if(patientPresent)
		{
			System.out.println("patient of name " + name);
			for(int i =0; i < arrayListPatient.size();i++)
			{
				System.out.println(arrayListPatient.get(i));
			}
		}
		else
		{
			System.out.println("patient with name = "+name+"dont exist" );
		}
		break;
	case 2:
		System.out.println("enter the patient id");
		String id = utility.inputString();
		for(int i = 0; i < jsonArraypatient.size();i++)
		{
			patient = (JSONObject)  jsonArraypatient.get(i);
			String patientid = (String) patient.get("id");
			if(id.equals(patientid))
			{
				patientPresent = true;
				break;
			}
		}
		if(patientPresent)
		{
			System.out.println(patient);
		}
		else
		{
			System.out.println("patient with id = "+id + "not exist");
		}
		break;
	case 3:
		System.out.println("enter the patient mobil number");
		String mobilNumber = utility.inputString();
		for(int i = 0;i<jsonArraypatient.size();i++)
		{
			patient = (JSONObject) jsonArraypatient.get(i);
			String patientMobilNumber = (String) patient.get("mobilNumber");
			if(mobilNumber.equals(patientMobilNumber))
			{
				patientPresent = true;
				arrayListPatient.add(patient);
			}
		}
		if(patientPresent)
		{
			for(int i = 0; i < arrayListPatient.size();i++)
			{
				System.out.println(arrayListPatient.get(i));
			}
		}
		else
		{
			System.out.println("patient with mobil number = " + mobilNumber + "not present");
		}
	default:
		break;
	}
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to  find the best doctor in clinique
 */
@SuppressWarnings("rawtypes")
public static void bestDoctor() throws FileNotFoundException, IOException, ParseException
{
	HashMap<String, Integer> doctorsPatientCount = new HashMap<>();
	JSONObject jsonObjectappointment = readFromJsonFile("appointment.json");
	Set keyOfappointment = jsonObjectappointment.keySet();
	Iterator iter = keyOfappointment.iterator();
	while(iter.hasNext())
	{
		int countOfPatient = 0;
		String idOfDoctor = (String) iter.next();
		JSONObject jsonObjectOfId = (JSONObject) jsonObjectappointment.get(idOfDoctor);
		if(jsonObjectOfId.isEmpty())
		{
			countOfPatient = 0;
		}
		else
		{
			Set keyOfDate = jsonObjectOfId.keySet();
			Iterator iter1 = keyOfDate.iterator();
			while(iter1.hasNext())
			{
				String date = (String) iter1.next();
				JSONArray jsonArrayDate = (JSONArray) jsonObjectOfId.get(date);
				countOfPatient +=jsonArrayDate.size();
			}
		}
		doctorsPatientCount.put(idOfDoctor, countOfPatient);
	}
	
	String maxKey = "";
	 int maxValueInMap=(Collections.max(doctorsPatientCount.values()));
	 for (Entry<String, Integer> entry : doctorsPatientCount.entrySet()) 
	 {
         if (entry.getValue()==maxValueInMap) 
         {
        	 maxKey = entry.getKey();
         }
	 }
	 JSONObject bestdoctoerDetails = getDocterDetailsById(maxKey);
	 System.out.println("best doctor of clinice details");
	 System.out.println(bestdoctoerDetails);
}
/**
 * @param doctorId = to take doctor to be serched id as string
 * @return json object of docter detail if found else return null
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static JSONObject getDocterDetailsById(String doctorId) throws FileNotFoundException, IOException, ParseException
{
	JSONObject doctor = null;
	JSONObject jsonObjectDoctor = readFromJsonFile("doctor.json");
	JSONArray jsonArrayDoctor = (JSONArray) jsonObjectDoctor.get("doctor");
	for(int i = 0; i < jsonArrayDoctor.size();i++)
	{
	    doctor = (JSONObject) jsonArrayDoctor.get(i);
		String id = (String) doctor.get("id");
		if(id.equals(doctorId))
		{
			return doctor;
		}	
	}
	return null;
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to print the docter detail along with the patient detail associated with it
 */
@SuppressWarnings("rawtypes")
public static void doctorPatientList() throws FileNotFoundException, IOException, ParseException
{
	JSONObject jsonObjectappointment = readFromJsonFile("appointment.json");
	Set keyOfappointment = jsonObjectappointment.keySet();
	Iterator iter = keyOfappointment.iterator();
	while(iter.hasNext())
	{
		String idOfDoctor = (String) iter.next();
		System.out.println("doctor details");
		System.out.println(getDocterDetailsById(idOfDoctor));
		System.out.println("------------------------------");
		System.out.println("patient details");
		JSONObject jsonObjectOfId = (JSONObject) jsonObjectappointment.get(idOfDoctor);
		if(jsonObjectOfId.isEmpty())
		{
			System.out.println("have no patient associated with them");
			
		}
		else
		{
			Set keyOfDate = jsonObjectOfId.keySet();
			Iterator iter1 = keyOfDate.iterator();
			
			System.out.println("have following patient associated to it");
			while(iter1.hasNext())
			{
				String date = (String) iter1.next();
				JSONArray jsonArrayDate = (JSONArray) jsonObjectOfId.get(date);
				for(int i = 0; i < jsonArrayDate.size();i++)
				{
					System.out.println(jsonArrayDate.get(i));
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("==============================");
	}
}
/**
 * @param date = to take argument as date
 * @return = present date in proper format
 */
public String getFormatedDate(Date date)
{
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	return sdf.format(date);
}

/**
 * @param userDetails = object stroeing all details of user
 * @param message = to string from file
 * @return new string upadated
 */
public String convertString(UserDetails userDetails,String message)
{
	Pattern p = Pattern.compile(PredefineData.NAME);
   		Matcher m = p.matcher(message); 
   		message = m.replaceAll(userDetails.getFirstName());

	p = Pattern.compile(PredefineData.FULLNAME);
	m = p.matcher(message); 
	message = m.replaceAll(userDetails.getFirstName()+" "+userDetails.getLastName());

	p = Pattern.compile(PredefineData.MOBILE_NO);
	m = p.matcher(message); 
	message = m.replaceAll(userDetails.getMobileNo());

	p = Pattern.compile(PredefineData.DATE);
	m = p.matcher(message); 
	message = m.replaceAll(userDetails.getDate());

	return message;
}
public String getFileText(String fileName){
	BufferedReader br=null;
	try{

		br = new BufferedReader(new FileReader(fileName));
		StringBuilder sb=new StringBuilder();
		String line=br.readLine();
		while(line!=null){
			sb.append(line);
			sb.append(System.lineSeparator());
			line=br.readLine();
		}
		return sb.toString();
	 }
	catch(Exception exception){
		return null;
	}
	finally {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * @return linkedlist haveing details of share company
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static java.util.LinkedList<JSONObject> addCompanytoList() throws FileNotFoundException, IOException, ParseException
{
	JSONObject jsonObjectshare = readFromJsonFile("share.json");
	JSONArray jsonArrayShare = (JSONArray) jsonObjectshare.get("share");
	java.util.LinkedList<JSONObject> linkedList = new java.util.LinkedList<>();
	for(int i = 0; i < jsonArrayShare.size();i++)
	{
		linkedList.add((JSONObject) jsonArrayShare.get(i));
	}
	return linkedList;
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * add share company in share.json file
 */
@SuppressWarnings("unchecked")
public static void addShareCompany() throws FileNotFoundException, IOException, ParseException
{
	String shareSymbol = "";
	
	boolean itrate = true;
	Utility utility = new Utility();
	JSONObject jsonObjectshare = readFromJsonFile("share.json");
	JSONArray jsonArrayShare = (JSONArray) jsonObjectshare.get("share");
	while(itrate)
	{
		boolean sharePresent = false;
		System.out.println("enter the symbol of share company");
	    shareSymbol = utility.inputString();
		for(int i = 0 ; i < jsonArrayShare.size();i++)
		{
			JSONObject jsonObjectParticularShare = (JSONObject) jsonArrayShare.get(i);
			String symbol = (String) jsonObjectParticularShare.get("shareSymbol");
			if(symbol.equals(shareSymbol))
			{
				sharePresent = true;
				break;
			}
		}
		if(sharePresent)
		{
			System.out.println("enter diffrent symbol this symbol is already used by diffrent company");
		}
		else
		{
			itrate = false;
		}
	}
	System.out.println("enter number of share company have");
	String numberOfShare = utility.inputString();
	System.out.println("enter price of each share");
	String sharePrice = utility.inputString();
	System.out.println("enter amount share company have");
	String amount = utility.inputString();
	JSONObject newShareJsonObject = new JSONObject();
	newShareJsonObject.put("numberOfShare", numberOfShare);
	newShareJsonObject.put("amount", amount);
	newShareJsonObject.put("price", sharePrice);
	newShareJsonObject.put("shareSymbol", shareSymbol);
	jsonArrayShare.add(newShareJsonObject);
	jsonObjectshare.put("share", jsonArrayShare);
	printJsonObjectToFile("share.json", jsonObjectshare);
	System.out.println("share company added succes");
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * to delete share company in share.json file
 */
@SuppressWarnings("unchecked")
public static void deleteShareCompany() throws FileNotFoundException, IOException, ParseException
{
	int index = 0;
	boolean sharePresent = false;
	Utility utility = new Utility();
	JSONObject jsonObjectshare = readFromJsonFile("share.json");
	JSONArray jsonArrayShare = (JSONArray) jsonObjectshare.get("share");
	System.out.println("enter the symbol of share company which you want to delete");
	String shareSymbol = utility.inputString();
	for(int i = 0; i < jsonArrayShare.size(); i++)
	{
		JSONObject jsonObjectParticularShare = (JSONObject) jsonArrayShare.get(i);
		String symbol = (String) jsonObjectParticularShare.get("shareSymbol");
		if(symbol.equals(shareSymbol))
		{
			sharePresent = true;
			index  = i;
			break;
		}
	}
	if(sharePresent)
	{
		jsonArrayShare.remove(index);
		jsonObjectshare.put("share", jsonArrayShare);
		printJsonObjectToFile("share.json", jsonObjectshare);
		System.out.println("share company deleted succes");
	}
	else
	{
		System.out.println("no share symbol present as = " + shareSymbol);
	}
}
/**
 * @return linkedList haveing details of share company
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static java.util.LinkedList<JSONObject> shareTransectionInList() throws FileNotFoundException, IOException, ParseException
{
	java.util.LinkedList<JSONObject> linkedList = new java.util.LinkedList<>();
	
	JSONObject jsonObjectShareSellBuy = Utility.readFromJsonFile("shareSellBuy.json");
	JSONArray shareSellBuyArray = (JSONArray) jsonObjectShareSellBuy.get("transaction");
	
	for(int i = 0; i <  shareSellBuyArray.size();i++)
	{
		JSONObject transection = (JSONObject) shareSellBuyArray.get(i);
		linkedList.add(transection);
	}
	return linkedList;
}
/**
 * @return queue Of json object haveing transection detail
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * 
 */
public static java.util.Queue<JSONObject> shareTransectionInQueue() throws FileNotFoundException, IOException, ParseException
{
	Queue<JSONObject> queue = new java.util.LinkedList<>();
	
	JSONObject jsonObjectShareSellBuy = Utility.readFromJsonFile("shareSellBuy.json");
	JSONArray shareSellBuyArray = (JSONArray) jsonObjectShareSellBuy.get("transaction");
	for(int i = 0; i < shareSellBuyArray.size();i++)	
	{
		JSONObject transection = (JSONObject) shareSellBuyArray.get(i);
		queue.add(transection);
	}
	return queue;
}
/**
 * @param fileName
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * insert json object haveing stock detail in file
 */
@SuppressWarnings("unchecked")
public static void stockAccount(String fileName) throws FileNotFoundException, IOException, ParseException
{
	int totalShare = 0;
	Utility utility = new Utility();
	Map<String, String> stockMap = new LinkedHashMap<>();
	JSONObject jsonObject = Utility.readFromJsonFile(fileName);
	JSONArray jsonArray = (JSONArray) jsonObject.get("user");
	System.out.println("enter the stock name");
	String stockName = utility.inputString();
	stockMap.put("stockName", stockName);
	System.out.println("enter how many compony you want to enter");
	int numberOfCompany = utility.inputInteger();
	for(int i = 0 ; i < numberOfCompany; i++)
	{
		System.out.println("enter the company symbol");
		String symbol = utility.inputString();
		System.out.println("enter number of share");
		int numberOfShare = utility.inputInteger();
		String numberOfShareString = Integer.toString(numberOfShare);
		stockMap.put(symbol, numberOfShareString);
		totalShare += numberOfShare;
	}
	String totalShareString = Integer.toString(totalShare);
	stockMap.put("totalShare", totalShareString);
	
	System.out.println("enter the total amount stock have");
	double amount = utility.inputDouble();
	String amountString = Double.toString(amount);
	stockMap.put("amount", amountString);
	jsonArray.add(stockMap);

	jsonObject.put("user", jsonArray);
	PrintWriter printWriter = new PrintWriter(fileName);
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();
	System.out.println(printDate());
}
/**
 * @param useramountEnter = for which amount user has to buy share
 * @param symbol = which share we want to buy
 * @param stockMap = Map haveing details of stock which wants to buy share
 * @return upade detail after buy opration of stock
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public static Map buy(double useramountEnter,String symbol,Map stockMap) throws FileNotFoundException, IOException, ParseException
{
	boolean present = false;
	int index=0;
	Map shareMap = new LinkedHashMap<>();
	JSONObject jsonObject = Utility.readFromJsonFile("share.json");
	JSONArray jsonArrayShare = (JSONArray) jsonObject.get("share");
	
	for(int i = 0; i < jsonArrayShare.size();i++ )
	{
		shareMap = (Map) jsonArrayShare.get(i);
		if(shareMap.containsValue(symbol))
		{
			index = i;
			present = true;
			break;
		}
	}
	if(present)
	{
		int numberOfShareOfSymbol = 0;
		if(stockMap.get(symbol)!= null)
		{
		String numberOfShareOfSymbolString = (String) stockMap.get(symbol);
		numberOfShareOfSymbol = Integer.parseInt(numberOfShareOfSymbolString);
		}

		String totalShareOfStockString = (String) stockMap.get("totalShare");
		int totalshareOfStock = Integer.parseInt(totalShareOfStockString);
		String amountOfStockString = (String) stockMap.get("amount");
		double amountOfStock = Double.parseDouble(amountOfStockString);
		
		String shareAmountString = (String) shareMap.get("amount");
		String shareNumberString = (String) shareMap.get("numberOfShare");
		String sharePriceString = (String) shareMap.get("price");
		
		double shareTotalAmount = Double.parseDouble(shareAmountString);
		int numberOfShare = Integer.parseInt(shareNumberString);
		double sharePrice = Double.parseDouble(sharePriceString);
		
		double amountOfTransection;
		if(useramountEnter% sharePrice == 0)
		{
			amountOfTransection = useramountEnter;
		}
		else
		{
			amountOfTransection = useramountEnter - (useramountEnter%sharePrice);
		}
		int numberOfShareToBuy = (int)(amountOfTransection / sharePrice);
		
		if(amountOfStock>=amountOfTransection)
		{
			if(numberOfShare>=numberOfShareToBuy)
			{
				double newStockAmount = amountOfStock - amountOfTransection;
				int newShareOfStock = totalshareOfStock + numberOfShareToBuy;
				int newShareOfSymbol = numberOfShareOfSymbol + numberOfShareToBuy;
				
				 
				double newShareAmount = shareTotalAmount + amountOfTransection;
				int newNumberOfshare = numberOfShare - numberOfShareToBuy;
			
				String newShareAmountString = Double.toString(newShareAmount);
				String newNumberOfShareString = Integer.toString(newNumberOfshare);
									
				JSONObject jsonObjectShare = new JSONObject();
				shareMap.put("amount",newShareAmountString);
				shareMap.put("numberOfShare", newNumberOfShareString);
				jsonArrayShare.set(index, shareMap);
				jsonObjectShare.put("share", jsonArrayShare);
				Utility.printJsonObjectToFile("share.json", jsonObjectShare);

				String newStockAmountString = Double.toString(newStockAmount);
				String newShareOfStockString = Integer.toString(newShareOfStock);
				String newShareOfSymbolString = Integer.toString(newShareOfSymbol);
				
				
				stockMap.put("amount", newStockAmountString);
				stockMap.put("totalShare", newShareOfStockString);
				stockMap.put(symbol, newShareOfSymbolString);
				
				JSONObject jsonObjectShareSellBuy = Utility.readFromJsonFile("shareSellBuy.json");
				JSONArray shareSellBuyArray = (JSONArray) jsonObjectShareSellBuy.get("transaction");
				
				JSONObject newjsonObjectSellBuy = new JSONObject();
				
				String stockName = (String) stockMap.get("stockName");
				String numberOfShareToBuyString = Integer.toString(numberOfShareToBuy);
		
				newjsonObjectSellBuy.put("shareSymbol", symbol);
				newjsonObjectSellBuy.put("numberOfShareTransection",numberOfShareToBuyString);
				newjsonObjectSellBuy.put("buyOrSell", "buy");
				newjsonObjectSellBuy.put("dateTime", printDate());
				newjsonObjectSellBuy.put("stockName", stockName);
				
				shareSellBuyArray.add(newjsonObjectSellBuy);
				jsonObjectShareSellBuy.put("transaction", shareSellBuyArray);
				
				Utility.printJsonObjectToFile("shareSellBuy.json", jsonObjectShareSellBuy);
			
				return stockMap;
			}
			else
			{
				System.out.println("number of share avalable for sell are " + numberOfShare);
			}
		}
		else
		{
			System.out.println("you dont have total amount");
		}	
	}
	else
	{
		System.out.println("share not avalable for sale");
	}
	return stockMap;
}
/**
 * @param stockMap = stock details which wants to sell share
 * @return update details of stock
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public static Map sell(Map stockMap) throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	boolean present = false;
	int index=0;
	Map shareMap = new LinkedHashMap<>();
	JSONObject jsonObject = Utility.readFromJsonFile("share.json");
	JSONArray jsonArrayShare = (JSONArray) jsonObject.get("share");
	System.out.println("enter share symbol which you want to sell");
	String symbol = utility.inputString();
	System.out.println("enter number share you want to sell");
	int numberOfShareToBeSell = utility.inputInteger();
	
	for(int i = 0; i < jsonArrayShare.size();i++ )
	{
		shareMap = (Map) jsonArrayShare.get(i);
		if(shareMap.containsValue(symbol))
		{
			index = i;
			present = true;
			break;
		}
	}
	if(present)
	{
		String numberOfShareOfSymbolString = (String) stockMap.get(symbol);
		String totalNumberOfShareOfStockString = (String) stockMap.get("totalShare");
		String amountOfStockString = (String) stockMap.get("amount");
		
		String totalShareOfCompanyString = (String) shareMap.get("numberOfShare");
		String amountOfCompanyString = (String) shareMap.get("amount");
		String sharePriceString = (String) shareMap.get("price");
		
		int numberOfShareOfSymbol = Integer.parseInt(numberOfShareOfSymbolString);
		int totalNumberOfShareOfStock = Integer.parseInt(totalNumberOfShareOfStockString);
		double amountOfStock = Double.parseDouble(amountOfStockString);
		 
		int totalShareOfCompany = Integer.parseInt(totalShareOfCompanyString);
		double amountOfCompany = Double.parseDouble(amountOfCompanyString);
		double priceOfShare = Double.parseDouble(sharePriceString);
				
		if(numberOfShareToBeSell<=numberOfShareOfSymbol)
		{ 
			int newNumberOfShareOfSysmbol = numberOfShareOfSymbol - numberOfShareToBeSell;
			double transectionAmount = priceOfShare *(double) numberOfShareToBeSell;
			double newAmountOfStock = amountOfStock + transectionAmount;
			int newTotalNumberOfShareOfStock = totalNumberOfShareOfStock - numberOfShareToBeSell;
			
			int newTotalshareOfCompany = totalShareOfCompany + numberOfShareToBeSell;
			double newAmountOfCompany = amountOfCompany - transectionAmount;
			
			String newNumberOfShareOfSymbolString = Integer.toString(newNumberOfShareOfSysmbol);
			String newAmountOfStockString = Double.toString(newAmountOfStock);
			String newTotalNumberOfShareOfStockString = Integer.toString(newTotalNumberOfShareOfStock);
			
			String newTotalShareOfCompanyString = Integer.toString(newTotalshareOfCompany);
			String newAmountOfCompanyString = Double.toString(newAmountOfCompany);
			
			stockMap.put(symbol, newNumberOfShareOfSymbolString);
			stockMap.put("amount", newAmountOfStockString);
			stockMap.put("totalShare", newTotalNumberOfShareOfStockString);
			
			shareMap.put("numberOfShare", newTotalShareOfCompanyString);
			shareMap.put("amount", newAmountOfCompanyString);
			
			jsonArrayShare.set(index, shareMap);
			JSONObject newjsonObjectShare = new JSONObject();
			newjsonObjectShare.put("share", jsonArrayShare);
			
			Utility.printJsonObjectToFile("share.json", newjsonObjectShare);	
			
			
			JSONObject jsonObjectShareSellBuy = Utility.readFromJsonFile("shareSellBuy.json");
			JSONArray shareSellBuyArray = (JSONArray) jsonObjectShareSellBuy.get("transaction");
			
			JSONObject newjsonObjectSellBuy = new JSONObject();
			
			String stockName = (String) stockMap.get("stockName");
			String numberOfShareToBeSellString = Integer.toString(numberOfShareToBeSell);
			
			
			
			newjsonObjectSellBuy.put("stockName", stockName);
			newjsonObjectSellBuy.put("shareSymbol", symbol);
			newjsonObjectSellBuy.put("buyOrSell", "sell");
			newjsonObjectSellBuy.put("dateTime", printDate());
			newjsonObjectSellBuy.put("numberOfShareTransection",numberOfShareToBeSellString);
			shareSellBuyArray.add(newjsonObjectSellBuy);
			
			jsonObjectShareSellBuy.put("transaction", shareSellBuyArray);
			
			
			
			Utility.printJsonObjectToFile("shareSellBuy.json", jsonObjectShareSellBuy);
			
			
			
			
		}
		else
		{
			System.out.println("you dont have that much share to sell");
		}	
	}
	else
	{
		System.out.println("company not present to purches that share");
	}	
	return stockMap;
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * print the details of diffrent stock
 */
@SuppressWarnings("rawtypes")
public static void printReport() throws FileNotFoundException, IOException, ParseException
{
	JSONObject jsonObjectstock = Utility.readFromJsonFile("stockAccount.json");
	JSONArray jsonArray = (JSONArray) jsonObjectstock.get("user");
	for(int i = 0; i < jsonArray.size();i++)
	{
		Map stockMap = (Map) jsonArray.get(i);
		System.out.println(stockMap);	
	}
}
/**
 * @return return the object of current date and time
 */
public static String printDate()
{
	Date date = new Date();
	String d = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(date);
	return d;
}
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * manage stock sell and buy details
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public static void stockAccountController() throws FileNotFoundException, IOException, ParseException
{
	Utility utility = new Utility();
	int start;
	do
	{
	System.out.println("enter your choise");
    System.out.println("enter 1 to create stockAount");
	System.out.println("enter 2 to buy share");
	System.out.println("enter 3 to sell share");
	System.out.println("enter 4 to print report");
	System.out.println("enter 5 to exist");
	int choise = utility.inputInteger();
	start = choise;
	switch (choise) 
	{
	case 1:
		stockAccount("stockAccount.json");
		break;
		case 2 :
			boolean present = false;
			int index = 0;
			Map userMap = new LinkedHashMap<>();
			System.out.println("enter stock name for which you want to buy share");
			String stockName = utility.inputString();
			JSONObject jsonObjectuser = Utility.readFromJsonFile("stockAccount.json");
			JSONArray jsonArrayuser = (JSONArray) jsonObjectuser.get("user");
			for(int i = 0; i < jsonArrayuser.size();i++)
			{
				userMap = (Map) jsonArrayuser.get(i);
				if(userMap.containsValue(stockName))
				{
					index = i;
					present = true;
					break;
				}
			}
			if(present)
			{
				System.out.println("you can buy following share at specific rate");
				java.util.LinkedList<JSONObject> linkedList = Utility.addCompanytoList();
				for(int i = 0; i < linkedList.size();i++)
				{
					JSONObject jsonObjectOfShare = linkedList.get(i);
					String shareSysmbol = (String) jsonObjectOfShare.get("shareSymbol");
					String Shareprice = (String) jsonObjectOfShare.get("price");
					System.out.println(shareSysmbol +" at price of " + Shareprice +" per share");
				}
				String symbol = utility.inputString();
				System.out.println("enter the total amount you want to spent to buy share");
				double amount = utility.inputDouble();
				Map stockMap =buy(amount, symbol, userMap);
				
	
				JSONObject jsonObjectStock = new JSONObject();
				jsonArrayuser.set(index, stockMap);
				jsonObjectStock.put("user", jsonArrayuser);
				
				Utility.printJsonObjectToFile("stockAccount.json", jsonObjectStock);
				
				
			}
			else
			{
				System.out.println("stock not exist");
				
			}
			break;
		case 3 :
			boolean present3 = false;
			int index3 = 0;
			Map userMap3 = new LinkedHashMap<>();
			System.out.println("enter stock name for which you want to sell share");
			String stockName3 = utility.inputString();
			JSONObject jsonObjectuser3 = Utility.readFromJsonFile("stockAccount.json");
			JSONArray jsonArrayuser3 = (JSONArray) jsonObjectuser3.get("user");
			for(int i = 0; i < jsonArrayuser3.size();i++)
			{
				userMap3 = (Map) jsonArrayuser3.get(i);
				if(userMap3.containsValue(stockName3))
				{
					index3 = i;
					present3 = true;
					break;
				}
			}
			if(present3)
			{
			Map newUserMap =	sell(userMap3);
			jsonArrayuser3.set(index3, newUserMap);
			JSONObject jsonObjectnew = new JSONObject();
			jsonObjectnew.put("user", jsonArrayuser3);
			Utility.printJsonObjectToFile("stockAccount.json", jsonObjectnew);
			
				printDate();
			}
			else
			{
				System.out.println("stock not exist");
			}
			break;
		case 4:
			
			printReport();
			System.out.println(printDate());
			break;
	default:
		break;
	}
	}
	while(start < 5);
}
/**
 * control the function of bancking system
 */
public static void bankController()
{
	com.bridgeit.dataStructure.Queue queue = new com.bridgeit.dataStructure.Queue();
	Utility utility = new Utility();
	System.out.println("enter the max number of person to be served");
	int maxPerson = utility.inputInteger();
	int numberOfPersonEntered = 0;
	System.out.println("the money bank had");
	int bankbalance = utility.inputInteger();
	
	while(numberOfPersonEntered != maxPerson)
	{
		System.out.println("person enter the bank");
		System.out.println("enter the name of person");
		String name = utility.inputString();
		System.out.println("enter the amount he had");
		int amount  = utility.inputInteger();
		System.out.println("person enter the queue");
		queue.enqueue(new Person(name, amount));
		numberOfPersonEntered++;
	}
	while(!(queue.isEmpty()))
			{
		Person person = queue.dequeue();
		System.out.println("enter 1 to deposit money and 2 to withdraw moeny");
		int choice = utility.inputInteger();
		switch (choice) {
		case 1:
			System.out.println("enter the money amount to be deposit");
			int amount = utility.inputInteger();
			if(person.moneyHehad >= amount)
			{
				person.moneyHehad -= amount;
				bankbalance+=amount;
			}
			else
			{
				System.out.println("insuffcent aumont with " + person.Name);
			}
			break;
           case 2:
        	   System.out.println("enter the amount to be withdraw");
        	   int withdrawMoney = utility.inputInteger();
        	   if(bankbalance >= withdrawMoney)
        	   {
        		   bankbalance -= withdrawMoney;
        		   person.moneyHehad +=withdrawMoney;
        	   }
        	   else
        	   {
        		   System.out.println("bank have insuffcent fund for your request come tommorow");
        	   }
			
			break;

		default:
			break;
		}
		System.out.println("person servered detail");
		System.out.println(person.Name + "----" + person.moneyHehad);
	}
}
/**
 * print the month calender by takeing user input
 * with help of queue 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public static void calenderWithQueueControler()
{
	Utility utility = new Utility();
	System.out.println("enter the month");
	int month = utility.inputInteger();
	System.out.println("enter the year");
	int year = utility.inputInteger();
	int start = Utility.dayOfMonthStarting(month, year);
	java.util.Queue week  = new java.util.LinkedList<>();
	int maxDay = Utility.maxDays(month, year);
	int numberOfObject;
	int date = 0;
	if (maxDay + start > 35) {
		numberOfObject = 6;
	}
	else 
	{
		numberOfObject = 5;
	}
	for (int i = 0; i < numberOfObject; i++) {
		week.add(new java.util.LinkedList<>());
	}
	for (int i = 0; i < numberOfObject; i++) {
		Queue queue = (Queue) week.poll();
		if (i == 0) {
			for (int j = 0; j < start; j++)
			{
				queue.add(" ");
			}
			for(int j = start;j<7;j++)
			{
				queue.add(++date);
			}
		}
		else
		{
			for(int j = 0; j <7;j++)
			{
				queue.add(++date);
				if(date == maxDay)
				{
					break;
				}
			}
		}
		week.add(queue);
	}
	System.out.println("SUN"+"\t"+"M"+"\t"+"TU"+"\t"+"WED"+"\t"+"TH"+"\t"+"FRI"+"\t"+"SAt");
	for(int i = 0; i < numberOfObject; i++)
	{
		Queue queue = (Queue) week.poll();
		int length = queue.size();
		for(int j = 0; j <length; j++)
		{
			System.out.print(queue.poll());
			System.out.print("\t");
		}
		System.out.println();
	}
}
/**
 * @param stringForPalindrome = name of string which is to be checked palindrome or not
 * @return boolean true if string is palandrome else return false
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public static boolean palindromeWithDeqeue(String stringForPalindrome)
{
	boolean check = false;
	Deque deque =  new java.util.LinkedList();
	Deque deque2 = new java.util.LinkedList();
	char[] array = stringForPalindrome.toCharArray();
	for(char value : array)
	{
		deque.push(value);
		deque2.push(value);
	}
	while(deque.size() != 0)
	{
		if(deque.pop() == (deque2.removeLast()))
		{
			check = true;
		}
		else
		{
			check = false;
			break;
		}
	}
	return check;
}
/**
 * print prime and anagram bettween 1 to 1000 by stack
 */
public static void primeAnagramUseingStack()
{

	Linkedlist linkedlist = new Linkedlist();
	Stack stack = new Stack(); 
	for(int i=0;i<=1000;i++)
	{
		if(Utility.prime(i))
		{
			linkedlist.add(i);
		}
	}
	for(int i = 0; i < linkedlist.size()-1;i++)
	{
		for(int j = i+1; j <linkedlist.size();j++)
		{
			if(Utility.anagram(linkedlist.dataAtPosition(i), linkedlist.dataAtPosition(j)))
			{
				stack.push(linkedlist.dataAtPosition(i));
				stack.push(linkedlist.dataAtPosition(j));
			}
		}
	}
	while(!(stack.isEmpty()))
	{
		System.out.println((Integer)stack.pop());
	}
}
/**
 * print prime and anagram bettween 1 to 1000 by queue
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public static void primeAnagramUseingQueue()
{
	Queue1 queue = new Queue1();
	Linkedlist linkedlist = new Linkedlist();
	for(int i = 1; i<=1000;i++)
	{
		if(Utility.prime(i))
		{
			linkedlist.add(i);
		}
	}
	for(int i =0; i <linkedlist.size()-1;i++)
	{
		for(int j = i+1; j < linkedlist.size();j++)
		{
			if(Utility.anagram(linkedlist.dataAtPosition(i), linkedlist.dataAtPosition(j)))
			{
				queue.enqueue(linkedlist.dataAtPosition(i));
				queue.enqueue(linkedlist.dataAtPosition(j));
			}
		}
	}
	while(!(queue.isEmpty()))
			{
		System.out.println((Integer)queue.dequeue());
			}
}
/**
 * @throws IOException for if file not found
 * take number from file and arrange them in slot
 */
public static void numberInSlotControler() throws IOException
{
	PrintWriter printWriter = new PrintWriter("numberSlot.text");
	Linkedlist linkedlist = new Linkedlist();
	HashMap<Integer, Linkedlist> hashMap = new HashMap<>();
	BufferedReader bufferedReader = new BufferedReader(new FileReader("Integerdata.text"));
	String line = bufferedReader.readLine();
	while(line != null)
	{
		String[] array = line.split(" ");
		for(String words : array)
		{
			linkedlist.add(Integer.parseInt(words));
		}
		line = bufferedReader.readLine();
	}
	for(int i = 0;i<linkedlist.size();i++)
	{
		int number = linkedlist.dataAtPosition(i);
		int slot = number % 11;
		if(hashMap.containsKey(slot))
		{
			hashMap.get(slot).add(number);
		}
		else
		{
			hashMap.put(slot, new Linkedlist());
			hashMap.get(slot).add(number);
		}
	}
	System.out.println("enter the digit to be searched");
	Utility utility = new Utility();
	int search = utility.inputInteger();
	int slot = search % 11;
	if(hashMap.containsKey(slot))
	{
		if(hashMap.get(slot).search(search))
		{
			hashMap.get(slot).delete(search);
		}
		else
		{
			hashMap.get(slot).add(search);
		}
	}
	else
	{
		hashMap.put(slot, new Linkedlist());
		hashMap.get(slot).add(search);
	}
		for(int i = 0; i<11;i++) 
		{
			if(hashMap.containsKey(i))
				{
				printWriter.println("\n["+i+"] ");

				Linkedlist lk = hashMap.get(i);
				
					for(int j = 0; j < lk.size();j++)
					{
						printWriter.print(lk.dataAtPosition(j)+" ");
					}
					printWriter.println("\n");

				}
		}
	printWriter.flush();
	printWriter.close();
	bufferedReader.close();
}
/**
 * @param arrayList = contion 4 string[] array each haveing player cards
 * print the card of each player
 */
public static void printCardsOfPlayers(ArrayList<String[]> arrayList)
{
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
/**
 * @param array = array to be sorted
 * @param low = 0
 * @param high = length of the array
 * sort array useing merge sort algorithm
 */
public static void mergesort(int array[],int low,int high)
{
	int n = high - low;		
	if(n<=1)
		return;
	int mid = low + n/2;
	mergesort(array,low,mid);
	mergesort(array, mid, high);
	int temp[] = new int[n];
	int i=low,j=mid;	
	for(int k=0;k<n;k++)
	{
		if(i==mid)
		{
			temp[k] = array[j++];
		}
		else if(j == high)
		{
			temp[k] = array[i++];
		}
		else if(array[j] < array[i])
		{
			temp[k] = array[j++];
		}
		else
		{
			temp[k] = array[i++];
		}
	}
	for (int k = 0; k < n; k++) 
        array[low + k] = temp[k];   
}
/**
 * @param array = name of the array in which value is to be searched
 * @param intElement = elemnet to be serached 
 * @param startingIndex = start index of array
 * @param lastIndex = last index of array
 */
public static <T extends Comparable<T>> void binarySearch(T[] array,T intElement,int startingIndex,int lastIndex)
{
	int middleIndex = 0;
	middleIndex=(startingIndex+lastIndex)/2;
	if(intElement.equals(array[middleIndex]))
	{
		System.out.println("Found the Word");
	}
	else if(startingIndex==lastIndex)
	{
		System.out.println("There is no such element");
	}
	else 
	{
		if(array[middleIndex].compareTo((T) intElement)>0)
		{
			binarySearch(array,intElement,startingIndex,middleIndex);
		}
		else
		{
			binarySearch(array,intElement,middleIndex+1,lastIndex);	
		}
	}
}
/**
 * @return Interger type of array
 */
public static Integer[] inputIntegerArray()
{
	Utility utility = new Utility();
	System.out.println("enter the length of array");
	int length = utility.inputInteger();
	Integer[] array = new Integer[length];
	for(int i = 0; i <length; i++)
	{
		System.out.println("enter the " + i + "th element of array");
		array[i] = utility.inputInteger();
		
	}
	return array;
}
/**
 * @return string type of array
 */
public static String[] inputStringArray()
{
	Utility utility = new Utility();
	System.out.println("enter the length of array");
	int length = utility.inputInteger();
	String[] array = new String[length];
	for(int i = 0; i <length; i++)
	{
		System.out.println("enter the " + i + "th element of array");
		array[i] = utility.inputString();
	}
	return array;
}
public static int[] inputintegerArray()
{
	Utility utility = new Utility();
	System.out.println("enter the length of array");
	int length = utility.inputInteger();
	int[] array = new int[length];
	for(int i = 0; i <length; i++)
	{
		System.out.println("enter the " + i + "th element of array");
		array[i] = utility.inputInteger();
	}
	return array;
}
public static void readFileAndBinarySearch(String filename) throws IOException
{
	Utility utility = new Utility();
	ArrayList<String> arrayList = new ArrayList<>();
	BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
	String line = bufferedReader.readLine();
	while(line != null)
	{
		String[] words = line.split(",");
		for(String word : words)
		{
			arrayList.add(word);
		}
		line = bufferedReader.readLine();
	}
	bufferedReader.close();
	String[] wordList = new String[arrayList.size()];
	for(int i = 0; i < arrayList.size();i++)
	{
		wordList[i] = arrayList.get(i);
	}
	System.out.println("enter the word to bhe searched");
	String serched = utility.inputString();
	binarySearch(wordList, serched, 0, wordList.length-1);

}
}








