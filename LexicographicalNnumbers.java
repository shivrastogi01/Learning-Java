class LexicographicalNnumbers {
    List<Integer> ans;
    int val;
    private boolean solution(int n){
        if(n > val) return false;
        if(n <= val) ans.add(n);
        
        int nextVal = n*10; 
        for(int i = 0; i <= 9; i++){
            if(!solution(nextVal+i)) break;
        }
        return true;
    }
    public List<Integer> lexicalOrder(int n) {
        this.ans = new ArrayList<>();
        this.val = n;
        for(int i = 1; i <= 9; i++)
            if(!solution(i)) break;
        
        return ans;
    }
}