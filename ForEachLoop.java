import java.util.*;

public class ForEachLoop
{
	public static void main (String [] args)
	{
		System.out.println("Enter values for rows and column");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int j=sc.nextInt();
		System.out.println("Enter elements");
		int array[][]=new int[i][j];
		int k,l;
		for(k=0;k<i;k++)
		{
			for(l=0;l<j;l++)
			{
				array[k][l]=sc.nextInt();
			}
		}
		
		for(int a[] : array)
		{
			for(int num : a)
			{
				System.out.print(num + " ");
			}
				System.out.println();
		
		
			
		}
	}
}