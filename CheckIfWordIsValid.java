class CheckIfWordIsValid {
public boolean isValid(String s) {

    int i,j,k;
    
    StringBuilder sb = new StringBuilder(s);
    boolean flag=true;
    int ans=s.length();
    while(flag==true)
    {
        if((sb.toString()).contains("abc"))
        {
            int index=sb.indexOf("abc");
            sb.replace(index,index+3,"");
            flag=true;
            ans-=3;

        }

        else
        {
            flag=false;
        }
    }
    
    if(ans==0)
        return true;
    
    else
        return false;

    
}
}