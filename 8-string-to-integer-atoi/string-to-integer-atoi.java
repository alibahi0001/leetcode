class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int i = 0;
        int result = 0;

        // sign check
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            i++;
        }

        // digit loop
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // overflow check 🔥
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
