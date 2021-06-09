import java.util.*;
import java.io.*;

class LargestElementArray{
	public static void main(String[] args){
	System.out.println("How many elements you want to enter");
	Scanner sc =new Scanner(System.in);
	int n=sc.nextInt();
	int arr[]= new int[n];
	System.out.println("Enter array elements");
	for (int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	System.out.println("The Output is ");
	System.out.println(getLargest(arr));
	
	
	}
	 static int getLargest(int arr[]){
		int res=0;
		for(int i=1;i<arr.length;i++)
		{
		if(arr[i]>arr[res])
		res=i;
		}
		
		return res;
	}
}