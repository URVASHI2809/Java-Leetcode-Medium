class FirstCompleteIndex {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] rCnt = new int[row];
        int[] cCnt = new int[col];
        int[] pos = new int[row * col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pos[mat[i][j]] = i * col + j;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int p = pos[arr[i]];
            int r = p / col, c = p % col;
            if (++rCnt[r] == col || ++cCnt[c] == row) return i;
        }
        return arr.length - 1;
    }
}
