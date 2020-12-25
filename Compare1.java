import java.util.Scanner;	


public class Compare1
{
public static void main(String[] args)
	{
	System.out.println("Enter your first string");
	Scanner s1= new Scanner(System.in);
	String str1= s1.nextLine().toLowerCase();
	
	System.out.println("Enter your Second string");
	String str2= s1.nextLine().toLowerCase();
	System.out.println((str1.compareTo(str2)==0)?"Same":"Not Same");
	
	}

}