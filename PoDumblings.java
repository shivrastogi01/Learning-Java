public int  dumplings(int input1 ,int [] input2) {
        
     
        int max = -1;
        for(int i = 0; i <input1 ; i++)
        {
            max = Math.max(max, input2[i]);
        }
   
        int []freq = new int[max + 1];
         
        for(int i = 0; i < input1; i++)
        {
            freq[input2[i]]++;
        }
     
        int ans = 0, i=max;
            while(i>0){
      
            if(freq[i] > 0){
          
                ans += i;
                              freq[i-1]--;
            
                freq[i]--;
            }else{               
               
                i--;
            }           
        }
         
        return ans;
    }