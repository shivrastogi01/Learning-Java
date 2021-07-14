/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class EditDistanceProblemUsingDP {

      
	    static int eD(String s1, String s2, int m, int n)
        {
            int dp[][]= new int[m+1][n+1];
    
            for(int i=0;i<=m;i++)
            {
                dp[i][0]=i;
            }
            
            for(int j=0;j<=n;j++)
            {
                dp[0][j]=j;
            }
            
            for(int i=1;i<=m;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                    {
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], 
                                                                dp[i-1][j-1]));
                        
                    }
                }
            }
            
            return dp[m][n];
        }


	public static void main (String[] args) {
		
	    String s1="CAT", s2="CUT";
        int n=3, m=3;
	
	  
	   System.out.println(eD(s1,s2,m,n));
	    
	}
}