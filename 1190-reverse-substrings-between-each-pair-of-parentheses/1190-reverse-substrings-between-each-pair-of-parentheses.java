import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(cur.toString());
                cur.setLength(0);
            } 
            else if (c == ')') {
                cur.reverse();
                cur.insert(0, st.pop());
            } 
            else {
                cur.append(c);
            }
        }

        return cur.toString();
    }
}