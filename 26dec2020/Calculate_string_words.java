import java.util.*;

public class Calculate_string_words
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine();
		int count=1;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{	
				count++;
			}
			
		}System.out.println(count);
	}
}