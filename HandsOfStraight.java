class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int num: hand)
            minHeap.offer(num);
        while(!minHeap.isEmpty()){
            int start = minHeap.poll();
            for (int i =1; i< groupSize; i++)
                if (!minHeap.remove(start + i))
                    return false;
        }
        return true;
    }
}