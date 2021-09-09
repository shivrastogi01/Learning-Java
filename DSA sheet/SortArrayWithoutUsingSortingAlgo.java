import java.util.*;
//Dutch national flag algo
class SortArrayWithoutUsingSortingAlgo{
	public static void main(String [] args){
int arr []={2,1,0,0,1,2,0,0,1,2,0,1};
sortNums(arr);


	}
	public static void sortNums(int arr[] ){
		System.out.println("hii");
		int low= 0,mid=0, high =arr.length-1, temp;
		while(mid <= high){
			switch(arr[mid]){
				case 0:{
				temp=arr[low];
				arr[low]=arr[mid];
				arr[mid]= temp;
				low ++;
				mid++;
				break;}
				case 1:{
				mid ++;
				break;}
				case 2:{
				temp=arr[mid];
				arr[mid]=arr[high];
				arr[high]=temp;
				high --;
				break;
				}
			}
			
		}
		for(int i=0;i<arr.length;i++)
		System.out.println(arr[i]);
	}
}