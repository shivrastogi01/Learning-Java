import java.util.*;
import java.io.*;
import java.lang.*;



class RangeQueryInSegmentTree
{ 

	static int CST(int ss, int se, int si, int arr[], int tree[])
	{
		if(ss == se)
		{
			tree[si] = arr[ss];
			return arr[ss];
		}

		int mid = (ss + se) / 2;

		tree[si] = CST(ss, mid, 2 * si + 1, arr, tree)
			       +CST(mid + 1, se, 2 * si + 2, arr, tree);

		return tree[si];
	}

	static int getSumRec(int qs, int qe, int ss, int se, int si, int tree[])
	{
		if(se < qs || ss > qe)
			return 0;
		if(qs <= ss &&  qe >= se)
			return tree[si];

		int mid = (ss + se) / 2;

		return getSumRec(qs, qe, ss, mid, 2 * si + 1, tree)
			   + getSumRec(qs, qe, mid + 1, se, 2 * si + 2, tree);
	}

	public static void main(String args[]) 
    {

		int arr[] = {10, 20, 30, 40}, n= 4;

		int tree[] = new int[4 * n];

		CST(0, n - 1, 0, arr, tree);
		
		System.out.println(getSumRec(0, 2, 0, 3, 0, tree));

    } 

}