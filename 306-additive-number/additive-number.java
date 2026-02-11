import java.math.BigInteger;

class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n - 2; i++) {

            // leading zero rule for num1
            if (num.charAt(0) == '0' && i > 1) break;

            BigInteger left = new BigInteger(num.substring(0, i));

            for (int j = i + 1; j <= n - 1; j++) {

                // leading zero rule for num2
                if (num.charAt(i) == '0' && j > i + 1) break;

                BigInteger right = new BigInteger(num.substring(i, j));

                if (isValid(num, left, right, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String num, BigInteger left, BigInteger right, int index) {
        int n = num.length();

        while (index < n) {
            BigInteger sum = left.add(right);
            String sumStr = sum.toString();

            if (!num.startsWith(sumStr, index)) {
                return false;
            }

            index += sumStr.length();
            left = right;
            right = sum;
        }

        return true;
    }
}
