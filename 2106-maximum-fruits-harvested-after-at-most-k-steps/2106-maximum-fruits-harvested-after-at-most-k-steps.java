class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int n = fruits.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }

        int ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
             while (left <= right && !canReach(
                    fruits[left][0],
                    fruits[right][0],
                    startPos,
                    k)) {
                left++;
            }
            if (left <= right) {
                ans = Math.max(ans,
                        prefix[right + 1] - prefix[left]);
            }
        }
        return ans;
    }
    private boolean canReach(int left, int right,
                             int startPos, int k) {

        if (right <= startPos) {
            return startPos - left <= k;
        }
        if (left >= startPos) {
            return right - startPos <= k;
        }
        int leftDist = startPos - left;
        int rightDist = right - startPos;
        int steps1 = 2 * leftDist + rightDist;
        int steps2 = leftDist + 2 * rightDist;
        return Math.min(steps1, steps2) <= k;
    }
}