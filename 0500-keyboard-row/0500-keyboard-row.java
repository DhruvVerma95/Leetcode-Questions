class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        return Arrays.stream(words).filter(w -> {
            String lw = w.toLowerCase();
            int row = rows[0].indexOf(lw.charAt(0)) != -1 ? 0 : rows[1].indexOf(lw.charAt(0)) != -1 ? 1 : 2;
            return lw.chars().allMatch(c -> rows[row].indexOf(c) != -1);
        }).toArray(String[]::new);
    }
}
