class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            count[s2.charAt(i) - 'a']--;

            if (i >= n) {
                count[s2.charAt(i - n) - 'a']++;
            }

            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int x : count) {
            if (x != 0) return false;
        }
        return true;
    }
}
