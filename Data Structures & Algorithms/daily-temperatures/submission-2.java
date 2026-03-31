class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] res = new int[days];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < days; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int day = stack.pop();
                res[day] = i - day;
            }
            stack.push(i);
        }
        return res;
    }
}
