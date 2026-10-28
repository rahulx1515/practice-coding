class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return sum(grid, 0, 0, dp);

    }

    public int sum(int[][] grid, int cr, int cc, int[][] dp) {
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc];
        }
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        int l = sum(grid, cr + 1, cc, dp);
        int r = sum(grid, cr, cc + 1, dp);
        return dp[cr][cc] = grid[cr][cc] + Math.min(r, l);

    }
}