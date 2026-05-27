class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size == 1) return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < size; i++) {
            int evenLen = expandAroundCenter(s, i, i + 1);
            int oddLen = expandAroundCenter(s, i, i);
            int maxLen = Math.max(evenLen, oddLen);

            if (maxLen > (end - start + 1)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
