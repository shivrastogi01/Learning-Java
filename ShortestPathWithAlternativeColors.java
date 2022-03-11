class ShortestPathWithAlternativeColors{
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Edge>> graph = new ArrayList<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
		// Color 1 denotes red and -1 denotes blue
        for(int i = 0; i < redEdges.length; i++) {
            graph.get(redEdges[i][0]).add(new Edge(redEdges[i][1], 1, 0));
        }
        for(int i = 0; i < blueEdges.length; i++) {
            graph.get(blueEdges[i][0]).add(new Edge(blueEdges[i][1], -1, 0));
        }
        
        ArrayDeque<Edge> queue = new ArrayDeque<>();
		
		// 2d boolean visited array simply marks the node as visited as per it's color
		// We need to use the vertex and the color code + 1 for marking visited
		// If the color is blue (-1), it will be marked as visited in isVisited[node][0]      ---(-1 + 1)
		// Else if the color is red (1), it will be marked as visited in isVisited[node][2]  ---(1 + 1)
        boolean[][] isVisited = new boolean[n][3];
		
        Arrays.fill(ans, -1);
        queue.add(new Edge(0, 1, 0));  // Adding source 0 for beginning edges red in color
        queue.add(new Edge(0, -1, 0));  // Adding source 0 for beginning edges blue in color
        
		// BFS
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();
			
			 // Because two answers are possible. One alternate color path starting with edge in red and other in blue color. 
			 // We store the minimum of both
            ans[edge.vertex] = ans[edge.vertex] == -1 ? edge.distance : Math.min(ans[edge.vertex], edge.distance);
			
            isVisited[edge.vertex][edge.color + 1] = true;
            
            for(Edge neighbour : graph.get(edge.vertex)) {
                if(!isVisited[neighbour.vertex][neighbour.color + 1] && neighbour.color == -edge.color) {
                    queue.add(new Edge(neighbour.vertex, neighbour.color, edge.distance + 1));
                }
            }
        }
        
        return ans;
    }
    
	// Edge class storing nodes with red and blue color
    private class Edge {
        int vertex, color, distance;
        public Edge(int vertex, int color, int distance) {
            this.vertex = vertex;
            this.color = color;
            this.distance = distance;
        }
    }
}