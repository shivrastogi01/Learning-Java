import java.util.*;
import java.io.*;
import java.lang.*;

class Node  
{  
    int data;  
    Node next,random;  
    Node(int x)  
    {  
        data = x;  
        next = random = null;  
    }  
}
class CacheDesign{
    
    public static void print(Node start) 
    { 
        Node ptr = start; 
        while (ptr!=null) 
        { 
            System.out.println ( "Data = " + ptr.data + ", Random  = "+ ptr.random.data ); 
            ptr = ptr.next; 
        } 
    }
    
    public static Node clone(Node head) 
    { 
        HashMap<Node,Node> hm=new HashMap<Node,Node>();
        for(Node curr=head;curr!=null;curr=curr.next)
            hm.put(curr,new Node(curr.data));
        
        for(Node curr=head;curr!=null;curr=curr.next){
            Node cloneCurr=hm.get(curr);
            cloneCurr.next=hm.get(curr.next);
            cloneCurr.random=hm.get(curr.random);
        }
        Node head2=hm.get(head);
        
        return head2;
    }
	public static void main(String[] args) 
	{ 
		Node head = new Node(10); 
        head.next = new Node(5); 
        head.next.next = new Node(20); 
        head.next.next.next = new Node(15); 
        head.next.next.next.next = new Node(20); 
        
        head.random = head.next.next;
        head.next.random=head.next.next.next;
        head.next.next.random=head;
        head.next.next.next.random=head.next.next;
        head.next.next.next.next.random=head.next.next.next;
        
        System.out.print( "Original list : \n"); 
        print(head); 
      
        System.out.print( "\nCloned list : \n"); 
        Node cloned_list = clone(head); 
        print(cloned_list);  
	} 
} 

