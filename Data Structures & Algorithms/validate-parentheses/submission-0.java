class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> bracketPairs = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (char ch : s.toCharArray()) {
            if (bracketPairs.containsValue(ch)) {
                stack.push(ch);
            } else if (bracketPairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(ch)) {
                    return false;
                }
            } else return false;
        }

        return stack.isEmpty();
    }
}
