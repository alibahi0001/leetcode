class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int[] count = new int[51]; // count of negatives (-1 to -50)

        // initialize first window
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) count[-nums[i]]++;
        }
        res[0] = getXthSmall(count, x);

        // sliding window
        for (int i = k; i < n; i++) {
            if (nums[i - k] < 0) count[-nums[i - k]]--; // remove outgoing
            if (nums[i] < 0) count[-nums[i]]++;       // add incoming

            res[i - k + 1] = getXthSmall(count, x);
        }

        return res;
    }

    private int getXthSmall(int[] count, int x) {
        int total = 0;
        for (int i = 50; i >= 1; i--) { // i=50 => -50, i=1 => -1
            total += count[i];
            if (total >= x) return -i;
        }
        return 0; // not enough negatives
    }
}
