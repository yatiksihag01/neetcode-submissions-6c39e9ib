class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int curr = n - i;
            while (curr != 0) {
                curr = curr & (curr - 1);
                count++;
            }
            output[n - i] = count;
        }
        return output;
    }
}
