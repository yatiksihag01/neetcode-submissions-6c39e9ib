class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCount = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int length = 0;
                while (set.contains(curr++)) length++;
                if (length > maxCount) maxCount = length;
            }
        }
        return maxCount;
    }
}
