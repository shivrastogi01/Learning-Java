import java.util.*;
import java.io.*;
import java.lang.*;



class ArraySumCertainIndex
{ 

	static int getSum(int arr[], int qs, int qe)
	{
		int sum = 0;

		for(int i = qs; i <= qe; i++)
			sum = sum + arr[i];

		return sum;
	}

	static void update(int arr[], int i, int newVal)
	{
		arr[i] = newVal;
	}

	public static void main(String args[]) 
    {

		int arr[] = {10, 20, 30, 40, 50}, n= 5;

		System.out.print(getSum(arr, 0, 2) + " ");
		System.out.print(getSum(arr, 1, 3) + " ");
		
		update(arr, 1, 60);
		
		System.out.print(getSum(arr, 0, 2) + " ");
		System.out.print(getSum(arr, 1, 3) + " ");

    } 

}