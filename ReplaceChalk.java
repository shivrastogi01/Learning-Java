class ReplaceChalk {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;int n=chalk.length;
        for(int i=0;i<n;i++){
            sum+=chalk[i];
        }
        k%=sum;
        int i;
        for(i=0;i<n;i++){
            if(chalk[i]<=k){
                k-=chalk[i];
            }
            else{
                break;
            }
        }
        return i;
    }
}