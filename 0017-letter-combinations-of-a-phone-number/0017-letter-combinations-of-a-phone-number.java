import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        
        for (char digit : digits.toCharArray()) {
            int digitIndex = digit - '0';
            String letters = mappings[digitIndex];
            int size = queue.size();
            
            while (size-- > 0) {
                String combination = queue.poll();
                for (char letter : letters.toCharArray()) {
                    queue.add(combination + letter);
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}
