class CheapestFlightWithKStop {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] dp = new int[k + 1][n];
        
        // Only 'src' can be reached with 0 cost and 0 stops. Everything else, unknown.
        for (int stops = 0; stops <= k; stops++) {
            for (int city = 0; city < n; city++) {
                if (city == src) dp[stops][city] = 0;
                else dp[stops][city] = Integer.MAX_VALUE;
            }
        }

        // For 0 stops, we can only reach cities adjacent to 'src'.
        for (int[] flight : flights) {
            int source = flight[0], dest = flight[1], cost = flight[2];
            if (source == src) dp[0][dest] = cost;
        }
        
        for (int stops = 1; stops <= k; stops++) {

            for (int city = 0; city < n; city++) dp[stops][city] = dp[stops - 1][city];
            
            for (int[] flight : flights) {
                
                int source = flight[0], dest = flight[1], cost = flight[2];

                if (dp[stops - 1][source] == Integer.MAX_VALUE) continue;
                
                // If we allow 'source' city to be a stop, can we reach 'dest' with smaller cost?
                if (dp[stops - 1][source] + cost < dp[stops][dest]) {
                    dp[stops][dest] = dp[stops - 1][source] + cost;
                }
            }

        }
        
        // Minimal cost to reach 'dst' when allowed upto 'k' stops.
        return dp[k][dst] == Integer.MAX_VALUE? -1 : dp[k][dst];
    }
}