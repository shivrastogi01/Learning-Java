class FindTheShortestSuperstring {
    public String shortestSuperstring(String[] words) {
        
        int l= words.length;
        int state =0;
        for(int i=0; i<l ;i++){
            state = state | 1<<i;
        }
        Map<String, String> map = new HashMap<>();
        
        return solveTPS( words,  state,  "", map, l);
        
    }
    
    String solveTPS(String[] words, int state, String startWord,  Map<String, String> map, int l){
        
        String key = startWord+"|"+state;
        if(state ==0) return startWord;
        
        if(map.get(key)!=null){
            return map.get(key);
        }
        String minLenWord = "";
        
        for(int i=0; i< l ;i++){
            if((state >> i & 1)==1){
                int takenState = state & ~(1<<i);
                String result = solveTPS( words,  takenState,  words[i], map, l);
                
                String tmp = mergeAndGet(startWord, result);
                
                 if(minLenWord.length()==0 || minLenWord.length()>tmp.length()){
                    minLenWord = tmp;
                }
            }
        }
        map.put(key, minLenWord);
        return minLenWord;
    }
	
 String mergeAndGet(String word, String result){
        int l = word.length();
        int t = result.length();
        if(result.contains(word)) return result;
        if(word.contains(result)) return word;
        String ans ="";
        int found =l;
        for(int k=0; k<l ; k++){
            int i =k;
            int j =0;
            while(i<l && j< t){
                if(word.charAt(i) == result.charAt(j)){
                    i++;
                    j++;
                }else break;
            }
            if(i==l){
                found = k;
                break;
            }
        }
        return word.substring(0,found)+ result;
    }
}