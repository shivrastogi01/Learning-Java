class MinimumDeletionToMakeStringUnique {
    public int minDeletions(String s) {
        int[] alp=new int[26];
       
	   // store the frequecy of each character 
        for(int i=0;i<s.length();i++){
            alp[s.charAt(i)-'a']++;
        }
        int ans=0;
        
		//is used to make frequecy is unique
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(alp[i]!=0){  //if alp[i]==0 then number of character is 0   
                if(!arr.contains(alp[i])){   // if it is come first time then just add it 
                    arr.add(alp[i]);
                }else{    //it comes previously ,(we need to make it unique
                    int t=alp[i];
                   
                    while(arr.contains(t) && t>0){    // we decrement t untill it become unique or 0
                        t--;
                        ans++;
                    }
                    arr.add(t);
                }
            }
        }
        return ans;
    }
} 
