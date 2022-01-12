class VowelSpellChecker {
Set<Character> set = null;

Solution()
{
    set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
}

public String[] spellchecker(String[] wordlist, String[] queries) {
    Map<String,String> exactMatch = new HashMap<>();
    Map<String,List<String>> ciMatch = new HashMap<>();
    Map<String,List<String>> woVowelsMatch = new HashMap<>();
    
    for(String word : wordlist)
    {
        exactMatch.put(word,word);
        String lword = word.toLowerCase();
        ciMatch.putIfAbsent(lword, new LinkedList<>());
        ciMatch.get(lword).add(word);
        
        String wovWord = convert(word.toLowerCase());
        woVowelsMatch.putIfAbsent(wovWord, new LinkedList<>());
        woVowelsMatch.get(wovWord).add(word);
    }
    
    String[] result = new String[queries.length];
    for(int i = 0; i < queries.length; i++)
    {
        String correct = "";
        if(exactMatch.containsKey(queries[i]))
        {
            correct = exactMatch.get(queries[i]);
        }
        else if(ciMatch.containsKey(queries[i].toLowerCase()))
        {
            correct = ciMatch.get(queries[i].toLowerCase()).get(0);
        }
        else if(woVowelsMatch.containsKey(convert(queries[i].toLowerCase())))
        {
            correct = woVowelsMatch.get(convert(queries[i].toLowerCase())).get(0);
        }
        
        result[i] = correct;
    }
    
    return result;
}

String convert(String word)
{
    
    StringBuilder sb = new StringBuilder();
    for(char c : word.toCharArray())
    {
        if(set.contains(c))
        {
            sb.append('*');
        }
        else
        {
            sb.append(c);
        }
    }
    
    return sb.toString();
}
}