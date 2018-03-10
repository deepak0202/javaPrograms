package com.bridgeit.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.dataStructure.LinkedList;
import com.bridgeit.dataStructure.Linkedlist;
import com.bridgeit.dataStructure.Stack;;

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
	 * @param n = max number of times gamble will play
	 *  it print wining and loss percent of gambler
	 */
	
	public static void gambler(int stake,int goal,int n)
	{
		int won = 0;
		int loss = 0;
		int heplayed = 0;
		for(int i = 1; i <=n;i++)
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
	 * @param n = number of coupon user wants to genrate
	 * print distinct coupon number
	 */
	public static HashSet<Integer> coupon(int n)
	{
		int y = 0;
		Random r = new Random();
		HashSet h = new HashSet();
		while(h.size()!= n)
		{
			y = r.nextInt();
			if(y>0)
			{
				h.add(y);
			}
		}
		return h;
	}
	/**
	 * @param x = name of array whose triplete we want to genrate
	 * print triplet whose sum is zero
	 */
	public static void triplet(int[] x)
	{
		int l = x.length;
		for(int i = 0;i<l-2;i++)
		{
			if(x[i] + x[i+1]+x[i+2]==0)
			{
				System.out.println(x[i] + " " + x[i+1] + " " + x[i+2]);
				
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
	 * 
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
			Integer[][] x= new Integer[row][colums];
			for(int i = 0; i<row;i++)
			{
				for(int j = 0; j<colums;j++)
				{
					System.out.println("enter x["+i+"]["+j+"] element of array");
					x[i][j] = utility.inputInteger();
				}
			}
			printArray(x, row, colums);
			break;
			case 2:
				Double[][] x1 = new Double[row][colums];
				for(int i = 0; i<row;i++)
				{
					for(int j = 0; j<colums;j++)
					{
						System.out.println("enter x["+i+"]["+j+"] element of array");
						x1[i][j] = utility.inputDouble();
					}
				}
				printArray(x1, row, colums);
				break;
				case 3:
					Boolean[][] x2 = new Boolean[row][colums];
					for(int i = 0; i<row;i++)
					{
						for(int j = 0; j<colums;j++)
						{
							System.out.println("enter x["+i+"]["+j+"] element of array");
							x2[i][j] = utility.inputBoolean();
						}
					}
					printArray(x2, row, colums);
					break;
					default:
						System.out.println("enter correct number");
						break;
		}
	}
	/**
	 * @param x = name of the 2d array which we want to print
	 * @param row = number of rows in that array
	 * @param colums = number of colums in that array
	 */
	public  static <T> void printArray(T[][] x,int row,int colums) 
	{
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < row; i++) 
		{
			for(int j = 0;j<colums;j++)
			{
			printWriter.print(x[i][j]+" ");
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
	 * @param n = numer till which power of two has to be calculate
	 * generate table of 2 pow 1 to 2 pow till number entered by user
	 */
	public static void power(int n)
	{
		int value =0;
		if(n<0|| n>31)
		{
			System.out.println("stack overflow");
		}
		else
		{
			for(int i = 0;i<=n;i++)
			{
				value = (int) Math.pow(2, i);
				System.out.println("2^"+i+" = " + value);
			}
		}
	}
	/**
	 * @param n = represent till which number we have to find harmonic series sum
	 * it print the sum of n harmonic number
	 */
	public static void harmonic(double n)
	{
		double sum = 0;
		if(n==0)
		{
			System.out.println("enter a non zero number");
		}
		else
		{
			for(int i = 1; i<= n; i++)
			{
				sum+=(double)1/i;
			}
			System.out.println(sum);
		}
	}
	/**
	 * @param n = takes number whose primeFactorization we have to found
	 * print prime factor of the number
	 */
	public static void primeFactorization(int n)
	{
		for(int i = 1;i<n;i++)
		{
			if(n%i==0 && prime(i))
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
				System.out.println(x[i][j]);
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
	 * @param s = String which has to be printed with msg
	 * check whether String is greater then 3 character if it is them print it with msg
	 */
public	static void hello(String s)
	{
	if(s.length()>=3)
	{
	System.out.println("Hello " + s + ", How are you?");
	}
	else
	{
	System.out.println("enter string haveing 3 or more charater");
	}

	}


	/**
	 * @param n = number of times we have to flip the coin
	 * print the percent of head and tail occurrence
	 */
	public static void flipCoin(int n)
	{
	int tail = 0;
	int head = 0;
	for(int i = 1; i<=n;i++)
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
	double headPercent = (head * 100) /n;
	double tailPercent = (tail * 100) /n;
	System.out.println("Head percent" + headPercent + "v/s tail Percent" + tailPercent);
	}


	/**
	 * @param y= year which is to be checked whether leap or not
	 * @return boolean if year is leap then true else false
	 */
	public static boolean leap(int y)
	{
	if(y%4==0)
			{
				if(y%100==0)
				{
					if(y%400==0)
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
	public static long start()
	{
		return  System.currentTimeMillis();
	}
	public static long end()
	{
		return  System.currentTimeMillis();
	}
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
		 * @param s1 = String to be checked anagram with other string
		 * @param s2 = String to be checked anagram with other string
		 * @return boolean true if Strings are anagram else false
		 */
		public static boolean anagram(String s1,String s2)
		{
			String s3 = s1.replaceAll(" +", "").toLowerCase();
			String s4 = s2.replaceAll(" +", "").toLowerCase();
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
		 * @param change = amount for which min number of change to be found
		 * @param count = total number of notes return in starting take it as 0
		 * @param h = refrence variable of hashset
		 * print the notes return by vending machine and and min number of notes to be return
		 * its a recursive method
		 */
		public static void vending(int change,int count,HashSet h)
		{
			int[] x = {1000,500,100,50,10,5,2,1};
			for(int i = 0; i<x.length;i++)
			{
				if(change>= x[i])
				{
					change = change - x[i];
					count++;
					h.add(x[i]);
					break;
				}	
			}
			if(change == 0)
			{
				 System.out.println(count);
				 System.out.println(h);
				return;
			}
			vending(change,count,h);
		}
		/**
		 * @param n = number to be checked whether palindrome or not
		 * @return boolean true if number is palindrome else false
		 */
		public static boolean Palindrome(int n)
		{
			String s = Integer.toString(n);
			String s1 ="";
			for(int i = s.length()-1;i>=0;i--)
			{
				s1+=s.charAt(i);
			}
			if(s1.equals(s))
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
		 * @param x = String type of array which is to be sorted
		 * @return String type sorted array use insertion sort algo 
		 */
		public static String[] insertionSort(String[] x)
		{
			String key="";
			int j=0;
			for(int i = 0; i < x.length;i++)
			{
				j= i-1;
				key = x[i];
				
			while(j>=0 && x[j].compareTo(key)>0)
			{
				x[j+1] = x[j];
				j--;
			}
			x[j+1] = key;
			}
			return x;
		}
		/**
		 * @param x = integer type array which is to be sort 
		 * @return sorted array useing bubblesort algo
		 */
	public	static int[] bubbleSort(int[] x)
		{
			for(int i = 0; i < x.length-1;i++)
			{
				for(int j = 0; j<x.length-i-1;j++)
				{
					if(x[j] > x[j+1])
					{
						int temp = x[j];
						x[j] = x[j+1];
						x[j+1] = temp;
					}
				}
			}
			return x;
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
		public static void permute(String str, int l, int r)
		    {
		        if (l == r)
		            System.out.println(str);
		        else
		        {
		            for (int i = l; i <= r; i++)
		            {
		                str = swap(str,l,i);
		                permute(str, l+1, r);
		                str = swap(str,l,i);
		            }
		        }
		    }
		 /**
		 * @param a=name of the string whose charater are to be swaped
		 * @param i= index of character to be swaped
		 * @param j= index of character to be swaped
		 * @return new string with its character swaped
		 */
		public static String swap(String a, int i, int j)
		    {
		        char temp;
		        char[] charArray = a.toCharArray();
		        temp = charArray[i] ;
		        charArray[i] = charArray[j];
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
		System.out.println("done");
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
public static void writeInventoryJsonFile() throws FileNotFoundException
{
	Map m;
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
		m = new LinkedHashMap<>();
		System.out.println("enter the name of rice of " + i);
		String riceName = utility.inputString();
		System.out.println("enter weight of rice of" + i);
		double weight = utility.inputDouble();
		System.out.println("enter the price of rice of " + i);
		double price = utility.inputDouble();
		m.put("name", riceName);
		m.put("weight", weight);
		m.put("price", price);
		jsonArrayOfRice.add(m);
	}
	
	System.out.println("enter number of pulse varity you want to enter in inventory");
	int numberOfPulse = utility.inputInteger();
	
	for(int i = 1; i<=numberOfPulse;i++)
	{
		m = new LinkedHashMap<>();
		System.out.println("enter the name of pulse of " + i);
		String pulseName = utility.inputString();
		System.out.println("enter the weight of pulse of " + i);
		double weight = utility.inputDouble();
		System.out.println("enter the price of pulse of " + i);
		double price = utility.inputDouble();
		m.put("name", pulseName);
		m.put("weight", weight);
		m.put("price", price);
		jsonArrayOfPulse.add(m);
	}
	
	System.out.println("enter number of wheat varity you want to enter in inventory");
	int numberOfWheat = utility.inputInteger();
	
	for(int i = 1; i<=numberOfWheat; i++)
	{
		m = new LinkedHashMap<>();
		System.out.println("enter the name of wheat of " + i);
		String wheatName = utility.inputString();
		System.out.println("enter the weight of wheat of " + i);
		double weight = utility.inputDouble();
		System.out.println("enter the price of wheat of " + i);
		double price = utility.inputDouble();
		m.put("name", wheatName);
		m.put("weight", weight);
		m.put("price", price);
		jsonArrayOfWheat.add(m);
	}
	
	jsonObject.put("rice", jsonArrayOfRice);
	jsonObject.put("pulse", jsonArrayOfPulse);
	jsonObject.put("wheat", jsonArrayOfWheat);
	
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();
	
}
public static JSONObject readFromJsonFile(String filename) throws FileNotFoundException, IOException, ParseException
{
	Object obj = new JSONParser().parse(new FileReader(filename));
    JSONObject jo = (JSONObject) obj;
    return jo;
}
public static void inventoryData(JSONObject jsonObject)
{
	JSONArray rice = (JSONArray) jsonObject.get("rice");
	JSONArray wheat = (JSONArray) jsonObject.get("wheat");
	JSONArray pulse = (JSONArray) jsonObject.get("pulse");
	
	for(int i = 0; i <rice.size();i++)
	{
	Map m = (Map) rice.get(i);
	String name = (String) m.get("name");
	double weight = (double) m.get("weight");
	double price = (double) m.get("price");
	double sum = weight * price;
	System.out.println("total price for rice of varity " + name + " is " + sum);
	}
	System.out.println();
	
	for(int i = 0; i < wheat.size();i++)
	{
		Map m = (Map) wheat.get(i);
		String name = (String) m.get("name");
		double wieght = (double) m.get("weight");
		double price = (double) m.get("price");
		double sum = wieght * price;
		System.out.println("total price for wheat of varity " + name + " is " + sum);
	}
	System.out.println();
	
	for(int i = 0; i < pulse.size();i++)
	{
		Map m = (Map) pulse.get(i);
		String name = (String) m.get("name");
		double wieght = (double) m.get("weight");
		double price = (double) m.get("price");
		double sum = wieght * price;
		System.out.println("total price for pulse of varity " + name + " is " + sum);
	}
}
public static void writeStockJsonFile() throws IOException, ParseException
{
	Map m;
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
		m = new LinkedHashMap<>();
		m.put("name", name);
		m.put("numberOfShare", numberOfShare);
		m.put("price", price);
		jsonArray.add(m);
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
				m = (Map) jsonArray2.get(i);
				if(m.containsValue(name))
				{
					present = true;		
					index = i;
					break;
				}
			}
			m = new LinkedHashMap<>();
			m.put("name", name);
			m.put("numberOfShare", numberOfShare);
			m.put("price", price);
			if(present)
			{
				jsonArray2.set(index, m);
				present = false;
			}
			else
			{
				jsonArray2.add(m);
			}
		}
		jsonObject.put("stock", jsonArray2);
	}
	
	PrintWriter printWriter = new PrintWriter("stock.json");
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();		
}
public static void readStockJsonFile() throws FileNotFoundException, IOException, ParseException
{
	Map m;
	double stockTotalPrice = 0;
	 JSONObject jsonObject = readFromJsonFile("stock.json");
	 JSONArray jsonArray = (JSONArray) jsonObject.get("stock");
	 System.out.println("stockName" + "\t" + "Numberofshare" + "\t" + "priceofshare" + "\t" + "total price");
	 for(int i = 0; i< jsonArray.size();i++)
	 {
		 m =(Map) jsonArray.get(i);
		 String stockName = (String) m.get("name");
		 int numberOfShare = (int)(double) m.get("numberOfShare");
		 double price = (double) m.get("price");
		 double sharePriceTotal = ((double)numberOfShare) * price;
		 System.out.println(stockName +"\t"+"\t" +"\t"+ numberOfShare +"\t" + price + "\t"+"\t" + sharePriceTotal);
		 stockTotalPrice += sharePriceTotal;
	 }
	 System.out.println("------------------------------------");
	 System.out.println("value of total stock : " + stockTotalPrice);
}

public static void printJsonObjectToFile(String fileName, JSONObject jsonObject) throws FileNotFoundException
{
	PrintWriter printWriter = new PrintWriter(fileName);
	printWriter.write(jsonObject.toJSONString());
	printWriter.flush();
	printWriter.close();
}

























}