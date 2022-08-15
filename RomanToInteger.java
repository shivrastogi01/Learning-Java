class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put("I", 1);
        m.put("IV", 4);
        m.put("V", 5);
        m.put("IX", 9);
        m.put("X", 10);
        m.put("XL", 40);
        m.put("L", 50);
        m.put("XC", 90);
        m.put("C", 100);
        m.put("CD", 400);
        m.put("D", 500);
        m.put("CM", 900);
        m.put("M", 1000);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            String a = "";
            String b = "";
            if(i < s.length()-1){
                a += Character.toString(s.charAt(i));
                a += Character.toString(s.charAt(i+1));
            }
            b += Character.toString(s.charAt(i));
            if(m.containsKey(a)){
                res += m.get(a);
                i++;
            }
            else{
                res += m.get(b);
            }
        }
        return res;
    }
}