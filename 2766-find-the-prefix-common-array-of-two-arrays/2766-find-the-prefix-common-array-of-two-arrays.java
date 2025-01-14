import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        Set<Integer> num = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < A.length; i++) {
            
            if (num.contains(A[i])) {
                commonCount++;
            } else {
                num.add(A[i]);
            }

            if (num.contains(B[i])) {
                commonCount++;
            } else {
                num.add(B[i]);
            }

            
            res[i] = commonCount;
        }

        return res;
    }
}
