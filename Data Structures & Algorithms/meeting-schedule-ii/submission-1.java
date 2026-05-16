/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int size = intervals.size();
        if (size <= 1) return size;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        intervals.sort((a, b) -> a.start - b.start);
        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < size; i++) {
            int min = minHeap.peek();
            if (min <= intervals.get(i).start) minHeap.poll();
            minHeap.offer(intervals.get(i).end);
        }

        return minHeap.size();
    }
}