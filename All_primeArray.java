import java.util.Scanner;

public class All_primeArray
{
	public static void main (String[] args)
	{   
	
	int arr[]={2,3,4,5,6,7,8,10,34,56,19};
	
	int num=0;
	
		
	 for( int i=0;i<=arr.length-1;i++)	 
		{

			for(int j=2;j<=i;j++)
			{
				if(arr[i]%j==0)
				{
					num=num+1;
					
				}
				
				
			}
			if(num==0)
			{
				System.out.println(arr[i]);
			}
			else
			num=0;
						
		}
	}
   
		
		
		
	
	
}