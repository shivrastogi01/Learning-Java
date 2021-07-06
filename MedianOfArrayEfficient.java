import java.io.*;
import java.util.*;

class Node {
    double data;
    Node left, right;
    int lCount;
    Node(double x)
    {
        data = x;
        left = right = null;
        lCount = 0;
    }
}

class MedianOfArrayEfficient{//using min heap and max heap (Binary heap tree)

public static void printMedians(int arr[],int n){
    PriorityQueue<Integer> g=new PriorityQueue<Integer>();
    PriorityQueue<Integer> s=new PriorityQueue<Integer>(Collections.reverseOrder());
    s.add(arr[0]);
    System.out.print(arr[0]+" ");
    for(int i=1;i<n;i++){
        int x=arr[i];
        if(s.size()>g.size())
        {
            if(s.peek()>x){
                g.add(s.poll());
                s.add(x);
            }else g.add(x);
            System.out.print(((double)(s.peek()+g.peek())/2)+" ");
        }else{
            if(x<=s.peek()){
                s.add(x);
            }else{
                g.add(x);
                s.add(g.poll());
            }
            System.out.print(s.peek()+" ");
        }
    }
}
     
    public static void main(String args[])
    {
        int keys[] = { 12, 15, 10, 5, 8, 7, 16};
    
        printMedians(keys,7);
    }
}
