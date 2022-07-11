class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        
        char[] letters = tiles.toCharArray();
        Arrays.sort(letters);
        
        return  helper(letters, new boolean[tiles.length()]);
    }
    
    public int helper(char[] letters, boolean[] visited) {
        int count = 0;
        char prev = 0;
        for (int i = 0; i < letters.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (letters[i] == prev) {
                continue;
            }
            prev = letters[i];
            count++;
            visited[i] = true;
            count += helper(letters, visited);
            visited[i] = false;
        }
        return count;
    }
}