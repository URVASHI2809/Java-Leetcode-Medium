class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (Character.isDigit(ch)) {
                    int num = ch - '0';
                    if (rows[r][num]) return false;
                    if (cols[c][num]) return false;

                    int boxIdx = (r / 3) * 3 + (c / 3);
                    if (boxes[boxIdx][num]) return false;

                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[boxIdx][num] = true;
                }
            }
        }
        return true;
    }
}
