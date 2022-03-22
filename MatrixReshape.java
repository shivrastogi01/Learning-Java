class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows1 = mat.length;
        int cols1 = mat[0].length;
		int noofelement = rows1 * cols1;
        if (noofelement != r * c) {
            return mat;
        }
		
        int[][] newmatrix = new int[r][c];
        for (int i = 0; i < noofelement; i++) {
			
            newmatrix[i / c][i % c] = mat[i / cols1][i % cols1];
        }
        return newmatrix;
    }
}