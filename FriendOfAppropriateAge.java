class FriendOfAppropriateAge{
   public int numFriendRequests(int[] ages) {

	Arrays.sort(ages);
	int res=0, n = ages.length, end=n-2, start=n-1;

	while(end>=0){
		double req = 0.5*(ages[start])+7;

		if(ages[end]>req){
			// the condition true means, all persons from start-end can make a request to new person
			res+=start-end;
			end--;
		}else{
			start--;
		}

		//to handle edge case
		if(end==start)
			end--;
	}

	//handling the duplicates
	// it also follows the same logic as above , only look for the duplicates and adds to result
	for(int i=0;i<n-1;){
		double req = 0.5*(ages[i])+7;
		int curr=i+1;
		while(curr<n && ages[i]==ages[curr] && ages[i]>req){
			res+=curr-i;
			curr++;
		}
		i = curr;
	}

	return res;

}
}
