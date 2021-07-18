import java.util.*;
import java.io.*;
import java.lang.*;

class AllocateMinimumPagesUsingDP { 
    
    public static void main(String args[]) 
    { 
        int arr[]={10,20,10,30};
        int n=arr.length;
        int k=2;
        
    	System.out.print(minPages(arr,n,k)); 
    } 
    
    public static int sum(int arr[],int b, int e){
        int s=0;
        for(int i=b;i<=e;i++)
            s+=arr[i];
        return s;
    }
    
    public static int minPages(int arr[],int n, int k){
        int[][] dp=new int[k+1][n+1];
        for(int i=1;i<=n;i++)
            dp[1][i]=sum(arr,0,i-1);
        for(int i=1;i<=k;i++)
            dp[i][1]=arr[0];
            
        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                int res=Integer.MAX_VALUE;
                for(int p=1;p<j;p++){
                    res=Math.min(res,Math.max(dp[i-1][p],sum(arr,p,j-1)));
                }
                dp[i][j]=res;
            }
        }
        return dp[k][n];
    }
} 