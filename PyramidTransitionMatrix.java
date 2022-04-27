class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int level = bottom.length();
        List<Character> pyramid = new LinkedList<Character>(); 
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)){
              map.put(key, new ArrayList<String>());  
            } 
            map.get(key).add(s);
        }
        for(int i=0; i<level; i++){
            pyramid.add(bottom.charAt(i));
        }        
        return compute(pyramid, allowed, map, level-1, level-1);
    }
    
    public boolean compute(List<Character> pyramid, List<String> allowed, Map<String, List<String>> map,  int level, int breadth){
        if(level == 0) return true;
        int size = pyramid.size();
        int prev = level;
        List<String> loop = map.get(pyramid.get(size-prev-1)+""+pyramid.get(size-prev));
        breadth--;
        if(loop != null){
            for(String i :loop){
                pyramid.add(i.charAt(2));               
                int nextLevel = breadth == 0? level-1: level;
                breadth = breadth == 0? nextLevel: breadth;   
                if(compute(pyramid, allowed,map, nextLevel, breadth)){
                    return true;
                }
                pyramid.remove(pyramid.size()-1);
            }
        }
        
        return false;     
        
    }
    
    
}