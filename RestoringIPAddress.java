class RestoringIPAddress {
    int n;
    String s;
    List<String> output = new ArrayList<String>();
    
    public boolean valid(String segment){
        int len = segment.length();
        if(len > 3) return false;
        int value = Integer.valueOf(segment);
        return (segment.charAt(0) == '0')? (len == 1) : (value <= 255);
    }
    
    public void backtrack(int start, List<String> segments, int left){
        if(segments.size() == 4){
            if(left == 0){
                output.add(String.join(".", new ArrayList<String>(segments)));
            }
            return;
        }
        int max_pos = Math.min(start + 3, n);
        for(int end = start + 1; end <= max_pos; end++){
            String segment = s.substring(start, end);
            if(valid(segment)){
                segments.add(segment);
                backtrack(end, segments, left - segment.length());
                segments.remove(segments.size() - 1);
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        // if(s.length() > 12){
        //     return new ArrayList<String>();
        // }
        this.s = s;
        this.n = s.length();
        backtrack(0, new ArrayList<String>(), n);
        return output;
    }
}