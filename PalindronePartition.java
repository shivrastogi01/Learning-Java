/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class PalindronePartition {

	static boolean isPalindrome(String input, int start, int end) 
	{ 
	    // Using two pointer technique to check pallindrome 
	    while (start < end) { 
	        if (input.charAt(start) != input.charAt(end)) 
	            return false; 
	        start++; 
	        end--; 
	    } 
	    return true; 
	} 
	
	static int palPart(String str)
	{
		int n = str.length();

		int dp[][] =new int[n][n];

		for(int i=0; i<n; i++)
		{
			dp[i][i] =0;
		}

		for(int gap = 1; gap<n; gap++)
		{
			for(int i=0; i+gap<n; i++)
			{
				int j = i + gap;

				if(isPalindrome(str, i, j))
				{
					dp[i][j] = 0;
				}
				else
				{
					dp[i][j] = Integer.MAX_VALUE;

					for(int k=i; k<j; k++)
					{
						dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k+1][j]);
					}
				}
			}
		}

		return dp[0][n-1];
	}

	public static void main (String[] args) {
		
		String s = "geek";

		System.out.println(palPart(s));

	}
}