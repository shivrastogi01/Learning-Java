import java.util.*;

class Print_pattern
{
	public static void main(String[] args)
	{ 
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the value of row");
		int j=sc.nextInt();
		System.out.println("Enter the value of column");
		int k=sc.nextInt();
		
		for(int i=0;i<=j;i++)
		{
			for(int n=0;n<=k;n++)
			{
				System.out.printf("%d%-3d",i,n);
			}
			System.out.println();
		}
		
	}
}







