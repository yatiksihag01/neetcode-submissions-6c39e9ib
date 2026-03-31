class Solution {
    public int findMin(int[] nums) {
        return findMinRec(nums, 0, nums.length-1);
    }

    private int findMinRec(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        if (high == low + 1) return nums[high] > nums[low] ? nums[low] : nums[high];
        int mid = low + (high - low) / 2;

        if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) return nums[mid];
        else return Math.min(findMinRec(nums, low, mid), findMinRec(nums, mid + 1, high));
    }
}
