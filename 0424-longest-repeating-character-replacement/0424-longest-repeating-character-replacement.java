class Solution {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int left = 0, maxf = 0, ans = 0;

        for (int r = 0; r < s.length(); r++) {
            maxf = Math.max(maxf, ++f[s.charAt(r) - 'A']);

            while (r - left + 1 - maxf > k) {
                f[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, r - left + 1);
        }
        return ans;
    }
}
  
    
