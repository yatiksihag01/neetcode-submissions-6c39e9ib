class MinStack {

    private final ArrayList<Integer> stack;
    private PriorityQueue<Integer> pq;

    public MinStack() {
        stack = new ArrayList<>();
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.add(val);
        pq.add(val);
    }

    public void pop() {
        int val = stack.remove(stack.size() - 1);
        pq.remove(val);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return pq.peek();
    }
}
