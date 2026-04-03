class Solution {

    private class Pair implements Comparable<Pair> {
        private final int[] set;
        private final double ecd;

        public Pair(int[] set, double ecd) {
            this.set = set;
            this.ecd = ecd;
        }

        @Override
        public int compareTo(Pair other) {
            return Double.compare(other.ecd, this.ecd);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for (int[] set : points) {
            double ecd = euclideanDistance(set);
            Pair pair = new Pair(set, ecd);
            maxHeap.offer(pair);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().set;
        }
        return res;
    }

    private double euclideanDistance(int[] set) {
        return set[0] * set[0] + set[1] * set[1];
    }
}
