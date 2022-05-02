class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
	if(n == 1) return 0;

	int prev = kthGrammar(n-1, (int)Math.round((double)k/2));

	if(k % 2 != 0){
		return prev;    
	} else {
		return prev == 0 ? 1 : 0;
	}
}
}