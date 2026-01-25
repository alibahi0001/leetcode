class Solution {
    public int subarraySum(int[] nums, int k) {

        int prefixsum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // VERY IMPORTANT

        for (int i = 0; i < nums.length; i++) {

            prefixsum += nums[i];

            // 1️⃣ CHECK first
            if (map.containsKey(prefixsum - k)) {
                count += map.get(prefixsum - k);
            }

            // 2️⃣ THEN STORE current prefixsum
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }

        return count;
    }
}
