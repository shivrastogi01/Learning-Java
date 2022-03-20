class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int countZero = 0;
        int index = 0;
        for(int k = 0 ; k < nums.length ; k++){
            if(nums[k] != 0){
                nums[index] = nums[k];
                index++;
            }else{
                countZero++;
            }            
        }
        
        int lastIndex = nums.length-1;
        for(int h = 0 ; h < countZero; h++){
            nums[lastIndex--] = 0;
        }
    }
}