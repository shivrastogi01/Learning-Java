class PreviousPermutationWithOneSwap{
public int[] prevPermOpt1(int[] arr) {

    int i=arr.length-2;
    int lastElem=arr[arr.length-1];
      
    while(i>=0 && arr[i]<=arr[i+1]) {
        i--; 
    }
    int j=0;
      
    if(i>=0){
        
        j=arr.length-1;
        
        while(arr[j]>=arr[i]) j--;
        
        while(j>0 && arr[j-1]==arr[j]) j--;
        
        swap(arr,i,j);
        
        return arr;
    }else{
        return arr;
    }
         
}
public void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

public boolean isRemainingSorted(int[] arr,int start){
    int end=arr.length-1;
    
    for(int i=start;i<=end-1;i++){
        if(arr[i]>arr[i+1]){
            return false;
        }
    }
    
    return true;
}
}