class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < hand.length; i++) {
            int card = hand[i];
            minHeap.offer(card);
            freq.merge(card, 1, Integer::sum);
        }

        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();

            if (freq.get(first) == 0) {
                minHeap.poll();
                continue;
            }

            for (int i = first; i < first + groupSize; i++) {
                int num = freq.getOrDefault(i, 0);
                if (num == 0) return false;
                freq.put(i, num - 1);
            }
        }
        return true;
    }
}
