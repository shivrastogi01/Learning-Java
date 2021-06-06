import java.io.*;
import java.util.*;

class HighestDivisor {

	
	static int gcd(int a, int b)
	{
		if(b==0)
			return a;

		return gcd(b, a % b);
	}

	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter both the numbers")
	int a=sc.nextInt();
	int b=sc.nextInt();

		System.out.println(gcd(a, b));

	}
}//By using euclid algo