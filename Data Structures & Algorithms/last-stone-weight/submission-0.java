class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int secondHeaviest = maxHeap.poll();

            if (heaviest != secondHeaviest) {
                maxHeap.offer(heaviest - secondHeaviest);
            }
        }
        return (maxHeap.size() == 1) ? maxHeap.poll() : 0;
    }
}
