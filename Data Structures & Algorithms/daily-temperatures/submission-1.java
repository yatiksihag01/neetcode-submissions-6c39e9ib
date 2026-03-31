class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            int j = i + 1;
            while (j < size && temperatures[j] <= temperatures[i]) j++;
            if (j == size) res[i] = 0;
            else res[i] = j - i;
        }

        return res;
    }
}
