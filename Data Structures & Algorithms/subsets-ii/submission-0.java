class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(
        int[] nums,
        int index,
        List<List<Integer>> result,
        List<Integer> path
    ) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        backtrack(nums, index + 1, result, path);
        path.remove(path.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) index++;
        backtrack(nums, index + 1, result, path);
    }
}
