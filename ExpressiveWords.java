class ExpressiveWords{
   public int expressiveWords(String s, String[] words) {
    int stretchy = 0;
    for (String word : words) {
      if (isStretchy(s, word)) stretchy++;
    }
    return stretchy;
  }

  public boolean isStretchy(String s, String word) {
    int si = 0, wi = 0, wlen = word.length(), slen = s.length();
    while (si < slen && wi < wlen) {
      int scount = 0, wcount = 0;
	 
      if (s.charAt(si) != word.charAt(wi)) return false;
        
      char c = word.charAt(wi);
	  // Keep itearting both the strings from the starting character matched as long as the same character repeats
	  // and keep counting the occurences of char c in both  
      while (wi < wlen && word.charAt(wi) == c) { wi++; wcount++; }
      while (si < slen && s.charAt(si) == c) { si++; scount++; }

      if (scount < 3 && scount != wcount || scount >= 3 && scount < wcount) return false;
    }
	// True - only if we have passed all the characters till the end
    return si == slen && wi == wlen;
  }
}