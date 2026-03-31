public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int back = 0;
        int front = 0;
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        while (++front <= s.length() - 1) {
            if (map.containsKey(s.charAt(front))) {
                int index = map.get(s.charAt(front));
                if (index >= back) {
                    back = index + 1;
                }
            }
            maxLen = Math.max(maxLen, front - back + 1);
            map.put(s.charAt(front), front);
        }
        return maxLen;
    }
}