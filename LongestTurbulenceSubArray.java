class LongestTurbulenceSubArray{
    int globalMax=0;
    
    public int maxTurbulenceSize(int[] A) {
    
        if(A.length==1)
            return 1;
        
        //Count will begin from 1 as anyhow we begin with an element so array element no has to be one initially 
        solve(A,0,1,true,1);//for increasing ..decreasing ..increasing ..seq pattern 
        
        solve(A,0,1,false,1);//for decreasing ..increasing..decreasing..seq pattern 
        
        return globalMax;
        
        
    }
    
    public void solve(int A[],int i,int j,boolean IsNextInc,int count)
    {
        globalMax=Math.max(globalMax,count);
        
        //base case 
        if(j==A.length)
            return;
        
        if(IsNextInc==true && A[j]>A[i])
        {
            solve(A,j,j+1,!IsNextInc,count+1);//next has to be decreasing ....
        }
        else if(IsNextInc==false && A[j]<A[i])
        {
            solve(A,j,j+1,!IsNextInc,count+1);//next has to be decreasing .....
            
        }
        
        else 
        {
            //either sequence broke due to two consecutive eleemnets are equal OR INC-->>DEC-->>DEC  OR DEC-->>INC-->>INC.. pattern 
            
            if(A[i]==A[j])//two consecutive elements of array are same ie 1st case of violation 
            {
                solve(A,j,j+1,!IsNextInc,1);//reset the parameters we will ex : [2,8,8,8,9] after 2,8 condition violates so we will start from 8 again hence count becomes 1 and nextInc will be reset back to default to start fresh  as after 8 now we definately want a greater val for increasing . Same logic goes for decreasing sequence also 
            }
            else 
            {
                solve(A,j,j+1,IsNextInc,2);//if in a case like [2,8,10] after 2>8 we expect a lesser val but we get a higher val so we terminate the sequence and start from (8,10). Since it will have 2 elements so count starts from 2 and we want a lesser val so IsNext remains same ..... 
            }
        }
        
    }
}