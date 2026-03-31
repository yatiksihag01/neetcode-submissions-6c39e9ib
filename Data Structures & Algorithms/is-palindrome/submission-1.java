class Solution {
    public boolean isPalindrome(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charCode = Character.toLowerCase(str.charAt(i));
            if ((charCode >= 'a' && charCode <= 'z') || Character.isDigit(charCode)) {
                s.append(charCode);
            }
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
