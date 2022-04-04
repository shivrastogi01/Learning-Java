class CheckArithmeticSubArrays {

public List<Boolean> checkArithmeticSubarrays(int[] n, int[] l, int[] r) {
    int k=l.length;
    List<Boolean> nm=new ArrayList<>();
    for(int i=0;i<k;i++)
    {
        int a[]=new int[r[i]-l[i]+1];
        for(int j=0,f=l[i];f<=r[i];f++,j++)
        {
            a[j]=n[f];
        }
        Arrays.sort(a);
        int f,v=(r[i]-l[i]+1),x=a[1]-a[0];
        for(f=1;f<v-1;f++)
        {
            if(a[f+1]-a[f]!=x)
                break;
        }
        if(f==v-1)
            nm.add(true);
        else
            nm.add(false);
    }
    return nm;
}
}