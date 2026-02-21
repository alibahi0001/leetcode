import java.util.*;

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();

        // If time = 0, every day is valid
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        //streak calculating arrays
        int[] nonInc = new int[n]; // Stores count of consecutive non-increasing days BEFORE index i ante i vakarku decrese avvukuntu ravali so noninceresing
        int[] nonDec = new int[n]; // Stores count of consecutive non-decreasing days AFTER index i ante i tarvata nundi increse avvukuntu povali so nondecresing 

        // ---------------- LEFT SIDE ----------------
        // We need at least 'time' non-increasing days before day i
        // Meaning: security[i] <= security[i-1] for 'time' consecutive days

        int count = 0;
        nonInc[0] = 0; // No day before index 0

        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                count++;   // increasing streak of non-increasing days
            } else {
                count = 0; // reset streak
            }
            nonInc[i] = count;
        }

        // ---------------- RIGHT SIDE ----------------
        // We need at least 'time' non-decreasing days after day i
        // Meaning: security[i] <= security[i+1] for 'time' consecutive days

        count = 0;
        nonDec[n - 1] = 0; // No day after last index

        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                count++;   // increasing streak of non-decreasing days
            } else {
                count = 0; // reset streak
            }
            nonDec[i] = count;
        }

        // ---------------- CHECK VALID DAYS ----------------
        // A day i is valid if:
        // 1) It has at least 'time' non-increasing days BEFORE it
        // 2) It has at least 'time' non-decreasing days AFTER it

        for (int i = time; i < n - time; i++) {
            if (nonInc[i] >= time && nonDec[i] >= time) {
                result.add(i);
            }
        }

        return result;
    }
}