class ReverseVowels {
   public String reverseVowels(String s) {       
      	HashSet<Character> chars = new HashSet<Character>();
        chars.add('a'); chars.add('e'); chars.add('i'); chars.add('o'); chars.add('u');
        chars.add('A'); chars.add('E'); chars.add('I'); chars.add('O'); chars.add('U');
        int left = 0, right = s.length() - 1;  
        char[] sc = s.toCharArray();
        boolean leftVowel = false, rightVowel = false;
        while (left < right) {
            leftVowel = chars.contains(sc[left]);
            rightVowel = chars.contains(sc[right]);
            
            if (leftVowel && rightVowel) {
                char swapper = sc[left];
                sc[left++] = sc[right];
                sc[right--] = swapper;
            } else {
                right -= (rightVowel) ? 0 : 1;
                left += (leftVowel) ? 0 : 1;
            }
        }
            
        return String.valueOf(sc);
    }
}