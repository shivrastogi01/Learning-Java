import java.util.Scanner;
import static java.lang.Math.*;
class CountZeros{
		static int countTrailingZeros(int n)
	{
		int res = 0;

		for(int i=5; i<=n; i=i*5)
		{
			res = res + (n / i);
		}

		return res;
	}

	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();

		System.out.println(countTrailingZeros(n));

	}
}