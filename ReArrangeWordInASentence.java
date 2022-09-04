class ReArrangeWordInASentence{
   public String arrangeWords(String text) {
    
    String ans = "";
    String s = text.toLowerCase(); //Converts the string to lower case
    
    String[] w = s.split(" "); //Splits about space and stores the value in the array w.
    
    Arrays.sort(w, (a, b)->Integer.compare(a.length(), b.length())); //This method sorts the w array on basis of lengths of words.
    
    for(String element : w){
        ans+= element + " ";
    }// This method adds the sorted words from w to string ans
    
    return ans.substring(0, 1).toUpperCase() + ans.substring(1, text.length()); //At last, capitalizing the first letter and removing the trailing space to obtain the required output.
}
}