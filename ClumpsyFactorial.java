	  class ClumpsyFactorial {
public int clumsy(int n) {//For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
    int res=n;
    int total=0;
    int a=1;
    for(int i=n-1;i>0;i--)
    {
        if(a==1)
        {
            res=res*i;
            a++;
        }
        else if(a==2)
        {
            res=res/i;
            a++;
        }
        else if(a==3)
        {
            res=res+i;
            a++;
        }
        else if(a==4)
        {
           total += res;
            res =i * (-1); 
            a=1;
        }
    }
    return total+res;
 }
}