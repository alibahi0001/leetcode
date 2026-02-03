class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr); // 1️⃣ sort ONCE

        for (int j = 0; j < n - 2; j++) {

            // 2️⃣ skip duplicate anchors
            if (j > 0 && arr[j] == arr[j - 1]) continue;

            int cur = arr[j];
            int left = j + 1;       // 3️⃣ left starts AFTER j
            int right = n - 1;

            while (left < right) {
                int sum = cur + arr[left] + arr[right];

                if (sum == 0) {
                    list.add(Arrays.asList(cur, arr[left], arr[right]));

                    // 4️⃣ skip duplicate left/right values
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;   // need bigger sum
                }
                else {
                    right--;  // need smaller sum
                }
            }
        }
        return list;
    }
}
