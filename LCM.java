import java.io.*;
import java.util.*;
class LCM{
		
	static int gcd(int a, int b)
	{
		if(b==0)
			return a;

		return gcd(b, a % b);
	}

	static int lcm(int a, int b)
	{
		return (a * b) / gcd(a, b);
	}
		public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter both the numbers");
	int a=sc.nextInt();
	int b=sc.nextInt();

		System.out.println(lcm(a, b));

	}
}