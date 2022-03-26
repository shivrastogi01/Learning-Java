class EliminationGame {
    public int lastRemaining(int n) {
        Deque<Integer> parity = new ArrayDeque<>();
        while(n > 1){
            if (parity.size() % 2 == 0){ // left -> right, length does not matter, always -1
                parity.push(-1);
            }else{
                parity.push(-(n%2)); // right -> left, odd length gets -1 and even length gets 0
            }
            n >>= 1;
        }

        int ans = 0;
        while(!parity.isEmpty()){
            ans = 2 * ans - parity.pop(); // going backward
        }

        return ans + 1; // +1 because question uses 1 index and I am using 0-index.
    }
}