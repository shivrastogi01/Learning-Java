/* A naive recursive implementation that simply follows 
the above optimal substructure property */
class MatrixChainMultiplicationUsingDP
{ 
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n 
	static int MatrixChainOrder(int p[]) 
	{ 
	    int n = p.length;
	    int dp[][] = new int[n][n];
	    for (int i=0; i<n-1; i++)
	       dp[i][i+1] = 0;
	       
	    for (int gap = 2; gap < n; gap++)
	    {
	        for (int i=0; i+gap < n; i++)
	        {
	            int j = i + gap;
	            dp[i][j] = Integer.MAX_VALUE;
	            for (int k=i+1; k<j; k++)
	            {
	               dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + p[i]*p[k]*p[j]);
	            }
	        }     
	    }
	    
	    return dp[0][n-1];
	} 

	// Driver program to test above function 
	public static void main(String args[]) 
	{ 
		int arr[] = new int[]  {40, 20, 30, 10, 30};
		int n = arr.length; 
		System.out.println("Minimum number of multiplications is "+ 
						MatrixChainOrder(arr)); 

	} 
} 