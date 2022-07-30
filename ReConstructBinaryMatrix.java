class ReConstructBinaryMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
       
        var matrix = new ArrayList<List<Integer>>();
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        var upperSum = 0;
        var lowerSum = 0;
        
        for (var i = 0; i < colsum.length; i++) {
            
            var upperVal = -1;
            var lowerVal = -1;
            
            if (colsum[i] == 2) {
                upperVal = lowerVal = 1;
            }
            else if (colsum[i] == 0) {
                upperVal = lowerVal = 0;
            }
            
            upperSum += upperVal == -1? 0: upperVal;
            lowerSum += lowerVal == -1? 0: lowerVal;
            
            matrix.get(0).add(upperVal);
            matrix.get(1).add(lowerVal);
        }
        
        for (var i = 0; i < colsum.length; i++) {
            if (matrix.get(0).get(i) == -1) {
                if (upperSum < upper) {
                    upperSum ++;
                    matrix.get(0).set(i, 1);
                    matrix.get(1).set(i, 0);
                }
                else if (lowerSum < lower) {
                    lowerSum++;
                    matrix.get(0).set(i, 0);
                    matrix.get(1).set(i, 1);
                }
                else {
                    return new ArrayList<List<Integer>>(); 
                }
            }
        }
        
        return upperSum == upper && lowerSum == lower? matrix
            : new ArrayList<List<Integer>>();
    }
}