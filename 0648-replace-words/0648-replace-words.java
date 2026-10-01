class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");
        String ans = "";

        for (String word : words) {
            String root = word;

            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);

                if (set.contains(prefix)) {
                    root = prefix;
                    break;
                }
            }

            ans += root + " ";
        }

        return ans.trim();
    }
}