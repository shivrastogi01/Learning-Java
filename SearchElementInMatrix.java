class SearchElementInMatrix {
    public boolean searchMatrix(int[][] a, int key)  // key=target
    {
        int x=0,m=0,i=0,j=a.length-1,c=a[0].length-1;
        
        // using binary search technique row wise and column=0
        while(i<=j)
        {
            m=(i+j)/2;  // m=mid;
            
            if(key==a[m][0] || key==a[m][c])
                return true;
            
            // check if the target element is greater than a[m][0]
            //  and smaller than last element in the same row
            else if(key>a[m][0] && key<a[m][c]) 
            {
                x=m;
                break;      // target may be present
            }
            else if(key<a[m][0])
                j=m-1;
            else
                i=m+1;
        }
        j=0;
        
        while(j<=c)
        {
            m=(j+c)/2;
            
            if(a[x][m]==key)
                return true;
            else if(a[x][m]<key)
                j=m+1;
            else 
                c=m-1;
        }
        
        // Opps element is not present
        return false;    
    }
}
