class WaterAndJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity)
            return false;
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        int[] dirs = new int[]{jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity};
        queue.offer(0);
        visited.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int curr = queue.poll();
                if (curr == targetCapacity)
                    return true;
                for(int dir:dirs){
                    int newCurr = curr + dir;
                    if(newCurr > 0 && newCurr <= (jug1Capacity + jug2Capacity) && !visited.contains(newCurr)){
                        queue.add(newCurr);
                        visited.add(newCurr);
                    }
                }
            }
        }
        return false;
    }
}