package com.example.mansi;

public class MinimumOperationToBecameOneStringAnagramToAnother{

	 public int findAnagrams(String input1, String input2)
	    {
	        int count = 0;
	 
	      
	        int char_count[] = new int[26];
	 
	        for (int i = 0; i < input1.length(); i++)
	            char_count[input1.charAt(i) - 'a']++;       
	 
	        for (int i = 0; i < input2.length(); i++)
	        {
	            char_count[input2.charAt(i) - 'a']--;
	        }
	       
	        for(int i = 0; i < 26; ++i)
	        {
	          if(char_count[i] != 0)
	          {
	            count+= Math.abs(char_count[i]);
	          }
	        }
	         
	        return count ;
	    }
}
