package com.inportia;

import java.util.Scanner;

public class StringProgram 
{

	public static void main(String[] args)
	{
				// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	//String str="Shital More ghfh fghg fhfhhgjhbh hhjbhub";
		  String str1[]= str.split(" ");
		  //System.out.println(str1[0]);
		 // int len1=str1[0].length();
		 // int len2=str1[1].length();
		  int s=str1.length;
		  System.out.println(s);
		  
		  for(int i=s-1;i>=0;i--)
		  {
		  
		      for(int j=str1[i].length()-1;j>=0;j--)
		      { int k= Integer.parseInt(str);
		      System.out.println(k);
		    	  if(str1[i].charAt(j)==k){
		    		  System.out.println("acd");
		    		  
		    	  }
		    	  System.out.print(str1[i].charAt(j));
		      }	
		      System.out.print(" ");
		   }
		   		
	
  }
}
