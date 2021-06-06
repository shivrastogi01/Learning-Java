import java.util.*;

public class MultiDimensionArray
{
	public static void main (String [] args)
	{
		System.out.println("Enter values for rows and column");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int j=sc.nextInt();
		int array[][]=new int[i][j];
		int k,l;
		
		System.out.println("Enter the Values");
		for(k=0;k<i;k++)
		{
			for(l=0;l<j;l++)
			{
				array[k][l]=sc.nextInt();
			}
		}
		
		for(k=0;k<i;k++)
		{
			for(l=0;l<j;l++)
			{
				System.out.print(array[k][l]+" ");
			}System.out.println();
		}
		
		
			
		
	}
}