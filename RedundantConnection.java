class RedundantConnection{
    public int[] findRedundantConnection(int[][] edges) {
        int []a=new int[edges.length+1];
        for(int i=0;i<edges.length;i++){
            int xx=edges[i][0];
            int yy=edges[i][1];
            int x=edges[i][0];
            int y=edges[i][1];
            
            while(a[x]!=0){
                x=a[x];
            }
            while(a[y]!=0){
                y=a[y];
            }
            if(x!=y){
                a[y]=x;    
            }
            else{
                return new int[]{xx,yy};
            }
        }
        return new int[]{-1,-1};
    }
}