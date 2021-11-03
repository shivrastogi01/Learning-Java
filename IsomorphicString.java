class IsomorphicString{
public boolean isIsomorphic(String s, String t) {

//first hashmap to check forward mapping
HashMap<Character,Character> hm1=new HashMap<Character,Character>();
//second hashmap to check backward mapping
HashMap<Character,Character> hm2=new HashMap<Character,Character>();

if(s.length()!=t.length()) //length of both string must be equal
    return false;
		
int len1=s.length();
int len2=t.length();
    
for(int i=0;i<len1;i++)
 {
        if(hm1.containsKey(s.charAt(i)))
            if(hm1.get(s.charAt(i))!=t.charAt(i))
                return false;
            else
                continue;
        else
            hm1.put(s.charAt(i),t.charAt(i));
}
   
 for(int i=0;i<len2;i++)
  {
        if(hm2.containsKey(t.charAt(i)))
            if(hm2.get(t.charAt(i))!=s.charAt(i))
                return false;
            else
                continue;
        else
            hm2.put(t.charAt(i),s.charAt(i));
 }
    return true;
    }
}