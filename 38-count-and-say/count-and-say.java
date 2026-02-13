class Solution {
    public String countAndSay(int n) {

        StringBuilder sb = new StringBuilder("1");

        if (n == 1) return "1";

        for (int j = 1; j < n; j++) {

            StringBuilder nextsb = new StringBuilder();
            int count = 1;

            int sblen = sb.length();

            for (int i = 1; i < sblen; i++) {
                char curr = sb.charAt(i);
                char prev = sb.charAt(i - 1);

                if (curr == prev) {
                    count++;
                } else {
                    nextsb.append(count).append(prev);
                    count = 1;
                }
            }

            // last group which isn't handled so used sblen-1 which is last char that hasnot handled and we appended it
            nextsb.append(count).append(sb.charAt(sblen - 1));

            sb = nextsb;
        }

        return sb.toString();
    }
}
