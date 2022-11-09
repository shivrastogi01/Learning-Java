class StockSpanner 
{
    Stack<Pair<Integer,Integer>> s = new Stack<>();
       
    public int next(int p) 
    {
        int c = 1;
        while (!s.isEmpty() && s.peek().getKey() <= p)
            c += s.pop().getValue();
        s.push(new Pair(p,c));
        return c;
    }
}