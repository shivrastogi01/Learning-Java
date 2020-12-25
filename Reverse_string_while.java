import java.util.*;


class Reverse_string_while
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int i=str.length()-1;
		while(i>=0)
		{
			System.out.print(str.charAt(i));
			i--;
		}
	
	}
}