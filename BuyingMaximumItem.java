import java.util.*;
import java.io.*;
import java.lang.*;
  
class BuyingMaximumItem { //time complexity theta nlog N
    
    public static void main(String args[]) 
    { 
        int n=5;
        int cost[]=new int[]{1,12,5,111,200};
        int sum=10;
        
        int res=0;
        Arrays.sort(cost);
        for(int i=0;i<n;i++){
            if(cost[i]<=sum){
                sum-=cost[i];
                res++;
            }else{
                break;
            }
        }
        System.out.print(res);
    	
    } 
   
} 