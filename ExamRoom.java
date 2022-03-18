class ExamRoom {
    TreeSet<Integer> set;
    int capacity = 0;
    public ExamRoom(int n) {
        set = new TreeSet<Integer>();
        capacity = n;
    }
    
    public int seat() {
        int seatNumber = 0;
        if(set.isEmpty()) {
            set.add(seatNumber);
        } else {
               Integer prev = null;
               int maxDistance = set.first();
               for(int seat : set) {
                    if(prev != null) {
                        int distance = (seat - prev)/2;
                        if(distance > maxDistance) {
                            maxDistance = distance;
                            seatNumber = prev + distance;
                        }
                    }
                    prev = seat;
               }
               if(maxDistance < capacity-1-set.last()){
                seatNumber = capacity-1;
               }
               set.add(seatNumber);
        }
        return seatNumber;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}