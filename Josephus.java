import java.util.*;
import java.io.*;
import java.lang.*;
class Josephus
{ 
    
    static int jos(int n, int k)
    {
    	if(n == 1)
    		return 0;
    	else
    		return (jos(n - 1, k) + k) % n;
    }

    static int myJos(int n, int k)
    {
    	return jos(n, k) + 1;
    }
      
   
    public static void main(String args[]) 
    { 
	System.out.println("Enter the total number of people and the postion of a person to be killed");
	Scanner sc= new Scanner(System.in);
	int n=sc.nextInt();
	int k=sc.nextInt();
	
	
        System.out.println(myJos(n, k));  
    } 
}