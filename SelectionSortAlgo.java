
import java.io.*;
import java.util.*;

class SelectionSortAlgo {
    
    
    static void selectionSort(int arr[]){
        for(int i = 0; i <arr.length; i++){
            int min_ind = i;
            
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min_ind]){
                    min_ind = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
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
	    selectionSort(arr);
	    
	    for(int i = 0; i <arr.length; i++){
	        System.out.print(arr[i] + " ");
	    }
	}
}