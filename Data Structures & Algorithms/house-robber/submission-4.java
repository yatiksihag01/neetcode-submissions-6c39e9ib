class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];
        if (size == 2) return Math.max(nums[0], nums[1]);

        int last = nums[size-1];
        int current = nums[size-2];

        for (int i = size - 3; i >= 0; i--) {
            int pick = nums[i] + last;
            last = current;
            current = Math.max(pick, current);
        }

        return current;
    }
}
