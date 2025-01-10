import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
     
        Map<Character, Integer> maxFreqMap = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> wordFreqMap = getFrequencyMap(word);
            for (Map.Entry<Character, Integer> entry : wordFreqMap.entrySet()) {
                char c = entry.getKey();
                int freq = entry.getValue();
                maxFreqMap.put(c, Math.max(maxFreqMap.getOrDefault(c, 0), freq));
            }
        }


        List<String> result = new ArrayList<>();
        for (String word : words1) {
            Map<Character, Integer> wordFreqMap = getFrequencyMap(word);
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : maxFreqMap.entrySet()) {
                char c = entry.getKey();
                int freq = entry.getValue();
                if (wordFreqMap.getOrDefault(c, 0) < freq) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }

        return result;
    }

    private Map<Character, Integer> getFrequencyMap(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }
}
