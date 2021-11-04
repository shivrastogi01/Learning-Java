class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        
        int lens=s.length();
        int lent=t.length();
        int i=0;
        int j=0;
        while(i<lent){
           // int j=0;
            
           if(j<lens&&s.charAt(j)==t.charAt(i)){
           j++;    
           }
            i++;
            
        }
        return (j==lens)?true:false;
    }
}