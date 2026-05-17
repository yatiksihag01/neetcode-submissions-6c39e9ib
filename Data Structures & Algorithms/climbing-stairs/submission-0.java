class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return climbStairsMem(n, dp);
    }

    private int climbStairsMem(int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        dp[n] = climbStairsMem(n-2, dp) + climbStairsMem(n-1, dp);
        return dp[n];
    }
}
