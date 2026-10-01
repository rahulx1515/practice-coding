class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> squares = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        int maxHeight = 0;

        for (int[] p : positions) {
            int left = p[0];
            int side = p[1];
            int right = left + side;

            int height = side;

            for (int[] sq : squares) {
                int prevLeft = sq[0];
                int prevRight = sq[1];
                int prevHeight = sq[2];

                if (left < prevRight && right > prevLeft) {
                    height = Math.max(height, prevHeight + side);
                }
            }

            squares.add(new int[]{left, right, height});

            maxHeight = Math.max(maxHeight, height);
            ans.add(maxHeight);
        }

        return ans;
    }
}