class Solution {
    public int rob(int[] nums) {
        int last = 0;
        int currentMax = 0;

        for (int num : nums) {
            int nextMax = Math.max(currentMax, last + num);
            last = currentMax;
            currentMax = nextMax;
        }

        return currentMax;
    }
}
