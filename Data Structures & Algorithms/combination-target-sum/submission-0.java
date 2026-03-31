class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        findCombination(nums, target, 0, result, combinations);
        return result;
    }

    private void findCombination(
        int[] nums,
        int target,
        int index,
        List<List<Integer>> result,
        List<Integer> combinations
    ) {
        if (index == nums.length) {
            if (target == 0) result.add(new ArrayList<>(combinations));
            return;
        }

        int curr = nums[index];
        if (curr <= target) {
            combinations.add(curr);
            findCombination(nums, target - curr, index, result, combinations);
            combinations.remove(combinations.size() - 1);
        }
        findCombination(nums, target, index + 1, result, combinations);
    }
}
