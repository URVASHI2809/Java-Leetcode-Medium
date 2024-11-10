public class DiagonalTraverse {
        public int[] findDiagonalOrder(int[][] mat) {
            int n = mat.length; // Number of rows
            int m = mat[0].length; // Number of columns
            int r = 0, c = 0; // Starting position
            int[] ans = new int[m * n];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = mat[r][c];

                // Determine the direction based on the sum of current row and column indices
                if ((r + c) % 2 == 0) {
                    if (c == m - 1) {
                        r++;
                    } else if (r == 0) {
                        c++;
                    } else {
                        r--;
                        c++;
                    }
                } else {
                    if (r == n - 1) {
                        c++;
                    } else if (c == 0) {
                        r++;
                    } else {
                        r++;
                        c--;
                    }
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            DiagonalTraverse solution = new DiagonalTraverse();

            // Test case 1
            int[][] mat1 = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int[] result1 = solution.findDiagonalOrder(mat1);
            System.out.println("Diagonal Order of mat1: " + java.util.Arrays.toString(result1));  // Output: [1, 2, 4, 7, 5, 3, 6, 8, 9]

            // Test case 2
            int[][] mat2 = {
                    {1, 2},
                    {3, 4}
            };
            int[] result2 = solution.findDiagonalOrder(mat2);
            System.out.println("Diagonal Order of mat2: " + java.util.Arrays.toString(result2)); // Output: [1, 2, 3, 4]
        }
}
