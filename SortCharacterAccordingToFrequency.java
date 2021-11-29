class SortCharacterAccordingToFrequency {
public String frequencySort(String s) {

    HashMap<Character,Integer> map=new HashMap<>();
    
    List<Character> p=new ArrayList<>();
    for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(map.containsKey(ch))
            map.put(ch,map.get(ch)+1);
        else{
            map.put(ch,1);
            p.add(ch);
        }
    }
    
    
    Collections.sort(p,(x,y) -> (map.get(y)-map.get(x)));
    
    
    StringBuilder st=new StringBuilder();
    
    for(char c: p)
    {
        int y=map.get(c);
        while(y>0){
            st=st.append(c);
            y--;
        }
    }
    
    return st.toString();
}
}