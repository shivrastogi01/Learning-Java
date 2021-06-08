import java.util.*;
import java.io.*;

class PalindromeRecursion{
	public static void main(String[] args){
		System.out.println("Enter the string you want to check");
		Scanner sc=new Scanner(System.in);
		String str= sc.nextLine();
		System.out.println(isPalindrome(str,0,str.length()-1));
		
	}
	static boolean isPalindrome(String str, int start, int end){
		if(start>=end)
		return true;
		
			return ((str.charAt(start)==str.charAt(end)) && 
			     isPalindrome(str, start + 1, end - 1));
	}
}//time complexity theta(N)
//
