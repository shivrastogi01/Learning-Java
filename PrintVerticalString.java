class PrintVerticalString {
    public List<String> printVertically(String s) {
        List<String> res=new ArrayList<>();
        String[] words=s.split(" ");
        int maxlength=0;
        for(String word:words){
            maxlength=Math.max(maxlength,word.length());
        }
        
        for(int i=0;i<maxlength;i++){
            StringBuilder sb=new StringBuilder();
            for(String word:words){
                if(i>=word.length()){
                    sb.append(" ");
                }else{
                    sb.append(word.charAt(i));
                }
            }
            res.add(trimspace(sb.toString()));
        }
        return res;
    }
    public String trimspace(String word){
        int point=word.length();
        while(--point > -1){
            if(word.charAt(point) != ' '){
                return word.substring(0,point+1);
            }
        }
        return null;
    }
}