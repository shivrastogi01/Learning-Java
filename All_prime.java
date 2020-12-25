import java.util.Scanner;

public class All_prime
{
	public static void main (String[] args)
	{   
	System.out.println("ENter any number");
	Scanner sc= new Scanner(System.in);
	int value= sc.nextInt();
	int num=0;
	 for(int i=2;i<=value;i++)
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