class CouplesHoldingHands {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int minSwapsCouples(int[] row) {
        for(int i=0; i<row.length;i++){
            map.put(row[i],i);
        }  
        int ans=0;
        for(int i=0;i<row.length; i+=2){
            int first = row[i];
            int second = row[i]+(first%2==0? 1:-1);
            if(row[i+1]!=second){
                ans++;
                swap(row, i+1, map.get(second));
            }
        }
        return ans;
        
    }
    
    public void swap(int[] row, int i, int j){
        int temp= row[i];
        row[i]=row[j];
        row[j]=temp;
        
        map.put(row[i], i);
        map.put(row[j], j);
    }
}