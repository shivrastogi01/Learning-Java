class MaximumWaterInContainer {
    public int maxArea(int[] height) {
        int n, i, j, max=0, tmp, x, y;
        n = height.length;
        i = 0;
        j = n-1;
        while(i<j)
        {
            x = height[i];
            y = height[j];	
            tmp = (j-i)*Math.min(x,y);
            if(tmp>max)
                max = tmp;
            if(x>y)
                j--;
            else
                i++;
        }
        return max;
    }
}