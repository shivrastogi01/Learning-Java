class MyCircularDeque {
    int[] nums;
    int len = 0;
    int i = 0;
    int j = 1;
    public MyCircularDeque(int k) {
        this.len = k;
        this.nums = new int[k];
        Arrays.fill(nums, -1);
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        nums[i] = value;
        i = getPrevIndex(i);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        nums[j] = value;
        j = getNextIndex(j);
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        i = getNextIndex(i);
        nums[i] = -1;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        j = getPrevIndex(j);
        nums[j] = -1;
        return true;            
    }
    
    public int getFront() {
        int x = getNextIndex(i);
        return nums[x];
    }
    
    public int getRear() {
        int x = getPrevIndex(j);
        return nums[x];
    }
    
    public boolean isEmpty() {
        int x = getNextIndex(i);
        int y = getPrevIndex(j);
        return  nums[x] == -1 && nums[y] == -1;
    }
    
    public boolean isFull() {
        return nums[i] != -1 && nums[j] != -1;
    }
    
    private int getNextIndex(int x) {
        return x == len -1 ? 0 : x + 1;
    }
    
    private int getPrevIndex(int x) {
        return x == 0 ? len - 1 : x - 1;
    }
