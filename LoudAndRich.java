class LoudAndRich{
    int res=0;
    int comp=0;
    public int[] loudAndRich(int[][] richer, int[] loud) {
        int n = loud.length;
        int [] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=i;
        }
        int [][] graph = new int[n][n];
        if(graph[0].length ==0 || n==1)
            return answer;
        for(int [] rich:richer){
            graph[rich[1]][rich[0]]=1;
        }
        
        for(int i=0;i<n;i++){
            int [] visited = new int[n];
            comp=loud[i];
            res=i;
            DFS(graph, i, visited,loud);
            answer[i]=res;
        }
        return answer;
    }
    public void DFS(int [][] graph,int src,int [] visited,int [] loud){
        visited[src]=1;
        
        if(loud[src]<comp){

            comp=Math.min(comp,loud[src]);
            res=src;
        }
        for(int i=0;i<graph[src].length;i++){
            if(visited[i]==0 && graph[src][i]==1)
                DFS(graph, i, visited,loud);
        }
    }
}