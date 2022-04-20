class GridIllumination {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //Lights that are turned on. Identified by the entry number
        //entry = n*i + j
        Set<Long> lights = new HashSet<>();
        //columns/vertical lines
        Map<Integer,Integer> cols = new HashMap<>();
        
        //rows/horizontal lines
        Map<Integer,Integer> rows = new HashMap<>();
        
        //k-diagonals: from up left to lower right
        Map<Integer,Integer> kDiagonals = new HashMap<>();
        
        //skew-diagonals: from up right to lower left
        Map<Integer,Integer> skewDiagonals = new HashMap<>();
        
        //populate the hashmaps based on the lights that are turned on
        for(int[] lamp: lamps){
            int r = lamp[0], c = lamp[1];
            long light = (long)(n*r+c);
            if(lights.contains(light))continue;
            
            lights.add(light);
            cols.put(c,cols.getOrDefault(c,0)+1);
            rows.put(r,rows.getOrDefault(r,0)+1);
            kDiagonals.put(r-c,kDiagonals.getOrDefault(r-c,0)+1);
            skewDiagonals.put(r+c, skewDiagonals.getOrDefault(r+c,0)+1);
        }
       
        int[] result = new int[queries.length];
        int index = 0;
        int[][] vectors = {{0,0},{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        
        //evaluate the queries
        for(int i=0; i<queries.length; i++){
            
            int r = queries[i][0], c = queries[i][1];
            boolean turnedOn = cols.getOrDefault(c,0)>0 || rows.getOrDefault(r,0)>0 || 
                                kDiagonals.getOrDefault(r-c,0)>0 || skewDiagonals.getOrDefault(r+c,0)>0;
            result[i] = turnedOn?1:0;
            
            //turn off the light and its neighbours if turned on
            for(int[] v: vectors ){
                int rr = r+v[0], cc = c+v[1];
                long light = (long)(n*rr+cc);
               
                if(rr<0 || rr >= n || cc < 0 || cc >= n)continue;
                if(!lights.contains(light))continue;
               
                lights.remove(light); 
                reduce(cols,cc);
                reduce(rows,rr);
                reduce(kDiagonals,rr-cc);
                reduce(skewDiagonals,rr+cc);
            }

        }
        
        return result;
    }
    private void reduce(Map<Integer,Integer> map, int key){
        map.put(key, map.getOrDefault(key,0)-1);
        if(map.get(key) < 1)map.remove(key);
    }
    
}