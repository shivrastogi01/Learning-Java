/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class PathComparison {

	static int parent[];


	static void initialize()
	{
	    for(int i=0; i<parent.length; i++)
	    {
	        parent[i]=i;
	    }
	}

	static int find(int x)
	{
	     if(parent[x]==x)
            return x;
    
        parent[x] = find(parent[x]);
    
        return parent[x];
	    
	}

	static void union(int x, int y)
	{
	    int x_rep = find(x);
	    int y_rep = find(y);
	    
	    if(x_rep==y_rep)
	    return;
	    
	    parent[y_rep]=x_rep;
	}

	public static void main (String[] args) {
		
		int n = 5;

		parent = new int[5];

		initialize();

		union(0, 2);
		union(0, 4);

		out.println(find(4));
		out.println(find(3));
	}
}