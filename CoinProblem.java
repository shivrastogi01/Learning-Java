//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class CoinProblem
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter the digit in the string");
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
		//	System.out.println("Enter the String in 01 form");
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.flipCoins(n,S));
                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public String flipCoins(int N,String s) {
         StringBuilder s1 = new StringBuilder(s);
        
        int count=1;
        for(int i=0;i<N-1;i++){
        if(s1.charAt(i)=='0' && s1.charAt(i+1)=='0')
        {
            s1.setCharAt(i,'1');
            s1.setCharAt(i+1,'1');
           
        }
        if(s1.charAt(i)=='1')
        {
            count ++;
        }
        }if(count==(N))
        return "Yes";
        
        else
        return "No";
    }
}