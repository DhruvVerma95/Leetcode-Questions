class Solution {
    public int minAddToMakeValid(String s) {
        int openB = 0;
        int closeB = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openB++;
            } else if (c == ')') {
                if (openB > 0) {
                    openB--;
                } else {
                    closeB++;
                }
            }
        }
        
        return openB + closeB;
    }
}
