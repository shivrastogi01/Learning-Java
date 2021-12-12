class Node {
    Node[] kids; 
    public Node(){
        this.kids = new Node[26];;
    }
}

class LongestWordInDictionary {
    String max = "";
    public String longestWord(String[] words) {
        Comparator<String> comp = Comparator.comparingInt(String::length)
            .thenComparing(Comparator.reverseOrder());
        Arrays.sort(words, comp);

        Node root = new Node();
        for(String word : words){
            populateTrie(word, root);
        }
        return max;
        
    }
    
    public void populateTrie(String word, Node node){
        for(int i = 0; i < word.length() - 1; i++){
            if(node.kids[word.charAt(i) - 'a'] == null) return;
            node = node.kids[word.charAt(i) - 'a'];
        }
        char lastChar = word.charAt(word.length() - 1);
        node.kids[lastChar - 'a'] = new Node();
        max = word;
    }
}