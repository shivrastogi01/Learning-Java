import java.io.*;
import java.util.*;

class Pair 
{ 
    Integer key; 
    Integer value; 
      
    public Pair(Integer key, Integer value) 
    { 
        this.key = key; 
        this.value = value; 
    } 
    public Integer getKey() 
    { 
        return key; 
    } 
    public void setKey(Integer key) 
    { 
        this.key = key; 
    } 
    public Integer getValue() 
    { 
        return value; 
    } 
    public void setValue(Integer value) 
    { 
        this.value = value; 
    } 
} 

class SortingOfMergeArray{// time complexity nklog nk 

public static ArrayList<Integer> mergeKArrays(ArrayList<ArrayList<Integer> > arr) 
{ 
    ArrayList<Integer> res=new ArrayList<Integer>(); 
      
    for(ArrayList<Integer> v: arr) 
    { 
        for(Integer x:v) 
            res.add(x); 
    } 
      
    
    Collections.sort(res); 

    return res;
}

public static void main (String[] args)
{
	ArrayList<ArrayList<Integer> > arr=new ArrayList<ArrayList<Integer>>();
	
    ArrayList<Integer> a1 = new ArrayList<Integer>(); 
        a1.add(10); 
        a1.add(20);
        a1.add(30);
        arr.add(a1); 
  
        ArrayList<Integer> a2 = new ArrayList<Integer>(); 
        a2.add(5);
        a2.add(15);
        arr.add(a2); 
  
        ArrayList<Integer> a3 = new ArrayList<Integer>(); 
        a3.add(1); 
        a3.add(9); 
        a3.add(11);
        a3.add(18);
        arr.add(a3);
        
    ArrayList<Integer> res = mergeKArrays(arr); 
  
    System.out.println("Merged array is " ); 
    for (int x : res) 
        System.out.print(x + " ");
}
}
