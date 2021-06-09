import java.util.*;
import java.io.*;

class Permutation{
	public static void main(String [] args){
		System.out.println("Enter the String");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int i =0;
		permute(str,i);
		
		
	}
	 static void permute(String s ,int i){
		if(i==s.length()-1)
		{
			System.out.println(s);
			return;
		}
		for(int j=i;j<s.length();j++){
			swap(s.charAt(i),s.charAt(j));
			permute(s,i+1);
			swap(s.charAt(i),s.charAt(j));
		}
	}
}