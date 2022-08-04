class MostStoneRemoveFromSameRowColumn{
    int n = 0;
    
    public int removeStones(int[][] stones) {
        Map<String, String> parent = new HashMap<>();
        n = stones.length;
        
        for (int[] stone : stones) {
            String s = stone[0] + " " + stone[1];
            parent.put(s, s);
        }
        
        for (int[] stone1 : stones) {
            String s1 = stone1[0] + " " + stone1[1];
            for (int[] stone2 : stones) {
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    String s2 = stone2[0] + " " + stone2[1];
                    union(s1, s2, parent);
                }
            }
        }
        
        return stones.length - n;
    }
    
    private void union(String s1, String s2, Map<String, String> parent) {
        String p1 = findParent(s1, parent);
        String p2 = findParent(s2, parent);

        if (!p1.equals(p2)) {
            n--;
            parent.put(p1, p2);
        }
    }
    
    private String findParent(String s, Map<String, String> parent) {
        while (!parent.get(s).equals(s)) {
            s = parent.get(s);
        }
        
        return s;
    }
}