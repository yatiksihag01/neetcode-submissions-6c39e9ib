class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int maxCount = 1;
        int currCount = 1;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) currCount++;
            else if (nums[i] == nums[i-1]) continue;
            else currCount = 1;

            if (currCount > maxCount) maxCount = currCount;
        }
        return maxCount;
    }
}
