class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;

        if (n == 2) return -1;

        char minChar = 'z';
        char maxChar = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }

        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }

        int minCount = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == minChar) minCount++;
            if (c == maxChar) maxCount++;
        }

        if (s.charAt(0) == maxChar && maxCount == 1 && 
            s.charAt(n - 1) == minChar && minCount == 1) {
            return 3;
        }

        return 2;
    }
}