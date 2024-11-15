import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        int degree = 0, minLength = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);
            last.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, count.get(nums[i]));
        }
        
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                minLength = Math.min(minLength, last.get(num) - first.get(num) + 1);
            }
        }
        
        return minLength;
    }
}
