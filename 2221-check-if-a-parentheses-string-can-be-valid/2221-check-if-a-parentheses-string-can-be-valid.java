class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // Odd-length strings can never be valid

        // Left-to-right pass
        int minOpen = 0, maxOpen = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    minOpen++;
                    maxOpen++;
                } else {
                    minOpen = Math.max(0, minOpen - 1);
                    maxOpen--;
                }
            } else {
                // Flexible character
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            }
            if (maxOpen < 0) return false; // Too many ')'
        }

        // Right-to-left pass
        minOpen = 0;
        maxOpen = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    minOpen++;
                    maxOpen++;
                } else {
                    minOpen = Math.max(0, minOpen - 1);
                    maxOpen--;
                }
            } else {
                // Flexible character
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            }
            if (maxOpen < 0) return false; // Too many '('
        }

        return minOpen == 0; // All open parentheses are balanced
    }
}
