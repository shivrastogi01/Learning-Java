class StringCharacterReplace {
    public String convert(String s, int n) {
       String[] st = new String[n];
      if ( n == 1) return s;
       for( int i = 0 ; i < n ; i ++) {
           st[i] = "";
       }
       int k = 0;
       boolean down = false;
       for ( int i = 0 ; i < s.length(); i++)  {          
           st[k] = st[k] + Character.toString (s.charAt( i ));               
           if( down)
               k = k - 1;
           else
               k = k + 1;           
           if( k == n){
             down = true;
             k = k-2;          
           }
           if( k < 0){
              down = false;
              k= k+2;              
           }
       }
        
     String ans = "";
     for( String x : st){
         ans += x;
     }   
       return ans ; 
    }
}
/*Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
*/