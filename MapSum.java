class MapSum {
    Map<String,Integer> mp;

    public MapSum() {
        mp = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        mp.put(key,val);
    }
    
    public int sum(String prefix) {
        int result = 0;
        for(Map.Entry<String,Integer> entry:mp.entrySet())
            if(entry.getKey().startsWith(prefix))
                result += entry.getValue();
        return result;
    }
}