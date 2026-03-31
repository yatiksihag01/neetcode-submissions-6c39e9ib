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

        for (int num : nums) {
            if (visited.contains(num)) continue;

            path.add(num);
            visited.add(num);

            explore(nums, visited, result, path);

            path.removeLast();
            visited.remove(num);
        }
    }
}
