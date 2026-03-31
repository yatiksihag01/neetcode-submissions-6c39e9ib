class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int current  = Math.min(heights[left], heights[right]) * (right - left);
            if (current > result) result = current;
            if (heights[left] > heights[right]) right--;
            else left++;
        }
        return result;
    }
}
