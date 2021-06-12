 import java.util.*;
 import java.io.*;
class N_bonacciNumbers { 
	
	// Function to print bonacci series 
	static void bonacciseries(int n, int m) 
	{ 
	
		// Assuming m > n. 
		int a[] = new int[m]; 
		for(int i = 0; i < m; i++) 
			a[i] = 0; 		
			
		a[n - 1] = 1; 
		a[n] = 1; 
	
		// Uses sliding window 
		for (int i = n + 1; i < m; i++) 
			a[i] = 2 * a[i - 1] - a[i - n - 1]; 
	
		// Printing result 
		for (int i = 0; i < m; i++) 
			System.out.print(a[i] + " "); 
	} 
	
	// Driver's Code 
	public static void main(String args[]) 
	{ 
		System.out.println("Enter the number of previous digit you want to make series");
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println("Enter the number of digits you want to print");
		int M=sc.nextInt();
		bonacciseries(N, M); 
	} 
} 

