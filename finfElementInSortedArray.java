import java.util.*;
class finfElementInSortedArray {
    static int findSingleElement(int nums[]) {
        
        int low = 0;
        int high = nums.length - 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                // Checking whether we are in right half
                if (nums[mid] != nums[mid + 1]) 
                    
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            }
        }
        return nums[low];
    }

    public static void main(String args[]) {

        int arr[] = {1,1,2,3,3,4,4,8,8};
        
        int elem = findSingleElement(arr);
        
        System.out.println("The single occurring" + 
         " element is " + elem);

    }
}