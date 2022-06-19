class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
		// max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double x = (double)b[0] / b[1];
            double y = (double)a[0] / a[1];
            if (x > y)
				return 1;  // lambda exp. returns b(param of lambda exp), if the value is positive. Hence returned b.
            return -1;  // lambda exp. returns a(param of lambda exp), if the value is negative. Hence returned a.
        });
        
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = i+1 ; j < arr.length ; j++) {
                pq.offer(new int[]{arr[i], arr[j]});
				// Avoiding size greater than k
                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }
}