import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // memo[r][c][d] stores the encoded destination (destR * n + destC), or -1 if out of bounds.
        int[][][] memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -2);
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                
                int rightDest = getDest(i, j + 1, 0, grid, memo, m, n);
                if (rightDest != -1) {
                    int nr = rightDest / n;
                    int nc = rightDest % n;
                    dp[nr][nc] = (dp[nr][nc] + dp[i][j]) % MOD;
                }

              
                int downDest = getDest(i + 1, j, 1, grid, memo, m, n);
                if (downDest != -1) {
                    int nr = downDest / n;
                    int nc = downDest % n;
                    dp[nr][nc] = (dp[nr][nc] + dp[i][j]) % MOD;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int getDest(int r, int c, int d, int[][] grid, int[][][] memo, int m, int n) {
        if (r >= m || c >= n) {
            return -1;
        }
        if (grid[r][c] == 0) {
            return r * n + c;
        }
        if (memo[r][c][d] != -2) {
            return memo[r][c][d];
        }

        int dest;
        if (d == 0) {
           
            dest = getDest(r + 1, c, 1, grid, memo, m, n);
        } else {
           
            dest = getDest(r, c + 1, 0, grid, memo, m, n);
        }

        return memo[r][c][d] = dest;
    }
}