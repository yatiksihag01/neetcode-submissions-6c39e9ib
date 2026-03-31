class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        explore(nums, visited, result, new ArrayList<>());
        return result;
    }

    private void explore(
            int[] nums,
            Set<Integer> visited,
            List<List<Integer>> result,
            List<Integer> path
    ) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;

            path.add(nums[i]);
            visited.add(nums[i]);

            explore(nums, visited, result, path);

            path.remove(path.size() - 1);
            visited.remove(nums[i]);
        }
    }
}
