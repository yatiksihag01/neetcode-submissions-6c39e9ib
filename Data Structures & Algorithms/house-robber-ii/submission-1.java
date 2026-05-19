class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];
        return Math.max(
            robHelper(nums, 0, size - 1),
            robHelper(nums, 1, size)
        );
    }

    public int robHelper(int[] nums, int startFrom, int endsBefore) {
        int size = nums.length;
        int prevMax = 0;
        int currMax = 0;

        for (int i = startFrom; i < endsBefore; i++) {
            int nextMax = Math.max(currMax, prevMax + nums[i]);
            prevMax = currMax;
            currMax = nextMax;
        }

        return currMax;
    }
}
