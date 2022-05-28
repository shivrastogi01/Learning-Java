class PowerfulInteger{

public List<Integer> powerfulIntegers(int x, int y, int bound) {
    Map<Integer, Integer> xMap = new HashMap<>();
    Map<Integer, Integer> yMap = new HashMap<>();
    int xBound = findBound(x, bound, xMap);
    int yBound = findBound(y, bound, yMap);
    
    Set<Integer> collector = new HashSet<>();
    
    for(int i = 0; i <= xBound; i++){
        for(int j = 0; j <= yBound; j++){
            int sum = xMap.get(i) + yMap.get(j);
            if(sum <= bound){
                collector.add(sum);
            }else break;
        }
    }
    
    return new ArrayList<>(collector);
}


private int findBound(int base, int bound, Map<Integer, Integer> map){
    if(base == 1) {
        map.put(0, 1);
        return 0;
    }
    int i = 0;
    while(true){
        int result = (int)Math.pow(base, i);
        map.put(i,  result);
        if(result > bound) break;
        i++;
    }
    
    return i;
}
}