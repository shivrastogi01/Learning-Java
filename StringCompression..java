class StringCompression {
    public int compress(char[] chars) {
        char lastChar=chars[0];
        int number=1;
        int res=0;
        for(int i=1;i<chars.length;i++){
            if(lastChar==chars[i]){
                number++;
            }else{
                chars[res]=lastChar;
                lastChar=chars[i];
                res+=1;
                res=parseNumber(chars,res,number);
                number=1;
            }
        }
        chars[res]=lastChar;
        res+=1;
        res=parseNumber(chars,res,number);
        return res;
    }
    
    private int parseNumber(char chars[],int pos,int number){
        if(number>1){
            int startPos=pos;
            while(number!=0){
                int num1=number/10;
                int num2=number%10;
                chars[pos]=(char)(num2+'0');
                number=num1;
                pos++;
            }
            reverse(chars,startPos,pos-1);
        }
        return pos;
    }
    
    private void reverse(char[] chars,int left,int right){
        while(left<right){
            swap(chars,left++,right--);
        }
    }
    
    private void swap(char[] v,int i,int j){
        char c=v[i];
        v[i]=v[j];
        v[j]=c;
    }
}