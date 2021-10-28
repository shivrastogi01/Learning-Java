class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean [][] table = new boolean[pLen+1][sLen+1];
        for(int i=0; i<=pLen; i++){
            for(int j=0; j<=sLen; j++){
                if(0 == i && 0 == j){
                    table[i][j] = true;
                }
                else if(0 == i){
                    table[i][j] = false;
                }
                else if(0 == j){
                    if('*' == p.charAt(i-1)){
                        table[i][j] = table[i-1][j];
                    }
                    else{
                        table[i][j] = false;
                    }
                }
                else{
                    char pChar = p.charAt(i-1);
                    char sChar = s.charAt(j-1);
                    if('*' == pChar){
                        table[i][j] = table[i-1][j] || table[i][j-1];
                        continue;
                    }
                    if('?' == pChar || pChar == sChar){
                        table[i][j] = table[i-1][j-1];
                        continue;
                    }
                    table[i][j] = false;
                }
            }
        }
        return table[pLen][sLen];
    }
}