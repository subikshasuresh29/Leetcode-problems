class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int left = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, last[s.charAt(i)]);
            ans = Math.max(ans, i - left + 1);
            last[s.charAt(i)] = i + 1;
        }

        return ans;
    }
}
   
    
