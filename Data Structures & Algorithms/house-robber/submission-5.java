class Solution {
    public int rob(int[] nums) {
        int last = 0;
        int current = 0;

        for (int num : nums) {
            int next = Math.max(current, last + num);
            last = current;
            current = next;
        }

        return current;
    }
}
