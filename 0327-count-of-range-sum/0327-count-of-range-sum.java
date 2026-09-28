class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, prefix.length, lower, upper);
    }

    private int mergeSort(long[] arr, int left, int right,
            int lower, int upper) {
        if (right - left <= 1)
            return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, left, mid, lower, upper)
                + mergeSort(arr, mid, right, lower, upper);
        int j = mid;
        int k = mid;
        for (int i = left; i < mid; i++) {
            while (j < right && arr[j] - arr[i] < lower)
                j++;
            while (k < right && arr[k] - arr[i] <= upper)
                k++;
            count += k - j;
        }
        long[] temp = new long[right - left];
        int i = left;
        int p = mid;
        int t = 0;
        while (i < mid && p < right) {
            if (arr[i] <= arr[p])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[p++];
        }
        while (i < mid)
            temp[t++] = arr[i++];
        while (p < right)
            temp[t++] = arr[p++];
        for (int x = 0; x < temp.length; x++)
            arr[left + x] = temp[x];
        return count;
    }
}