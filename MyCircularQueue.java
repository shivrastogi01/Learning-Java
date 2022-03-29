class MyCircularQueue {
    
    private int[] array;
    private int backPos = 0;
    private int frontPos = 0;

    public MyCircularQueue(int k) {
        array = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        int index = backPos % array.length;
        array[index] = value;
        backPos++;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        
        frontPos++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return array[frontPos % array.length];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return array[(backPos - 1) % array.length];
    }
    
    public boolean isEmpty() {
        return backPos == frontPos;
    }
    
    public boolean isFull() {
        return backPos - frontPos >= array.length;
    }
}