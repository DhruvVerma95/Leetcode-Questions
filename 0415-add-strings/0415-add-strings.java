import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
        // Convert the input strings to BigInteger
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        
        // Add the two BigIntegers
        BigInteger sum = n1.add(n2);
        
        // Return the sum as a string
        return sum.toString();
    }
}