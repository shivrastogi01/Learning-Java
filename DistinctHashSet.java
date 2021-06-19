import java.util.*;
import java.io.*;
import java.lang.*;

class DistinctElementHashSet
{
    public static void main (String[] args) {
        int arr[] = new int[]{15, 16, 27, 27, 28, 15};
       
        System.out.println(countDistinct(arr));
    }
    
    static int countDistinct(int arr[])
    {
        Set<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i <arr.length; i++)
          hs.add(arr[i]);
    
       return hs.size();        
    }
}