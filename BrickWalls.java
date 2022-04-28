class BrickWalls {
    public int leastBricks(List<List<Integer>> wall) {
        //here, the least number of bricks will be the same as the most number of spaces
		//and its pretty obviuos that min bricks crossed = max empty spaces crossed
        
        int res = 0;
            
		//we will take a hashmap, to track the frequency of spaces that we can have
		//we will get this frequency by simply doing a preFix sum of the current rows bricks
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < wall.size(); i++){
            //inner loops 
            int preSum = 0;
            
            List<Integer> currList = wall.get(i);
            for(int j = 0; j < currList.size() - 1; j++){
                preSum += currList.get(j);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
                
                //checking if its the largest
                res = Math.max(res, map.get(preSum));
            }
        }
		
        //now, we've got the frequency of the most spaces that we can pass through by a single line
		//so simply return the wall size - space size to get the minimum number of bricks that you've cutted
        return (wall.size() - res);
    }
}