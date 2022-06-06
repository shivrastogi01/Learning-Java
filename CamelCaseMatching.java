class CamelCaseMatching {
    public Boolean out(String elem, String pattern){
        int p1=0; int p2=0;
        while (p2<elem.length() && p1<pattern.length()){
           if(pattern.charAt(p1)!=elem.charAt(p2)){
              if(elem.charAt(p2)<91){ return false; }
              p2++;
           }
           else{ p1++; p2++; }
        }
        for(int i=p2; i<elem.length(); i++){
           if(elem.charAt(i)<91){ return false; }  
        }
        if(p1<pattern.length()){ return false; }
        return true; 
    } 
      
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<Boolean>(); 
     for(int i=0; i<queries.length; i++){
        ans.add(out(queries[i], pattern) ?true :false);
     }
     return ans;

   }
} 