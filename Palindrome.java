import java.util.Scanner;

class Palindrome{
	public  static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();
			Palindrome p=new Palindrome();
			System.out.println(p.isPal(n));
			
	}
	boolean isPal(int n){
		int rev=0;
		int temp=n;
		while(temp!=0){
			int ld=temp%10;
			rev=rev*10+ld;
			temp=temp/10;
		}
		return (rev==n);
		
		
	}

}