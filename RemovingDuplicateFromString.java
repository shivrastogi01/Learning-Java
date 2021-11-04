class RemovingDuplicateFromString {
public String removeDuplicateLetters(String s) {

    char A[] = s.toCharArray();
    String ans = "";
    int hash[] = new int[26];
    boolean visited[] = new boolean[26];
    Stack<Character> st = new Stack<Character>();
    for(int i = 0; i < A.length; i++)
        hash[A[i]-97]++;
    
    for(int i = 0; i < A.length; i++){
        if(st.isEmpty()){
            st.push(A[i]);
            hash[A[i]-97]--;
            visited[A[i]-97] = true;
        }
        else if(visited[A[i]-97] == true)
            hash[A[i]-97]--;
        else if(visited[A[i]-97] == false){
            char c = A[i];
            hash[A[i]-97]--;
            
            while(!st.isEmpty()){
                
                char ch = st.peek();
                if(hash[ch-97] > 0 && ch > c){
                    st.pop();
                    visited[ch-97] = false;
                }
                else
                    break;
            }
            if(visited[c-97] == false){
                st.push(c);
                visited[c-97] = true;
            }
        }
    }
    while(!st.isEmpty())
        ans = st.pop()+ans;
    return ans;
}
}