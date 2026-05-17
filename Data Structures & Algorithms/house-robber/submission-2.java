class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i, dp));
        }

        return max;
    }

    private int dfs(int[] nums, int index, int[] dp) {
        if (index >= (nums.length - 2)) return nums[index];
        if (dp[index] != -1) return dp[index];

        int max = Math.max(
            nums[index] + dfs(nums, index + 2, dp),
            dfs(nums, index + 1, dp)
        );

        dp[index] = max;
        return dp[index];
    }
}
