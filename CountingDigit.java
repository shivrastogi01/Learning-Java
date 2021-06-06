	import java.util.Scanner;
	import static java.lang.Math.*;
	
	class CountingDigit{
		public static void main(String[] args){
			Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();
			CountingDigit d=new CountingDigit();
			 double y=d.countDigit(n);
			 System.out.println(y);
				
		}
		double countDigit(int n){
		return   floor(log10(n)+1);
		}
	}