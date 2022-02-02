class FindAllAnagramOfString {
public List findAnagrams(String s, String p) {
List result = new ArrayList();

    for(int i=0; i<=s.length()-p.length(); i++){          
        if(isAnagram(s, i, p))  result.add(i);
    }
    return result;
}

private boolean isAnagram(String s, int start, String p){
    int[] arr = new int['z'-'a'+1];
    
    for(int i=0; i<p.length(); i++){
        arr[s.charAt(start+i)-'a']++;
        arr[p.charAt(i)-'a']--;
    }
    
    for(int a: arr){
        if(a!=0) return false;
    }
    
    return true;
}
}