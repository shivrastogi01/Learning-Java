class PrisonCell {
public int[] prisonAfterNDays(int[] cells, int n) {
    if(n == 0) return cells;
    HashMap<Integer, Integer> pn = new HashMap<>();
    
    int currCode = cellsToInt(cells);
    for(int j = 1; j <= n; j++){
        // System.out.println(currCode + "," + Arrays.toString(cells));
        cells = getNextCell(cells);
        int nextCode = cellsToInt(cells);
        Integer cache = pn.get(nextCode);
        currCode = nextCode;

        if(cache != null && cache != j){
            // // System.out.println(currCode + "," + Arrays.toString(cells));
            // // System.out.format("1N: %d, J: %d, Cache: %d\n", n, j, cache);
            n = (n-j)%(j-cache);
            // System.out.format("2N: %d, J: %d, Cache: %d\n", n, j, cache);

            j = 0;
            return prisonAfterNDays(cells, n);

        }
        pn.putIfAbsent(nextCode, j);            
    }
    return cells;
    
}
public int[] getNextCell(int[] cells){
    int[] cell2 = new int[cells.length];
    cell2[0] = 0;
    cell2[cells.length-1] = 0;
    for(int i = 1; i < cell2.length-1; i++){
        cell2[i] = (cells[i-1] == cells[i+1])? 1: 0;
    }
    return cell2;
}
public int cellsToInt(int[] cells){
    int sum = 0; int shift = 1;
    for(int i = 0; i < cells.length; i++){
        sum += cells[i] * shift;
        shift <<= 1;
    }
    return sum;
}
public int[] intToCell(Integer code, int[] cells){
    int shift = 1;
    for(int i = 0; i < cells.length; i++){
        cells[i] = code & shift;
        shift <<= 1;
    }
    return cells;
}
}