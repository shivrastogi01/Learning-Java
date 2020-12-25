import java.util.*;

public class Prime
{
public static void main(String args[])
	{
	System.out.println("Enter any number");
	Scanner sc= new Scanner(System.in);
    int num=sc.nextInt();
	int i,j;
	int count=0;
	for(i=1;i<=num;i++)
		{
			for(j=2;j<i;j++)
			{
			   if	((i%j)==0)
			   {
				count++;
				if(count!=0)
				{
				System.out.println(i);
				 break;
				}
			    }
			
			}
			
			
			
		}
	}

}