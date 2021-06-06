import java.util.*;

public class Prime
{
	
	static boolean isPrime(int n){
		if(n==1)
		return false;
		for(int i=2;i*i<n;i++)
		{
			if(n%i==0)
			return false;
		}return true;
	}
public static void main(String args[])
	{
	System.out.println("Enter any number");
	Scanner sc= new Scanner(System.in);
    int num=sc.nextInt();
	System.out.println(isPrime(num));
		
	}

}//time complexity is bigO(squareroot of N)