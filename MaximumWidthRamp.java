class MaximumWidthRamp{
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums.length; i++)
            if(stack.isEmpty() || nums[i] < nums[stack.peek()])
                stack.push(i);
       
        int ans = 0;
        
        for(int i=nums.length-1; i>=0; i--)
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()])
                ans = Math.max(ans, i - stack.pop());
        
        return ans;
    }
}