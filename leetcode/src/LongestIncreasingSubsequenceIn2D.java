public class LongestIncreasingSubsequenceIn2D {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 0 },
                { 2, 1 },
        };
        int n = 2, m = 2;
        System.out.println(longestIncreasingSubsequenceIn2D(mat, n, m));
    }

    static int longestIncreasingSubsequenceIn2D(int[][] matrix, int N, int M) {
        // create a temporary 2D array to store the length of the longest increasing subsequence at cell [N]
        int[][] dp = new int[10][10];

        // assign all values in 2D array to -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        return longestIncreasingSubsequenceIn2DUtil(dp, matrix, N, M, 0, 0);
    }

    static int longestIncreasingSubsequenceIn2DUtil(int[][] dp, int[][] matrix, int N, int M, int x, int y) {
        if (dp[x][y] < 0) {
            int result = 0;

            // if at right bottom cell, return 1
            if (x == N - 1 && y == M - 1) {
                return dp[x][y] = 1;
            }

            // if at the corner of the matrix, the temporary result is 1
            if (x == N - 1 || y == M - 1) {
                result = 1;
            }

            // if value of the below cell is larger than current cell
            if (x + 1 < N && matrix[x][y] < matrix[x + 1][y]) {
                result = 1 + longestIncreasingSubsequenceIn2DUtil(dp, matrix, N, M, x + 1, y);
            }

            // if value of the right cell is larger than current cell
            if (y + 1 < M && matrix[x][y] < matrix[x][y + 1]) {
                result = Math.max(result, 1 + longestIncreasingSubsequenceIn2DUtil(dp, matrix, N, M, x, y + 1));
            }

            dp[x][y] = result;
        }

        return dp[x][y];
    }
}
