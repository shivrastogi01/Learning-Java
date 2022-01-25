class LetterCasePermutation {

public List<String> letterCasePermutation(String s) {
List<String> res = new ArrayList();
    String op = "";
    helper(res,s,op);
    return res;
}

void helper(List<String> res,String ip, String op){
    if(ip.length()==0){
        res.add(op);
        return;
    }
    if(Character.isAlphabetic(ip.charAt(0))){
        String op1 = op;
        String op2 = op;
        op1 += (Character.toLowerCase(ip.charAt(0)));
        op2 += (Character.toUpperCase(ip.charAt(0)));
        helper(res,ip.substring(1,ip.length()),op1);
        helper(res,ip.substring(1,ip.length()),op2);
    }
    else{
         helper(res,ip.substring(1,ip.length()),op+(ip.charAt(0)));
    }
    return;
}
}

