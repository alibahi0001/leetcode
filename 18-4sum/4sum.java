class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // Sorting is mandatory for two-pointer technique and duplicate handling
        Arrays.sort(nums);

        // At index i:
        // We have FIXED 1 number.
        // We still need 3 more numbers to form a quadruplet.
        // So i must stop at n - 3.
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate values for i to avoid repeated quadruplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // At index j:
            // We have FIXED 2 numbers (nums[i] and nums[j]).
            // We still need 2 more numbers.
            // So j must stop at n - 2.
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate values for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                // At left and right:
                // We have FIXED 3 numbers.
                // left and right work together to find the final number
                // using the two-pointer technique.
                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(
                            nums[i], nums[j], nums[left], nums[right]
                        ));

                        // Move both pointers after finding a valid quadruplet
                        left++;
                        right--;

                        // Skip duplicate values for left and right
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
