class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        
        for (int i = 0; i < n; ++i) 
            graph.put(i, new ArrayList<>());
        
        for (int i = 0; i < edges.length; ++i) {
            int src = edges[i][0];
            int dest = edges[i][1];
            graph.get(src).add(new Pair(dest, succProb[i]));
            graph.get(dest).add(new Pair(src, succProb[i]));
        }
        
        PriorityQueue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        
        maxHeap.add(new Pair(start, 1.0));
        boolean[] visited = new boolean[n];
        double ans = 0.0;
        while(!maxHeap.isEmpty()) {
            Pair<Integer, Double> pair = maxHeap.poll();
            int src = pair.getKey();
            double cost = pair.getValue();
            if(visited[src]) {
                continue;
            }
            visited[src] = true;
            if(src == end) {
                return cost;
            }
            List<Pair<Integer, Double>> nbrs = graph.get(src);
            for(int i = 0; i < nbrs.size(); i++) {
                int nsrc = nbrs.get(i).getKey();
                double ncost= nbrs.get(i).getValue();
                if(!visited[nsrc]) {
                    maxHeap.add(new Pair(nsrc, cost * ncost));
                }
            }
        }
        return ans;
    }
}