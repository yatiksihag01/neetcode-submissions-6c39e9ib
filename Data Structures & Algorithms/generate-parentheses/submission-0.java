class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, result, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int openCount, int closeCount, List<String> result, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (openCount < n) {
            sb.append("(");
            backtrack(n, openCount + 1, closeCount, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCount < openCount) {
            sb.append(")");
            backtrack(n, openCount, closeCount + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
