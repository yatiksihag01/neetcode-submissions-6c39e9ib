class Solution {
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int last = 1;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = current + last;
            last = current;
            current = tmp;
        }

        return current;
    }
}
