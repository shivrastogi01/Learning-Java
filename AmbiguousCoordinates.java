class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 2; i < s.length()-1; i++) {
            List<String> left = helper(s.substring(1, i));
            List<String> right = helper(s.substring(i, s.length()-1));
            if(left.size() == 0 || right.size() == 0) {
                continue;
            } 
            for(String l : left) {
                for(String r : right) {
                    String curr = "(" + l + ", " + r + ")";
                    res.add(curr);
                }
            }
        }
        return res;
    }
    
    public List<String> helper(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() == 1 || !s.startsWith("0")) {
            res.add(s);
        }
        for(int i = 1; i < s.length(); i++) {
            String curr = s.substring(0, i) + "." + s.substring(i, s.length());
            if(curr.endsWith("0") || (curr.startsWith("0") && curr.charAt(1) != '.')) {
                continue;
            }
            res.add(curr);
        }
        return res;
    }
    
}