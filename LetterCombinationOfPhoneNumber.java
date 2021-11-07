class LetterCombinationOfPhoneNumber{
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if(digits.isEmpty())    return list;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for(int i=0; i<digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(list.peek().length() == i){
                String rem = list.remove();
                for(char c : mapping[x].toCharArray())
                    list.add(rem+c);
            }
        }
        return list;
    }
}