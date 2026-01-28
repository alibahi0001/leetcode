class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixsum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        for (int i = 0; i < nums.length; i++) {
            prefixsum += nums[i];

            int rem = ((prefixsum % k) + k) % k; // handle negatives

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
