class Solution {
    public int search(int[] nums, int target) {
        return searchRec(nums, target, 0, nums.length - 1);
    }

    private int searchRec(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) {
            if (nums[low] != target) return -1;
            return low;
        }

        int mid = low + (high - low) / 2;

        if (target == nums[mid]) return mid;
        
        // Left half is sorted
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target < nums[mid]) return searchRec(nums, target, low, mid - 1);
            else return searchRec(nums, target, mid + 1, high);
        } 
        // Right half is sorted
        else {
            if (target > nums[mid] && target <= nums[high]) return searchRec(nums, target, mid + 1, high);
            else return searchRec(nums, target, low, mid - 1);
        }
    }
}