import java.io.*;
import java.util.*;

class MedianOfArray{

public static void main (String[] args)
{
	double[] arr=new double[]{25,7,10,15,20};int n=5;
    double[] temp=new double[n];
    int size=0;
    for(int i=0;i<n;i++){
        temp[i]=arr[i];
        size++;
        int j=i;
        while(j>0&&temp[j]<temp[j-1]){
        double a=temp[j];
        temp[j]=temp[j-1];
        temp[j-1]=a;
        j--;
    }
    if(size%2!=0)
         System.out.print(temp[size/2]+" ");
    else
        System.out.print(((temp[size/2]+temp[(size-1)/2])/2)+" ");
        
    }
}
}
