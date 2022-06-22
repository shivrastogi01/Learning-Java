class PrefixSuffixSearch {

    Trie preRoot;
    Trie sufRoot;
    int max = 0;
    public WordFilter(String[] words) {
        max = words.length;
        preRoot=new Trie();
        sufRoot=new Trie();
        for (int k = 0; k < words.length; k++){ // build both tries
            Trie pcur = preRoot;
            Trie scur = sufRoot;
            for (int i = 0, j = words[k].length()-1; i < words[k].length(); i++, j--){
                int a = words[k].charAt(i)-'a', b = words[k].charAt(j)-'a';
                if (pcur.nodes[a]==null){
                    pcur.nodes[a]=new Trie();
                }
                if (scur.nodes[b]==null){
                    scur.nodes[b]=new Trie();
                }
                pcur=pcur.nodes[a];
                scur=scur.nodes[b];
                pcur.idx.set(k); // add the index to bitset.
                scur.idx.set(k);
            }
        }
    }

    public int f(String prefix, String suffix) {
        Trie p = preRoot, s = sufRoot;
        for (char ch : prefix.toCharArray()){
            if ((p=p.nodes[ch-'a'])==null)
                return -1;
        }
        for (int i = suffix.length()-1; i>=0;i--){
            if ((s=s.nodes[suffix.charAt(i)-'a'])==null)
                return -1;
        }
        BitSet c = (BitSet)s.idx.clone();
        c.and(p.idx);
        return c.previousSetBit(max); // find the highest set bit.
    }

    private class Trie{
        Trie[] nodes = new Trie[26];
        BitSet idx = new BitSet();
        Trie(){};
    }
}