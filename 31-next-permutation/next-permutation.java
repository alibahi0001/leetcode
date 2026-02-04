class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        /*
         * WHY i + 1 ?
         * ----------------
         * We are looking for the FIRST position from the RIGHT
         * where the increasing order breaks.
         *
         * Condition: nums[i] < nums[i + 1]
         *
         * This comparison tells us:
         * - nums[i+1] exists (so i goes till n-2)
         * - nums[i] is smaller than its immediate next element
         *
         * This position (i) becomes the PIVOT because:
         * - everything to the right of i is non-increasing
         * - this is the exact point where next permutation can start
         */
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        /*
         * If pivot is not found:
         * The array is in descending order (last permutation),
         * so we reverse it to get the first permutation.
         */
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        /*
         * Find the smallest element on the RIGHT of pivot
         * that is just greater than nums[pivot].
         *
         * We scan from the right because the suffix is
         * already in descending order.
         */
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        /*
         * Reverse the suffix to get the smallest lexicographical order
         * after the pivot.
         */
        reverse(nums, pivot + 1, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
