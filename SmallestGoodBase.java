class SmallestGoodBase {

// whether target value can be made from selected base or not 

public int isPossible(long base, int digits, long targetValue){
    
    if(base >= targetValue)
            return 1;
    
    long mul = 1;
    for(int i = 0 ;(i < digits && targetValue>=0); i++){  
        targetValue-=mul;
        if( i != digits-1){
            if(mul > targetValue/base)
                    return 1;
        }
        mul = mul*base;
    }
    
    
    if(targetValue == 0)
            return 0;
    if(targetValue > 0)
            return -1;
    return 1;
    
    
}

public String smallestGoodBase(String n) {
    
    long value = Long.valueOf(n);
    String tempSol = String.valueOf(value-1);
    
	/* 
	
	basic info: 
	1.every number n can be represented as  (1 1) base (n-1), 
	so max Value of base is n-1,
	
	2.since the value can vary from 3 to 10^18 that can be accomodated in max 64 digits
	(smallest base : 2, max digits :63 , maximum base : n-1, min digits :2)
	
	3. we have to minimise the base hence have to find maximum length representation of all ones.
	
	4.for each no of digits we would try to find whether or not there exists a base which would give value equal to the required value.
	
	5. this can be found using binary search, consider a representation of number
	 of length n containing all one's and two bases b1 and b2 , if b1 < b2 then (n base b1) < (n base b2)
	
	
	*/
    for(int i = 64 ; i >= 2 ; i--){
        
        long currSol=-1;
        long low = 2;
        long high = value-1;
        
        while(low <= high){
            
            long currBase = (high-low)/2+low;
            currSol = isPossible(currBase,i,value);
			// function returns :-
            // if possible : 0
            // if greater than required: 1
            // if lesser than required: -1
            if(currSol == 0){
                return String.valueOf(currBase);
            }
            
            if(currSol == 1 ){
                high = currBase-1;
            }else{
                low = currBase+1;
            }
             
        }
        
        
        
    }
    return tempSol;
     
}
}