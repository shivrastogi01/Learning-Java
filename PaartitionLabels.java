class PaartitionLabels {
public List partitionLabels(String s) {

    List<Integer> ans=new ArrayList<>();
    int i=0,tmp=-1;
    for(int k=0;k<s.length();k++)
    {
        if(tmp==k)
        {
            ans.add(tmp-i+1);
            i=k+1;
            continue;
        }
        else
        {
            int j=k+1,p=k;
            while(j<s.length())
            {
                if(s.charAt(k)==s.charAt(j))
                    p=j;
                j++;
            }
            if(p>=tmp)
                tmp=p;
            if(tmp<=k)
            {
                ans.add(tmp-i+1);
                i=k+1;
            }
        }
    }
    return ans;
    
}
}