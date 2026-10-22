class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int [] a: dp){
            Arrays.fill(a, -1);
        }
        return minOpr(word1, word2, 0, 0, dp);
        
    }
    public static int minOpr(String s, String t, int i, int j, int[][] dp){
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = minOpr(s, t, i+1, j+1, dp);
        }
        else {
            int D=minOpr(s, t, i+1, j, dp);
            int R=minOpr(s, t, i+1, j+1, dp);
            int I=minOpr(s, t, i, j+1, dp);
            return dp[i][j] = Math.min(R, Math.min(D, I)) + 1;
        }
    }
}