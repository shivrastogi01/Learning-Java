import java.util.Scanner;

public class All_primeBetween
{
	public static void main (String[] args)
	{   
	System.out.println("Enter Starting number");
	Scanner sc= new Scanner(System.in);
	int value= sc.nextInt();
	System.out.println("Entr Last number");
	
	int value1=sc.nextInt();
	int num=0;
	if(value1<value)
		{
			System.out.println("Second number should be greater than first number");
		}
	else
	{
		if(value<2)
		value=2;
		
		if(value1<2)
		System.out.println("No prime number exists");
		
	 for( int i=value;i<=value1;i++)	 
		{

			for(int j=2;j<=i/2;j++)
			{
				if(i%j==0)
				{
					num=num+1;
					
				}
				
				
			}
			if(num==0)
			{
				System.out.println(i);
			}
			else
			num=0;
			
			
			
			
		}
	}
   
		
		
		
	}
	
}