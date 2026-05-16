class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        if (size == 1) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int end = intervals[0][1];
        int result = 0;

        for (int i = 1; i < size; i++) {
            if (intervals[i][0] < end) result++;
            else end = intervals[i][1];
        }

        return result;
    }
}
