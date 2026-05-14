// [1,3] [1,5] [5,7] [8,10] => [1,7] [8,10]

class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        if (size == 1) return intervals;

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 1; i < size; i++) {
            if (intervals[i][0] <= max) {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            } else {
                result.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }

        result.add(new int[]{min, max});

        return result.toArray(int[][]::new);
    }
}
