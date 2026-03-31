class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (long) Math.ceil((double) pile / mid);
            }
            if (totalTime <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
