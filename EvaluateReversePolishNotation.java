class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        
	
        Deque<Integer> stack = new ArrayDeque<>();
        
		
        for (String token : tokens) {
            boolean isOperator = !Character.isDigit(token.charAt(token.length() - 1));
           
            if (isOperator) {
                stack.push(processOperation(stack, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
	
        return stack.pop();
    }
    
    public int processOperation(Deque<Integer> stack, String operator){
        int returnValue = 0;
        int second = stack.pop();
        int first = stack.pop();
        
		// process arithmetic expression based on operator
        if (operator.equals("+")) returnValue = first + second;
        if (operator.equals("-")) returnValue = first - second;
        if (operator.equals("*")) returnValue = first * second;
        if (operator.equals("/")) returnValue = first / second;
        
        return returnValue;
    }
}