class FurtherBuildingYouCanReach 
{
    public int furthestBuilding(int[] heights, int bricks, int ladders) 
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < heights.length-1; i++)
        {
            if(heights[i+1] <= heights[i]) 
                continue;
            q.add(heights[i+1] - heights[i]);
            if (q.size() > ladders)
            {
                bricks -= q.peek();
                q.poll();
                if (bricks < 0)
                    return i;
            }
        }
        return heights.length-1;
    }
}