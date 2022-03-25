class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        
        NestedInteger res = new NestedInteger();
        int left = 1, right = s.length() - 1;
        while(left < right){
            int start = left;
            if(s.charAt(left) == ','){
                left++;
                continue;
            }else if(s.charAt(left) != '['){
                 while(s.charAt(left) != ',' && left < right) left++;
            }else {
                left++;
                int count = 1;
                while(count != 0 && left < right){
                    char c = s.charAt(left++);
                    count += (c == '[') ? 1 : (c == ']' ? -1 : 0);
                }
            }
            NestedInteger inner = deserialize(s.substring(start, left));
            res.add(inner);
        }
        return res; 
    }
}