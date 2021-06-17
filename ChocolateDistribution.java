import java.util.*;
import java.lang.*;
import java.io.*;

class ChocolateDistribution
{
    public static void main (String[] args) 
    {
        int arr[] = new int[]{7,3,2,4,9,12,56};
        
        int n = arr.length;int m=3;
        
        System.out.print(minDiff(arr,n,m));
        
    }
    
    static int minDiff(int arr[],int n,int m){
        if(m>n)
            return -1;
        Arrays.sort(arr);
        int res=arr[m-1]-arr[0];
        for(int i=0;(i+m-1)<n;i++)
            res=Math.min(res,arr[i+m-1]-arr[i]);
        return res;
    }
}
