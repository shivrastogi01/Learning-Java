/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class BubbleSortOptimized {
    
    static void bubbleSort(int arr[]){
        boolean swapped;
        
        for(int i = 0; i <arr.length; i++){
            
            swapped = false;
            
            for(int j = 0; j < arr.length - i - 1; j++){
                if( arr[j] > arr[j + 1]){
                    
                    // swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    swapped = true;
                    
                }
            }
            if(swapped == false)
            break;
        }
    }
    
	public static void main (String[] args) {
	    System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array elements");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	    bubbleSort(arr);
	    
	    for(int i = 0; i <arr.length; i++){
	        System.out.print(arr[i] + " ");
	    }
	}
}