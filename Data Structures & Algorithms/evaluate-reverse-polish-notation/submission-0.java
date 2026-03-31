class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (!operators.contains(token)) {
                int operand = Integer.parseInt(token);
                stack.push(operand);
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                        
                }
            }
        }
        return stack.pop();
    }
}
