import java.io.*;
import java.util.*;
 
class CheckNumber{
 
static boolean ToCheckPowerofX(int n, int x)
{
    while (n > 0)
    {
         
        int rem = n % x;
        if (rem >= 2)
        {
            return false;
        }
 
        n = n / x;
    }
    return true;
}
public static void main (String[] args)
{
    int N = 35, X = 5;
    if (ToCheckPowerofX(N, X))
    {
        System.out.print("Yes");
    }
    else
    {
        System.out.print("No");
    }
}
}