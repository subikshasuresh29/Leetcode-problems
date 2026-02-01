class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int sum = 0, res = 0;
        for(int num : nums) {
            sum = (sum + num % k + k) % k;
            res += count[sum]++;
        }
        return res;
    }
}
    
    
