import java.util.*;
import java.io.*;
import java.lang.*;
class LeaderArray
{ 
    

    static void leaders(int arr[])
    {
    	int curr_ldr = arr[arr.length- 1];

    	System.out.print(curr_ldr+" ");

    	for(int i = arr.length- 2; i >= 0; i--)
    	{
    		if(curr_ldr < arr[i])
    		{
    			curr_ldr = arr[i];

    			System.out.print(curr_ldr+" ");
    		}
    	}
    }


    public static void main(String args[]) 
    { 
       System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array element");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	System.out.println("The Leaders are : ");
       leaders(arr);

    } 

}