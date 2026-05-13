class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;
        int i = 0;
        int r = 0;
        List<int[]> result = new ArrayList<>();
        
        while (i < size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        while (i < size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        while (i < size) {
            result.add(intervals[i++]);
        }

        return result.toArray(int[][]::new);
    }
}
