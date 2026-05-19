class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];

        int max = 0;
        int[] dp1 = new int[size];
        int[] dp2 = new int[size];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
            dfs(nums, size - 2, 0, dp1),
            dfs(nums, size - 1, 1, dp2)
        );
    }

    private int dfs(int[] nums, int index, int stopLimit, int[] dp) {
        if (index < stopLimit) return 0;
        if (dp[index] != -1) return dp[index];

        dp[index] = Math.max(
            nums[index] + dfs(nums, index - 2, stopLimit, dp),
            dfs(nums, index - 1, stopLimit, dp)
        );

        return dp[index];
    }
}