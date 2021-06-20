import java.util.*;
import java.io.*;

class LongestConsecutiveSubsequence{
	public static void main(String[] args){
	System.out.println(" Enter how many element you want in array");
	Scanner sc= new Scanner(System.in);
	int n= sc.nextInt();
	System.out.println("Enter the array elements");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	System.out.println("The longest Consecutive Substring is : "+longestSubstring(arr));
	}
	static int  longestSubstring(int arr[]){
		Set<Integer> hs= new HashSet<Integer>();
		for(int x: arr)
		hs.add(x);
		int res=1;
		
		for(Integer x: hs){
			if(hs.contains(x-1)==false){
				int curr =1;
				while(hs.contains(x+curr))
				curr++;
				res=Math.max(res,curr);
			}
		}
		return res;
	}
	
	
}