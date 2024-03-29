class NextGreaterElement{
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*nums.length-1; i >=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length]) // check if the current element is greater than the elements in the stack.
                    stack.pop(); //pop the smaller elements
            ans[i%nums.length] = stack.empty() ? -1 : stack.peek(); // here, we update the answer in our output arrray with the condition as if the stack is empty i.e for current element there is no element greater than this so we put -1 or if there is, then it must be on top of the stack.
            stack.push(nums[i%nums.length]); // Finally, we push the current element in the stack.
         }
     return ans;
    }
}