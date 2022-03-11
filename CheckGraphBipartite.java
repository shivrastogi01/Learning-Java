class CheckGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length;i++)
            if (color[i] == 0 && !dfs(graph, color, i, 1))
                return false;
        return true;
    }
    private boolean dfs(int[][] graph, int[] color, int v, int c){
        if (color[v] == 0)
            color[v] = c;
        else
            return color[v] == c;
        for(int neighbor: graph[v])
            if (!dfs(graph, color, neighbor, -c))
                return false;
        return true;
    }
}