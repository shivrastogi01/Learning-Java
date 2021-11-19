class LuckyNumberInMatrix{//maximum number in row and column
    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> lucky = new ArrayList<>();
        int min;
        for(int i = 0; i < matrix.length; i++){
            min = minInRow(matrix, i);
            if (isMaxInCol(matrix, i, min)){
                lucky.add(matrix[i][min]);
            }
        }
        return lucky;
    }
    
    
    int minInRow(int[][] matrix, int row){
        int min = matrix[row][0];
        int index = 0;
        for(int i = 1; i < matrix[row].length; i++){
            if(matrix[row][i] < min){
                min = matrix[row][i];
                index = i;
            }
        }
        return index;
    }
    
    boolean isMaxInCol(int[][] matrix, int row, int col){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > matrix[row][col] ){
                return false;
            }
        }
        return true;
    }
}