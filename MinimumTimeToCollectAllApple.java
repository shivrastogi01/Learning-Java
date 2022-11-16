class MinimumTimeToCollectAllApple
{
    public int minTime (int n, int[][] edges, List<Boolean> hasApple) 
    {
        ArrayList<ArrayList<Integer>> adjacencyList= new ArrayList<>();
        
        for (int i= 0; i< n; i++)
            adjacencyList.add(new ArrayList<>());//allocating the space for the vertex to store their adjacent vertex 
        
        //Creating the adjacency list from the edge list 
        for (int []edge: edges)
        {
            int u= edge[0];
            int v= edge[1];
            
            //undirected graph 
            adjacencyList.get(u).add(v);   
            adjacencyList.get(v).add(u);    
        }
        boolean visited[]= new boolean[n];//boolean visited array, so that we dont visit the same vertex again 
        return dfs(adjacencyList ,visited, hasApple, 0);//recursing down in depth of the tree and calculating the time while in postorder, like topological sort(iterative) 
    }
    public int dfs (ArrayList<ArrayList<Integer>> adjacencyList, boolean visited[], List<Boolean> hasApple, int source)
    {//preorder marking visited -> recursing in deapth -> postorder time calculation //Bottom Up Approach 
        visited[source]= true;//marking the current node as visisted 
        
        int totalTime= 0;//time possible 
        for (int vertex: adjacencyList.get(source)){//recursing down in deapth 
            if(visited[vertex] == false)//only visiting the unvisited node 
                totalTime+= dfs(adjacencyList, visited, hasApple, vertex);//calculating the time while we are backtracking  
        }
        
        if (source != 0 && (hasApple.get(source) || totalTime > 0))//we are not considering the starting vertex because we are calculating the total time from bottom to top //case-1) when the total time is greater than 0 then we would include that path(intution: apple already exists previously in the path)//case-2)we are considering the vertex with apple for total time calculation(intution: considering the edge)
           totalTime+= 2;//adding two because of 1)moving forward(arriving) 2)moving backward(returning) 
        return totalTime;//returning the total time to tell the current time status to the parent 
    }
}//Please do Upvote, it helps a lot 