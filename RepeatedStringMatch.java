class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        int i = 1;
        String str = "";
        while ( str.length()<  a.length()+b.length())
        {
            str = a.repeat(i);
            if(str.contains(b)) return i;
            i++;
        }
        return -1;
    }
}