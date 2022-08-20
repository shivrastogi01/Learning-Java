class MinimumNumberOfRefilingStops {
    public int minRefuelStops(int target, int currFuel, int[][] stations) {
	
        if(currFuel >= target) return 0;
        
        int stops = 0, dis = currFuel; // dis I can travel ahead
		
		// maxheap -> max fuel station at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2)->{
            return Integer.compare(s2[1], s1[1]);
        });
        
        int i=0, n = stations.length, pS = 0;
		
        while(dis < target) {
			// if I have enough fuel to reach to the next station from the stoppage point
            while(i<n && dis >= (stations[i][0]-pS)) {
                pq.add(stations[i]);
                i++;
            }
            if(pq.isEmpty()) return -1;
			
            int[] refillAt = pq.poll();
			
            // dis I can travel ahead = remaining fuel + amount refilled
			// remaining fuel = fuel i started with - distance I travelled ahead from previous stoppage
            dis = dis-(refillAt[0]-pS) + refillAt[1];
			
            // dis I need to travel more
            target = target-(refillAt[0]-pS);
            pS = refillAt[0];
            stops++;
        }
        return stops;
    }
}