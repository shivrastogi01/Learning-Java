class CheckArryaPairDivisibleByK{
    public boolean canArrange(int[] arr, int k) {
        HashMap <Integer, Integer> mp= new HashMap<>();
        int x=0;
        for(int i=0; i<arr.length; i++){
            x=arr[i]%k;
            if(x<0) x+=k;
            if(!mp.containsKey(x)) mp.put(x, 1);
            else mp.put(x,mp.get(x)+1);
        }
        for(int e: mp.keySet()){
            x=k-e;
            if(e==0){
                if(mp.get(e)%2!=0) return false;
            }
            else{
                if(!mp.containsKey(x)) return false;
                else{
                    int p= mp.get(x);
                    int q= mp.get(e);
                    if(p!=q) return false;
                }
            }
        }
        return true;
    }
}