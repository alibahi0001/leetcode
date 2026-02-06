class Solution {
    public boolean search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return true;

            // duplicates case
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
            }
            // left half sorted
            else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // right half sorted
            else {
                if (arr[mid] < target && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
