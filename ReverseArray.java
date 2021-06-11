import java.util.*;
import java.io.*;

class ReverseArray{
	public static void main(String[] args){
	 System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array element");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	
	System.out.println("The reverse array is : ");
	revArray(arr);

  }

static void revArray(int arr[]){
	for(int i=arr.length-1;i>=0;i--)
	{
		System.out.println(arr[i]);
	
		
	}
     
}
}