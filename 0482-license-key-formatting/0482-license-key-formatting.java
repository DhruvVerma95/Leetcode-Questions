class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }
        int firstGroupLength = sb.length() % k;
        StringBuilder result = new StringBuilder();
        if (firstGroupLength > 0) {
            result.append(sb.substring(0, firstGroupLength));
        }
        for (int i = firstGroupLength; i < sb.length(); i += k) {
            if (result.length() > 0) {
                result.append("-");
            }
            result.append(sb.substring(i, i + k));
        }
        return result.toString();
    }
}
