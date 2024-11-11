public class SpiralMatrix {
        public static int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int num = 1;
            int row = 0, col = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int dirIndex = 0;

            while (num <= n * n) {
                matrix[row][col] = num++;
                int nextRow = row + directions[dirIndex][0];
                int nextCol = col + directions[dirIndex][1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                    dirIndex = (dirIndex + 1) % 4; // Change direction
                    nextRow = row + directions[dirIndex][0];
                    nextCol = col + directions[dirIndex][1];
                }
                row = nextRow;
                col = nextCol;
            }
            return matrix;
        }

        public static void main(String[] args) {
            int n = 3;
            int[][] result = generateMatrix(n);
            for (int[] row : result) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
}
