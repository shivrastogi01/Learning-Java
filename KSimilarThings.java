class KSimilarThings {
 public int kSimilarity(String s1, String s2) {
        Set<String> checked = new HashSet();
        checked.add(s1);
        Queue<String> queue = new LinkedList();
        queue.offer(s1);
        
        int level = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i ++){
                String curr = queue.poll();
                if(curr.equals(s2)) return level;
                
                List<String> next = getNext(curr,s2); // Get next states by swapping one position
                for(String n : next){
                    if(!checked.contains(n)){
                        queue.offer(n);
                        checked.add(n);
                    }
                }    
            }
            level += 1;
        }
        return level;
    }
    
    // We can optimise next valid state, ignore all first chars which are already matching
    private List<String> getNext(String s1, String s2) {
        int i = 0;
        List<String> next = new ArrayList();
        while(i < s1.length() && s1.charAt(i) == s2.charAt(i)){
            i += 1;
        }
        char[] arr = s1.toCharArray();
        for(int j=i+1;j<s1.length();j++){
            if(arr[j] == s2.charAt(i)){// Now get the next char from s1 which is matching with s2.charAt(i)
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                next.add(new String(arr));
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;    
            }
        }
        return next;
    }
}