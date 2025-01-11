class Solution {
    public boolean canConstruct(String s, int k) {

        if(k>s.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int oddCount = 0;
      for (int value : map.values()) {
            if (value % 2 != 0) {
            oddCount++;
    }
}
        return oddCount<=k;
        
    }
}