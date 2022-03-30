class StockSpanner {

    List<Integer> l;
    public StockSpanner() {
        l=new ArrayList<>();
    }
    
    public int next(int price) {
        l.add(price);
        int ans=0;
        for(int i=l.size()-1;i>=0;i--){
            if(l.get(i)<=price)
                ans++;
            else
                break;
        }
        return ans;
    }
}
