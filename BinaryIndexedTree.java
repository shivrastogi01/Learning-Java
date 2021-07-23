 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class BinaryIndexedTree 
{ 
	
	final static int MAX = 1000;	 

	static int BITree[] = new int[MAX]; 
	
	
	int getSum(int index) 
	{ 
		int sum = 0; 
	
		
		index = index + 1; 
	
		
		while(index>0) 
		{ 
			
			sum += BITree[index]; 
	
			
			index -= index & (-index); 
		} 
		return sum; 
	} 

	
	public static void updateBIT(int n, int index, 
										int val) 
	{ 
		
		index = index + 1; 
	
		
		while(index <= n) 
		{ 
		 
		BITree[index] += val; 
	
		
		index += index & (-index); 
		} 
	} 

	
	void constructBITree(int arr[], int n) 
	{ 
		
		for(int i=1; i<=n; i++) 
			BITree[i] = 0; 
	
		
		for(int i = 0; i < n; i++) 
			updateBIT(n, i, arr[i]); 
	} 

 
	public static void main(String args[]) 
	{ 
		int freq[] = {10, 20, 30, 40, 50, 60, 70, 80, 90}; 
		int n = freq.length; 
		BinaryIndexedTree tree = new BinaryIndexedTree(); 

		
		tree.constructBITree(freq, n); 

		System.out.println("Sum of elements in arr[0..5]"+ 
						" is "+ tree.getSum(5)); 
		
		
	
	} 
} 
