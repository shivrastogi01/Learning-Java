class SplitArrayIntoFibonacciSeries {
    public List<Integer> splitIntoFibonacci(String num) {
        //dfs
        List<Integer> result = new ArrayList<>();
        findAllSplits(num, result, 0);
        return result;
    }
    // num does not have leading zeros
    // num <= Integer.MAX_VALUE
    // result.size >= 3;
    // skip invalid case when size > 2, where as cur value > sum of previous 2 (then all following cases will be false)
    // try a new pick at i, the pick is valid if size <= 1 || f(i) = f(i - 1) + f(i - 2);
    
    public boolean findAllSplits(String s, List<Integer> result, int index){
        if (index == s.length() && result.size() >= 3){
            return true;
        }
        
        for (int i = index; i < s.length(); i++){
            // check for leading zeros
            if (s.charAt(index) == '0' && i > index){
                break;
            }
            
            // try to split the numebr at the current index
            long cur = Long.parseLong(s.substring(index, i + 1));
            // check for overflow
            if (cur > Integer.MAX_VALUE){
                break;
            }
            int size = result.size();
            // check for early termination
            if (size >= 2 && cur > result.get(size - 1) + result.get(size - 2)){
                break;  // cur and all following values are larger than f(i-1) + f(i- 2)
            }
            
            // recurse on valid cases
            if (size < 2 || cur == result.get(size - 1) + result.get(size - 2)){
                //try
                result.add((int)cur);
                
                // recurse 
                if (findAllSplits(s, result, i + 1)) return true;
                
                // back-track
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}