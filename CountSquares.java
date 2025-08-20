class CountSquares {
    public int countSquares(int[][] matrix) {
        int ret = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int top = (i == 0) ? 0 : matrix[i - 1][j];
                    int left = (j == 0) ? 0 : matrix[i][j - 1];
                    int diag = (i == 0 || j == 0) ? 0 : matrix[i - 1][j - 1];

                    matrix[i][j] += Math.min(Math.min(top, left), diag);
                    ret += matrix[i][j];
                }
            }
        }
        return ret;
    }
}
