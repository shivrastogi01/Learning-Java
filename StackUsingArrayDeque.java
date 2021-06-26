/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class StackUsingArrayDeque {
    
   
	public static void main (String[] args) {
	
	    ArrayDeque<Integer> stack = new ArrayDeque<>();
	    
	    stack.push(10);
	    stack.push(20);
	    stack.push(30);
	    
	    System.out.println(stack.peek());
	    System.out.println(stack.pop());
	    System.out.println(stack.peek());
	  
	}
	
}