class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //BFS
        
        //maintain a visited array
        boolean[] vis = new boolean[rooms.size()];
        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(0); //add the room 0 in the queue
        
        while(!qu.isEmpty()){
            Integer roomAllowed = qu.remove();
            
            //if the room is already visited, then reject and move forward
            if (vis[roomAllowed])
                continue;
            
            //mark this room as visited
            vis[roomAllowed] = true;
            //get hold of key list in that room
            List<Integer> keyList = rooms.get(roomAllowed);
            for (int key : keyList){
                //if the room is not visited, then only add it in the Queue
                if (!vis[key])
                    qu.add(key);
            }
        }
        
        //Iterate over the boolean array
        //if we find any room unvisited then we return false
        for (boolean flag : vis){
            if (!flag)
                return false;
        }
        //else we return true
        return true;
    }
}