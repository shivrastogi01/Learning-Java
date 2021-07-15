/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class Knapsackproblem{

  static int knapSack(int W, int wt[], int val[], int n) 
    { 
      
        
        if (n == 0 || W == 0) 
            return 0; 
      
       
        if (wt[n-1] > W) 
            return knapSack(W, wt, val, n - 1); 
      
       
        else
            return Math.max(val[n-1] + knapSack(W - wt[n-1],  wt, val, n - 1),
                                knapSack(W, wt, val, n - 1)); 
    } 
            
	public static void main (String[] args) 
	{
	    int val[] = { 10, 40, 30, 50 }; 
        int wt[] = { 5, 4, 6, 3 }; 
        int W = 10; 
        int n = 4;
	    
        
        System.out.println(knapSack(W, wt, val, n));

	    
	}
}