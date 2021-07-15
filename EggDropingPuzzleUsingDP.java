/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class EggDropingPuzzleUsingDP {

	static int res(int e, int f) 
    { 
           
        int dp[][] = new int[f+1][e+1];
    
        for(int i = 1; i <= e ;i++){
            dp[1][i] = 1;
            dp[0][i] = 0;
        }
        
        for(int j = 1; j <= f; j++){
            dp[j][1] = j;
        }
        
        for(int i = 2; i <= f; i++){
            for(int j = 2; j <= e; j++){
                dp[i][j] =Integer.MAX_VALUE;
                for(int x = 1; x <= i; x++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x-1][j-1], dp[i-x][j]));
                }
            }
        }
        
        return dp[f][e];
            }

	public static void main (String[] args) {
		
			int n = 2;

		    int f = 10;

		
        System.out.println(res(n, f));
		

	}
}