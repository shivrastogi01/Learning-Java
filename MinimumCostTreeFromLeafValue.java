class MinimumCostTreeFromLeafValue {
    public int mctFromLeafValues(int[] arr)
    {
        int n=arr.length-1;
        return fun(arr, 0, n, new Pair[n+1][n+1]).sum;
    }
    
    public Pair fun(int[] arr, int l, int r, Pair[][] dp)
    {
        if(l>r) return new Pair(0,1000000);
        if(l==r)return new Pair(arr[l], 0);
        if(dp[l][r]!=null) return dp[l][r];
        Pair ans=new Pair(0, 1000000);
        for(int i=l;i<r;i++)
        {
           Pair Pair_left= fun(arr, l, i, dp);
           Pair  Pair_right=fun(arr, i+1, r, dp);
            
            int total= Pair_left.sum + Pair_right.sum +(Pair_left.max * Pair_right.max);
            
            if(total< ans.sum)
            {
                ans.max= Math.max(Pair_left.max, Pair_right.max);
                ans.sum= total;
            }
        }
        dp[l][r]= new Pair(ans.max, ans.sum);
        return ans;
    }
}

class Pair
{
    int max, sum;
    Pair(int max, int sum)
    {
        this.max=max;
        this.sum=sum;
    }
}