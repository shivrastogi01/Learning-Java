import java.util.Scanner;
class RotatingArray {  
    
    public static void main(String[] args) {  
		Scanner sc= new Scanner(System.in);
	System.out.println("how many element you  want in the array");
	int d=sc.nextInt();
      
        int [] arr = new int [d] ; 
		System.out.println("Enter elements of array");
		for(int i=0;i<d;i++)
		{
			arr[i]=sc.nextInt();  
		}
		
		System.out.println("enter index");
	
	    int n= sc.nextInt();
        System.out.println("Original array: ");  
        for (int i = 0; i < arr.length; i++) {   
            System.out.print(arr[i] + " ");   
        }    
          
        //Rotate the given array by n times toward left  
        for(int i = 0; i < n; i++){  
            int j, first;  
            //Stores the first element of the array  
            first = arr[0];  
          
            for(j = 0; j < arr.length-1; j++){  
                //Shift element of array by one  
                arr[j] = arr[j+1];  
            }  
            //First element of array will be added to the end  
            arr[j] = first;  
        }  
          
        System.out.println();  
          
        //Displays resulting array after rotation  
        System.out.println("Array after left rotation: ");  
        for(int i = 0; i< arr.length; i++){  
            System.out.print(arr[i] + " ");  
        }  
    }  
}  