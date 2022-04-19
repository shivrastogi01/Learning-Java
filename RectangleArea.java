class RectangleArea {
    int MOD = 1_000_000_007;
    int START = 0;
    int END = 1;
    public int rectangleArea(int[][] rects) {
        List<int[]> recs = new ArrayList<>();
        for(int i = 0; i < rects.length; i++)
        {
            recs.add(new int[]{rects[i][0], START, i});
            recs.add(new int[]{rects[i][2], END, i});
        }
        
        long res = 0;
        Collections.sort(recs, (i1,i2)->{
            return i1[0] - i2[0];
        });
        
        int prev = 0;
        List<int[]> actives = new ArrayList<>();
        for(int i = 0; i < recs.size(); i++)
        {
            int[] cur = recs.get(i);            
            if(cur[0]!=prev)
            {
                long width = cur[0] - prev;
                long height = getHeight(actives, rects);
                prev = cur[0];
                res += width * height;
                res %= MOD;
            }
            
            if(cur[1]==START)
            {
                actives.add(cur);
            }
            else
            {
                for(int j = 0; j < actives.size(); j++)
                {
                    if(actives.get(j)[2]==cur[2])
                    {
                        actives.remove(j);
                        break;
                    }
                }
            }
        }
        
        return (int)res;
    }
    
    public long getHeight(List<int[]> actives, int[][] rects)
    {
        Collections.sort(actives, (i1, i2) -> rects[i1[2]][1] - rects[i2[2]][1]);
        long res = 0;
        int curl = -1, curr = -1;
        for(int i = 0; i < actives.size(); i++)
        {
            int[] cur = actives.get(i);
            int cury1 = rects[cur[2]][1];
            int cury2 = rects[cur[2]][3];
            if(cury1 > curr)
            {
                res += (curr - curl);
                
                curl = cury1;
                curr = cury2;
            }
            else
            {
                curr = Math.max(curr, cury2);
            }
        }
        
        res += (curr - curl);
        return res;
    }
}