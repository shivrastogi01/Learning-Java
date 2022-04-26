class SumSubseqWidths {
    public int sumSubseqWidths(int[] arr1) {
        Arrays.sort(arr1);
        int n=arr1.length;
        int mod=(int)1e9+7;
        long ans=0l;
        long power=1l;
        for(int i=0;i<arr1.length;i++)
        {
            ans=((ans%mod)+power*(arr1[i]-arr1[n-i-1])+mod)%mod;
            power=(power<<1)%mod;
        }
        
        return (int)(ans%mod);
    }   
}