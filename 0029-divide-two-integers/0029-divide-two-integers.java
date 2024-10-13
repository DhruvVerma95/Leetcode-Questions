class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both dividend and divisor to positive numbers
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Subtract divisor from dividend using bit shifts
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            int multiple = 1;
            // Shift the divisor left until it is larger than the dividend
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            // Subtract the largest shifted divisor from the dividend
            absDividend -= temp;
            result += multiple;
        }

        // Apply the sign
        return negative ? -result : result;
    }
}
