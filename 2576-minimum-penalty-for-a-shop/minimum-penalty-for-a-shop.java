class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        
        int[] pref = new int[n + 1];  // suffix Y count
        int y = 0;

        // Build suffix count of 'Y'
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                y++;
            }
            pref[i] = y;
        }
        pref[n] = 0;  // closing at n → no future hours

        int pensup = 0;  // count of 'N' before closing
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i <= n; i++) {

            int penalty = pref[i] + pensup;

            if (penalty < min) {
                min = penalty;
                index = i;
            }

            // update pensup safely
            if (i < n && customers.charAt(i) == 'N') {
                pensup++;
            }
        }

        return index;
    }
}
