class MaskingPersonalInformation {
    public String maskPII(String s) {    
        if(s.indexOf('@')!=-1)
        {
            return maskEmail(s);
        }
        else
        {
            return maskPhone(s);
        }    
    } 
    public String maskEmail(String s)
    {
        StringBuilder sb=new StringBuilder();
        int index=s.indexOf('@');
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(i==0 || i>index)
            {            
                sb.append(Character.toLowerCase(ch));
            }
            else {
                sb.append("*****");
                sb.append(Character.toLowerCase(s.charAt(index-1)));
                sb.append('@');
                i=index;
            }     
        }
        return sb.toString(); 
    }
    
    public String maskPhone(String s)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {   
            if(Character.isDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        String str=sb.toString();
        int countryCode=str.length()%10;
        sb=new StringBuilder();
        if(countryCode>0){
            sb.append('+');
            for(int c=0;c<countryCode;c++)
                sb.append('*');
            sb.append('-');
        }
        sb.append("***-***-");
        sb.append(str.substring(countryCode+6));
        return sb.toString();
        }
    
}