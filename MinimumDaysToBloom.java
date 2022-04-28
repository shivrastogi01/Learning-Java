class MinimumDaysToBloom {
  public int minDays(int[] bloomDay, int m, int k) {
        
        int len = bloomDay.length;
        
        //If array size is less than the number of bouquets we need to create then return error.
        if(len < (m * k))
            return -1;
        
        //Determine low and high bounds. 
        //low - smallest day in array
        //high - largest day in array
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        
        while(low < high) {

            //Calculate the mid (candidate day) 
            int mid = low + (high - low)/2;
            
            //Get the bouquet count. 
            int bouquet_count = count_bouquets(bloomDay, mid, k);
            
            //If our count is greater than m then set the right bound. 
            if(bouquet_count >= m) {
                high = mid;
            } else {
                //else our bouquet is too small so increase the lower bound. 
                low = mid + 1;
            }
            
        }
        return low;
        
    }
    
    //Get the number of bouquets of size k, given a candidate day. 
    int count_bouquets(int[] bloomDay, int candidate_day, int k) {
        
        int bloom_count = 0;
        int bouquet_count = 0;
        
        for(int bday : bloomDay) {    
            if(bday <= candidate_day) {
                bloom_count++;
            } else {
                //If the days aren't consecutive reset our count. 
                bloom_count = 0;
            }
            
            //If our count matches the bouquet size reset the counter and increment the bouquet size. 
            if(bloom_count == k) {
                bloom_count = 0;
                bouquet_count++;
            }
            
        }
        return bouquet_count;
        
    }
}