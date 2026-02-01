class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) cnt[c - 'a']++;

        int left = 0, need = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            if (cnt[s2.charAt(right) - 'a']-- > 0) need--;

            if (need == 0) return true;

            if (right - left + 1 == s1.length()) {
                if (cnt[s2.charAt(left) - 'a']++ >= 0) need++;
                left++;
            }
        }
        return false;
    }
}
    
    
