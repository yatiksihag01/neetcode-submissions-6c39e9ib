class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        boolean isZeroPresent = false;

        for (int num : nums) {
            if (num == 0) {
                if (isZeroPresent) return res;
                isZeroPresent = true;
                continue;
            }
            product *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isZeroPresent) res[i] = product/nums[i];
            else if (isZeroPresent && nums[i] != 0) res[i] = 0;
            else res[i] = product;
        }
        return res;
    }
}  
