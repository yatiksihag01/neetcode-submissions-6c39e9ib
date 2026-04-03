class Solution {
    
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2]) // compare distance directly
        );

        for (int[] p : points) {
            int dist = p[0] * p[0] + p[1] * p[1];

            maxHeap.add(new int[]{p[0], p[1], dist});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            int[] top = maxHeap.poll();
            result[--k] = new int[]{top[0], top[1]};
        }

        return result;
    }
}
