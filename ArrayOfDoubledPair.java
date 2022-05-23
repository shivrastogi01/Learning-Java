class ArrayOfDoubledPair {
	public boolean canReorderDoubled(int[] arr) {
		if(arr.length== 0) return true;

		//Create a Hashmap to store the frequency of the elements
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int ele:arr){
			map.put(ele,map.getOrDefault(ele,0)+1);
		}

		/* Now we need to sort the array, and after sorting if we traverse through each  element, we hope to find the double of the element, but this will be valid only for positive elements, 
		 for eg: we have a positive array: [4,2,7,14] 
		After sorting it becomes :[2,4,7,14] 
		It can give us pairs like :(2,4), (7,14) 
		but for negative if we sort:[-8,-10,-5,-4]->[-10,-8,-5,-4]
		here we will need to find the half of the first elements we encounter*/

		//so we use the lambda expression, which will sort it using its absolute value

		Integer[] ar = new Integer[arr.length];
		for(int i=0;i<arr.length;i++) ar[i]=arr[i];

		Arrays.sort(ar,(a,b)->{
			return Math.abs(a)-Math.abs(b);
		}); // this statement will return +ve, i.e a>b, 
			// if returns -ve, i.e a<b, and 0,if a==b
/* Now for an array [-8,-10, 4, 2, 0, 0,-4. 6,-5,3] 
we have [-4,-5,-8,-10,0,0,2,3,4,6]  in the sorted manner so we keep traversing from the first element pair it up with its double */

		for(int ele:ar){
			if(map.get(ele)==0) continue;   //if the freq of that element gets exhausted we continue;                                       

			if(map.getOrDefault(2*ele,0)==0){
				return false;
			}
			/*if we need to have the double value of the element but the value exhausts we return false 

		   as we keep making pairs of elements we decrese the freq of the elements from the freq hashmap used.*/ 
			 map.put(ele,map.get(ele)-1);
			 map.put(2*ele,map.get(2*ele)-1);

		}
		return true;
	}
}