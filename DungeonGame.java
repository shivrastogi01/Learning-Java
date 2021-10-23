class DungeonGame {
    Integer[][] memo;
    public int calculateMinimumHP(int[][] arr) 
    {
        
        int n=arr.length;
        int m=arr[0].length;
        
        memo=new Integer[n][m];
        
        int answ=f(arr,0,0,n,m);
        
        return Math.abs(answ)+1;
        
    }
    
    int f(int[][] arr,int i,int j,int n,int m)
    {
        
        if(i>=n || j>=m)
        return Integer.MIN_VALUE;
        
        if(memo[i][j]!=null)
        return memo[i][j];
        
        if(i==n-1 && j==m-1)
        return Math.min(0,arr[i][j]);
        
        int down=f(arr,i+1,j,n,m);
        int right=f(arr,i,j+1,n,m);
        
        int max=Math.max(right,down);
        
        return memo[i][j]=Math.min(0,max+arr[i][j]);
        
        
    }
    
    
}