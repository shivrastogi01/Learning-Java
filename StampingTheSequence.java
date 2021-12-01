class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        Stack<Integer> stack=new Stack<>();
        StringBuffer alls=new StringBuffer();
        for(int i=0;i<target.length();i++)
            alls.append('*');
        StringBuffer stampSizeAllStar=new StringBuffer();
        for(int i=0;i<stamp.length();i++)
            stampSizeAllStar.append('*');
        
        // System.out.println(alls+" "+target+" "+stampSizeAllStar);
        
        int stamps=0;
        int turns=10*target.length();
        while(!alls.toString().equals(target))
        {
            boolean foundMatch=false;
            for(int i=0;i<target.length()-stamp.length()+1;i++)
            {
                // System.out.println(stamp+" "+target.substring(i,i+stamp.length())+" "+equals(stamp,target.substring(i,i+stamp.length())));
                if(equals(stamp,target.substring(i,i+stamp.length())))
                {
                    stamps++;
                    foundMatch=true;
                    StringBuffer temp= new StringBuffer();
                    temp.append(target.substring(0,i));
                    temp.append(stampSizeAllStar);
                    temp.append(target.substring(i+stamp.length()));
                    target=temp.toString();
                    stack.push(i);
                    // System.out.println(target);
                }
            }
            if(!foundMatch)
                return new int[0];
        }
        if(stamps>turns)
            return new int[0];
        int[] ans=new int[stack.size()];
        int c=0;
        for(int i=stack.size()-1;i>=0;i--)
            ans[c++]=stack.pop();
        return ans;
    }
    
    public boolean equals(String s,String s1)
    {
        boolean hasChar=false;
        int i=0;
        while(i<s.length())
        {
            if(!hasChar && s1.charAt(i)>='a' && s1.charAt(i)<='z')
                hasChar=true;
            
            if(s.charAt(i)!=s1.charAt(i))
            {
                if(s1.charAt(i)!='*')
                    return false;
            }
            i++;
        }
        
        return hasChar&&true;
    }
}