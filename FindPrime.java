import java.util.*;

public class FindPrime{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to find all the prime number till that");
		int num = sc.nextInt();
		
		for(int i=1; i <=num;i++)
		{
			int j;
		
			for(j=2; j<i; j++)
			{
				int count=0;
				if(i%j==0)
				count++;
				
			}
			System.out.println(j);
			
		}
	}


}


//6283830308