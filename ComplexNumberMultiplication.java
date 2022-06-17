class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        int idx1=findIdx(num1);
        int idx2=findIdx(num2);
        
        
        int rp1=Integer.parseInt(num1.substring(0,idx1));
        int rp2=Integer.parseInt(num2.substring(0,idx2));
        
        int im1=Integer.parseInt(num1.substring(idx1+1,num1.length()-1));
        int im2=Integer.parseInt(num2.substring(idx2+1,num2.length()-1));
        
        int ansR=(rp1*rp2)-(im1*im2);
        int ansI=(rp1*im2)+(rp2*im1);
        
        String res=ansR+"+"+ansI+"i";
        
        return res;
    }
    
    public int findIdx(String n){
        for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='+'){
                return i;
            }
        }
        
        return 0;
    }
    
}