class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        
		// used to keep up with most recent numbers seen or most recent result of RPN expression
        Deque<Integer> stack = new ArrayDeque<>();
        
		// Walk through array and process each token.  A token is an operator is it's last char isn't a digit. 
		// i.e -400, 0, 400, 1 -> last char is always a digit. an operator will never have a digit as last char
        for (String token : tokens) {
            boolean isOperator = !Character.isDigit(token.charAt(token.length() - 1));
            
			// always push elements to the stack after processing (this keeps up with the order of operations and elements)
            if (isOperator) {
                stack.push(processOperation(stack, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
		
		// the last element in the stack will be the result of the final arithmetic operation OR 
		// the only number that was inside of the array
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