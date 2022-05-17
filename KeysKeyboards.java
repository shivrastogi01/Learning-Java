class KeysKeyboards {
    public int minSteps(int n) {
        return solve(n, 1, 0);
    }
    public int solve(int n, int length, int clipboard){
        if(length == n)
            return 0;
        if(length > n)
            return Integer.MAX_VALUE/2 ;
        int copyAndPaste = Integer.MAX_VALUE , paste = Integer.MAX_VALUE ;
        if(clipboard > 0)
          paste = 1 + solve(n, length + clipboard, clipboard);
        copyAndPaste = 2 + solve(n, length + length, length);
        return Math.min(copyAndPaste, paste);
    }
}