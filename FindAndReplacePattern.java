class FindAndReplacePattern{
   public List<String> findAndReplacePattern(String[] words, String pattern) {
        int j=0;
		List<String> patternStrings = new ArrayList<>();
		for(int i=0;i<words.length;i++){
			String currentWord = words[i];
			Map<Character,Character> hmap = new HashMap<>();

			boolean broke = true;
			while(j<currentWord.length()){
				if(hmap.containsKey(currentWord.charAt(j)) || hmap.containsValue(pattern.charAt(j))){ 
					if(hmap.containsKey(currentWord.charAt(j)) && hmap.get(currentWord.charAt(j))==pattern.charAt(j)){

					}
					else{
						broke=false;
						break;
					}
				}
				else{ 
					hmap.put(currentWord.charAt(j),pattern.charAt(j));
				}
				j++;
			}
			j=0;
			if(broke){
				patternStrings.add(currentWord);
			}

		}
		return patternStrings;
    }
}