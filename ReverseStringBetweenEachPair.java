class ReverseStringBetweenEachPair {
    
    public String reverseParentheses(String s) {
        
        Deque<StringBuilder> dq=new ArrayDeque<>();
        dq.offerLast(new StringBuilder());
        
        for(int i=0; i<s.length();i++){
            char x=s.charAt(i);
            if(x=='('){
                dq.offerLast(new StringBuilder());
            }else if(x==')'){
                StringBuilder curr=dq.pollLast().reverse();
                dq.peekLast().append(curr);
            }else{
                dq.peekLast().append(x);
            }
            
        }
        return dq.pollLast().toString();
    }
}