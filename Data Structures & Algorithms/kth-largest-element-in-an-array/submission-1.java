class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() >= k && num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            } else if (minHeap.size() < k) {
                minHeap.offer(num);
            }
        }
        return minHeap.poll();
    }
}
