class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solve(nums1, nums2, 0, 0, dp);
    }

    public int solve(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + solve(nums1, nums2, i + 1, j + 1, dp);
        } else {
            int a = solve(nums1, nums2, i + 1, j, dp);
            int b = solve(nums1, nums2, i, j + 1, dp);

            dp[i][j] = Math.max(a, b);
        }

        return dp[i][j];
    }
}
