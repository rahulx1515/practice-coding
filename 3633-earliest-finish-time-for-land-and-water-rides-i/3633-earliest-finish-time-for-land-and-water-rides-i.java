class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int a = calc(landStartTime, landDuration, waterStartTime, waterDuration);
        int b = calc(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(a, b);
    }

    private int calc(int[] s1, int[] d1, int[] s2, int[] d2) {
        int minEnd = Integer.MAX_VALUE;

        for (int i = 0; i < s1.length; i++) {
            minEnd = Math.min(minEnd, s1[i] + d1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s2.length; i++) {
            int finish = Math.max(minEnd, s2[i]) + d2[i];
            ans = Math.min(ans, finish);
        }

        return ans;
    }
}