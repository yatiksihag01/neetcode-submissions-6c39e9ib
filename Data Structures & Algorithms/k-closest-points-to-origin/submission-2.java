class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare(euclideanDistance(b), euclideanDistance(a))
        );

        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }
        
        return result;
    }

    private int euclideanDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
