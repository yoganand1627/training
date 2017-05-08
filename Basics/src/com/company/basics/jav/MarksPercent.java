/**Program to Calculate Marks and Percentage of 10 students
 * 
 */
package com.company.basics.jav;
import java.io.*;
/**
 * @author Suneil
 * 
 *
 */
public class MarksPercent {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{

		//to accept data from the keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//to ask how many subjects
		System.out.println("How many Subjects?");
		int n= Integer.parseInt(br.readLine());
		
		//Creating a one dimensional array with size n
		int []marks=new int[n];
		
		//Store elements into the array
		for (int i=0;i<n;i++)
		{
			System.out.print("Enter Marks:");
			marks[i]=Integer.parseInt(br.readLine());
		}
		
		//find the total marks
		int tot=0;
		for (int i=0;i<n;i++)
		{
			tot += marks[i];
			System.out.println("Total Marks: ");
		}
		
		//find percentage
		float percent = (float) tot/n;
		System.out.println("Percentage is:"+percent);
		
	}

}
