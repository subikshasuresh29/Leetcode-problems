class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = nums[curr];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}