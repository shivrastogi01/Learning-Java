public class Pattern12
{
public static void main(String[] args)
	{
	int i,j;
	for(i=1;i<=9;i++)
		{ 
		
		if(i<6)
		{
		for(j=1;j<=i;j++)
			{
			System.out.print("* ");
			
			}
			System.out.println();
		}
		else 
		{
			for(j=9;j>=i;j--)
			{
			System.out.print("* ");
			
			}
			System.out.println();
		}
		}
	}

}