import java.util.*;
import java.io.*;
import java.lang.*;
class FrequenciesInArray
{ 
    

    static void printFreq(int arr[])
    {
    	int freq = 1, i = 1;

    	while(i <arr.length)
    	{
    		while(i <arr.length && arr[i] == arr[i - 1])
    		{
    			freq++;
    			i++;
    		}

    		System.out.println(arr[i - 1] + " " + freq);

    		i++;
    		freq = 1;
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
       printFreq(arr);

    } 

}