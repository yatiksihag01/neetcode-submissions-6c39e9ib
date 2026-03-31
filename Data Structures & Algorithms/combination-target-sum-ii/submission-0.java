class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates); 
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
        int[] nums,
        int remaining,
        int index,
        List<Integer> path,
        List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (nums[i] > remaining) break;
            path.add(nums[i]);
            backtrack(nums, remaining - nums[i], i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
