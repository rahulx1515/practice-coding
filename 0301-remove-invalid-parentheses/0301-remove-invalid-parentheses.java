class Solution {
    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder());

        return new ArrayList<>(ans);
    }

    void dfs(String s, int index, int left, int right,
             int balance, StringBuilder curr) {

        if (index == s.length()) {
            if (left == 0 && right == 0 && balance == 0) {
                ans.add(curr.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if (c == '(' && left > 0) {
            dfs(s, index + 1, left - 1, right, balance, curr);
        }

        if (c == ')' && right > 0) {
            dfs(s, index + 1, left, right - 1, balance, curr);
        }

        curr.append(c);

        if (c != '(' && c != ')') {
            dfs(s, index + 1, left, right, balance, curr);
        } else if (c == '(') {
            dfs(s, index + 1, left, right, balance + 1, curr);
        } else if (balance > 0) {
            dfs(s, index + 1, left, right, balance - 1, curr);
        }

        curr.deleteCharAt(curr.length() - 1);
    }
}