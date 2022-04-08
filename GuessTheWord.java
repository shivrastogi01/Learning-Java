class GuessTheWord{
    
    private String getMostCommonWord(String[] wordlist){
        int[][] count = new int[wordlist[0].length()][26];
        int matches = 0;
        for(String word: wordlist){
            char[] ch = word.toCharArray();
            for(int i = 0; i < 6; i++){
                count[i][ch[i] - 'a']++;
            }        
        }
        int best_score = Integer.MIN_VALUE;
        int curr_score = 0;
        String common = "";
        for(String word: wordlist){
            char[] ch = word.toCharArray();
            for(int i = 0; i < 6; i++){
                curr_score += count[i][ch[i] - 'a'];
            }  
            if(curr_score > best_score){
                best_score = curr_score;
                common = word;
            }
            curr_score = 0;
        }
        
        return common;
    }
    
    public void findSecretWord(String[] wordlist, Master master) {
  
        for(int i = 0, matches = 0; i < 10; i ++){
            String guess = getMostCommonWord(wordlist);
            matches = master.guess(guess);
            if(matches == 6)
                return;
            List<String> candidates = new ArrayList<>();
            for(String word: wordlist){
                if(word != guess){
                    if(matches == getMatches(guess, word)){
                        candidates.add(word);
                    }
                }
            }  
            wordlist = candidates.toArray(new String[0]);
        }
         
    }
    
    private int getMatches(String word1, String word2){
        int matches = 0;
        for(int i = 0; i < word1.length(); i ++){
            if(word1.charAt(i) == word2.charAt(i)){
                matches ++;
            }
        }
        
        return matches;
    }
}