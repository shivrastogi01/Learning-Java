class CapacityToShippedPackage{
    public int shipWithinDays(int[] weights, int days) {
        int low=0;//max of all the weights-beacause atleast itni capacity to honi he chahiye ship ki nahi to ship he nahi kar sake heaviest product ko
        int high=0;//high ko basically sabka sum rkhte hai, so that agar hum chahe to ek din me he saara samaan ship kar de
        
        
        for(int w:weights){
            low=Math.max(w,low);
            high+=w;
        }
        
        //now lets binary search on the answer to find the least capacity
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int reqDays=requiredDays(weights,mid);
            if(reqDays<=days){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    
    
    
    
    int requiredDays(int[] weights,int capacity){
        //this function will tell us how many days we need with current capacity
        int currWeight=0;
        int days=1;
        for(int i=0;i<weights.length;i++){
            if(currWeight+weights[i]<=capacity){
                currWeight+=weights[i];
            }
            else{
                currWeight=weights[i];
                days++;
            }
        }
        return days;
    }
}