import java.io.*;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

class MyStack{
    Node head;
    int sz;
    MyStack(){
        head=null;
        sz=0;
    }
    
    void push(int x){
        Node temp=new Node(x);
        temp.next=head;
        head=temp;
        sz++;
    }
    
    int pop(){
        if(head==null){return Integer.MAX_VALUE;}
        int res=head.data;
        Node temp=head;
        head=head.next;
        sz--;
        return res;
    }
    
    int peek(){
        if(head==null){return Integer.MAX_VALUE;}
        return head.data;
    }
    
    int size(){
        return sz;
    }
    
    boolean isEmpty(){
        return head==null;
    }
}
	
	class StackUsingLinkedlist{
		public static void main(String []args){
			MyStack s=new MyStack();
			Scanner sc=new Scanner(System.in);
			System.out.println("Choose Options: 1 for Push,2 for Pop, 3 for Size, 4 for Peek, 5 for check Stack empty or not,6 for exit ");
			int ch=sc.nextInt();
			int n;
			int flag=1;
			while(flag==1){
				switch(ch){
					case 1:
					System.out.println("The the value in stack");
					n=sc.nextInt();
					s.push(n);
					break;
					case 2:
					s.pop();
					break;
					case 3:
					s.size();
					break;
					case 4:
					s.peek();
					break;
					case 5:
					s.isEmpty();
					break;
					default:
					flag=0;
					System.out.println("Thank you" );
					break;
					
				}
				
	
		}
		}
	}
		
		
