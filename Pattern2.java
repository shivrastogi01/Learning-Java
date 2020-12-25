public class Pattern2
{
public static void main(String[] args)
	{
	for ( int i=1;i<=5;i++)
		{
		for( int j=1;j<=i;j++)
			{
				for(int k=5;k>5-i;k--)
				{
					System.out.print("1");
				}
		System.out.print("*");
   			}
		System.out.println();
		}
	}

}	