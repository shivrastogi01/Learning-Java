class FindPeakElement {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int start = 0, end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int row=0;
            for(int i=0;i<m;i++)
                if(mat[row][mid]<mat[i][mid])
                    row=i;
            if((mid==0 || mat[row][mid]>mat[row][mid-1]) && (mid==n-1 || mat[row][mid]>mat[row][mid+1]))
                return new int[]{row,mid};
            if(mid>0 && mat[row][mid]<mat[row][mid-1])
                end = mid-1;
            else
                start = mid+1;
        }
        return new int[]{-1,-1};
    }
}