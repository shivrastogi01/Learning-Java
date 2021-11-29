class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int curCount=1;
        int n=nums.length;
        int[] cc=new int[n];
        for(int i=0;i<n;i++)
            cc[i]=0;
        
        
        
        while(true)
        {
            //Find unvisited index
            int idx=-1;
            for(int i=0;i<n;i++)
            {
                if(cc[i]==0)
                {
                    idx=i;
                    break;
                }
            }
            if(idx==-1)
                return false;
            
            int prevIdx=idx;
            cc[prevIdx]=curCount;
            
            while(true)
            {
                int nextIdx=((prevIdx+nums[prevIdx])%n+n)%n;
                if(cc[nextIdx]==curCount&&nextIdx!=prevIdx)
                {
                    //found a circle
                    return true;
                }
                else if(nextIdx==prevIdx)
                {
                    //fake circle, start over
                    curCount++;
                    break;
                }
                else if(cc[nextIdx]>0&&cc[nextIdx]!=curCount)
                {
                    //hit an element not leading to a circle, start over
                    curCount++;
                    break;
                }
                //below here we hit an element we never visited
                else if((nums[prevIdx]>0&&nums[nextIdx]<0)||(nums[prevIdx]<0&&nums[nextIdx]>0))
                {
                    //different sign, contine but increase the count
                    curCount++;
                    cc[nextIdx]=curCount;
                    prevIdx=nextIdx;
                    
                    continue;
                }
                else
                {
                    //continue with next element search for circle
					cc[nextIdx]=curCount;
                    prevIdx=nextIdx;
                    
                    continue;
                }
            }
            
            
            
        }
        
    }
}