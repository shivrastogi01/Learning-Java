class EvaluateDigit{
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		// Job 1, simplify the question, convert equations and values into data
        double data[][]=new double[2*equations.size()][2*equations.size()];
        int index=0;
        Map<String,Integer> idMap=new HashMap();
        for(int i=0;i<equations.size();i++){
            List<String> l=equations.get(i);
            String s1=l.get(0);
            String s2=l.get(1);
            int i1=idMap.getOrDefault(s1,-1);
            if(i1==-1){
                i1=index++;
                idMap.put(s1,i1);
            }
            int i2=idMap.getOrDefault(s2,-1);
             if(i2==-1){
                i2=index++;
                idMap.put(s2,i2);
            }
			// here ,if we know a/b=r; then b/a=1/r
            data[i1][i2]=values[i];
            data[i2][i1]=1.0/values[i];
        }
        
		// job 2, find the answers
        int seen[]=new int[index];
        double res[]=new double[queries.size()];
        for(int i=0;i<res.length;i++){
            List<String> l=queries.get(i);
            int i1=idMap.getOrDefault(l.get(0),-1);
            int i2=idMap.getOrDefault(l.get(1),-1);
            res[i]=helper(i1,i2,data,seen);
            Arrays.fill(seen,0);
        }
        return res;
    }
    
	// dfs
    private double helper(int a,int b,double data[][],int seen[]){
        if(a<0 || b<0){
            return -1;
        }
		// if the answer is already there, return it
        if(data[a][b]>0){
            return data[a][b];
        }
        seen[a]=1;
        for(int i=0;i<data.length;i++){
            if(data[a][i]>0 && seen[i]==0){
                double temp=helper(i,b,data,seen);
                if(temp>0){
                    double res= data[a][i]*temp;
					// here since we find the answer of a/b, don't waste it, save it in data
					// but because the test case is too small ,we can't see the difference with or without these two lines
                    data[a][b]=res;
                    data[b][a]=1.0/res;
                    return res;
                }
            }
        }
        return -1;
    }
}