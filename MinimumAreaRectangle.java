class MinimumAreaRectangle {
    private int[][] points;
    
    public double minAreaFreeRect(int[][] points) {
        this.points = points;
        
        Map<Pair<Double, Double>, Map<Long, List<Pair<Integer, Integer>>>> centerDiagLenLines = new HashMap();
        
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                
                Pair<Double, Double> center = getCenter(point1, point2);
                long len = getLen(point1, point2);
                
                centerDiagLenLines.computeIfAbsent(center, k -> new HashMap<Long, List<Pair<Integer, Integer>>>()).computeIfAbsent(len, k -> new ArrayList<Pair<Integer, Integer>>()).add(new Pair(i,j));
            }
        }
        
        double minArea = Double.MAX_VALUE;
        
        for(Pair<Double, Double> c: centerDiagLenLines.keySet()) {
             Map<Long, List<Pair<Integer, Integer>>> mp = centerDiagLenLines.get(c);
            Set<Long> keySet = mp.keySet();
            for(Long l: keySet) {
                List<Pair<Integer, Integer>> lines = mp.get(l);
                if(lines.size() < 2) continue;
                
                for(int i = 0; i < lines.size(); i++) {
                    for(int j = i + 1; j < lines.size(); j++) {
                        minArea = Math.min(minArea, getArea(lines.get(i), lines.get(j)));
                    }
                }
                
            }
        }
        
        return minArea == Double.MAX_VALUE? 0: minArea;
    }
    
    private Pair<Double, Double> getCenter(int[] point1, int[] point2) {
        return new Pair((point1[0] + point2[0])/2.0, (point1[1] + point2[1])/2.0);
    }
    
    private long getLen(int[] point1, int[] point2) {
        int xDiff = point1[0] - point2[0];
        int yDiff = point1[1] - point2[1];
        return xDiff*xDiff + yDiff*yDiff;
    }
    
    private double getArea(Pair<Integer, Integer> line1, Pair<Integer, Integer> line2) {
        int[] line1Pt1 = points[line1.getKey()];
        int[] line1Pt2 = points[line1.getValue()];

        int[] line2Pt1 = points[line2.getKey()];
        int[] line2Pt2 = points[line2.getValue()];
        
        double widthPow = Math.pow(line2Pt1[0] - line1Pt1[0], 2) + Math.pow(line2Pt1[1] - line1Pt1[1], 2);
        double lenPow = Math.pow(line2Pt1[0] - line1Pt2[0], 2) + Math.pow(line2Pt1[1] - line1Pt2[1], 2);
        
        return Math.sqrt(widthPow)*Math.sqrt(lenPow);
    }
}