class MaximumJumps {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        
        if(n == 1)
            return 1;
        
        int ngel[] = getNGEL(arr,n);
        int nger[] = getNGER(arr,n);
        Integer dp[] = new Integer[n];
        int res = 0;
        for(int i = 0; i<n; i++) {
            res = Math.max(res,solve(i,arr,d,ngel,nger,dp));
        }
        
        return res;
    }
    
    int solve(int idx, int nums[], int d, int ngel[], int nger[], Integer dp[]) {
        if(dp[idx] != null)
            return dp[idx];
        
        int n = nums.length;
        int boundLeft = ngel[idx] == -1? Math.max(0,idx-d): Math.max(ngel[idx]+1,idx-d);
        int boundRight = nger[idx] == -1? Math.min(n-1,idx+d): Math.min(nger[idx]-1,idx+d);
        
        int ans = 1;
        for(int j = idx+1;j<=boundRight;j++) {
            ans = Math.max(ans,1 + solve(j,nums,d,ngel,nger,dp));
        }
        
        for(int j = idx-1;j>=boundLeft;j--) {
            ans = Math.max(ans,1 + solve(j,nums,d,ngel,nger,dp));
        }
        
        dp[idx] = ans;
        return ans;
    }
    
    int[] getNGEL(int nums[], int n) {
        int ngel[] = new int[n];
        Stack<Integer> st = new Stack<>();
        ngel[0] = -1;
        st.push(0);
        for(int i = 1; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
                st.pop();
            
            ngel[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        
        return ngel;
    }
    
    int[] getNGER(int nums[], int n) {
        int nger[] = new int[n];
        Stack<Integer> st = new Stack<>();
       
        st.push(n-1);
        for(int i = n-2;i>=0;i--) {
            while(!st.isEmpty() && nums[i]>nums[st.peek()])
                st.pop();
            
            nger[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        
        return nger;
        
    }
}