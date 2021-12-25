class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(words));
        
        for(String s: words){
            for(int i=1; i<s.length(); i++)
                hs.remove(s.substring(i));
        }
        
        int length = 0;
        
        for(String s: hs)
            length += s.length()+1;
        
        return length;
    }
}