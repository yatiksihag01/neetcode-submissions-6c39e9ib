class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> remainings = new ArrayList<>();

        for (int i : hand) {
            minHeap.offer(i);
        }

        while (!minHeap.isEmpty()) {
            int prev = minHeap.peek();
            int count = groupSize;

            while (count-- > 0) {
                int i = minHeap.poll();
                if (prev - 1 == i) {
                    count++;
                    remainings.add(i);
                }
                else if (prev != i) return false;

                if (count > 0 && minHeap.isEmpty()) return false;
                prev = i + 1;
            }

            minHeap.addAll(remainings);
            remainings.clear();
        }
        return true;
    }
}