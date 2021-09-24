import java.util.*;


class RemoveDuplicateWithMultipleMethods{
	
	public static void removeDuplicateUsingSorting(int arr []){
		Arrays.sort(arr);
		 int j=0;
		 int len=arr.length -1;
		 
		 for(int i=0;i<len;i++){
			 if(arr[i]!=arr[i+1])
			 arr[j++]=arr[i];
			 
		 }
		arr[j++]=arr[len];
		for(int k=0;k<j;k++)
		System.out.print(arr[k] +" ");
	}
	
	public static void removeDuplicateUsingSet(int arr []){
		Set<Integer> st = new HashSet<>();
		 int len =arr.length-1;
		 for(int i =0;i<len;i++){
		 st.add(arr[i]);}
			 
		//	st.forEach(item -> System.out.print(item + " "));
			for( int item :st){
				System.out.print( item +  " ");
			} 
		 }
	public static void removeDuplicateUsingHashing(int arr []){
		Map<Integer, Integer> map =new HashMap<>();
		 int len =arr.length -1;
		 for(int i=0;i< len;i++){
			 if(map.containsKey(arr[i]))
			 map.put(arr[i] ,map.get(arr[i]) +1);
			 else
			 map.put(arr[i] ,1);		
        }
		 for (Integer key: map.keySet()) {
            System.out.print(key + " ");
		 }
	}
	
	
	public static void main(String [] args){
		int arr[] ={1,4,6,3,7,7,9,1,3,6,5,8,9,2};
		removeDuplicateUsingSorting(arr);
		System.out.println("");
		removeDuplicateUsingSet(arr);
		System.out.println("");
		removeDuplicateUsingHashing(arr);
		
		
	}


}