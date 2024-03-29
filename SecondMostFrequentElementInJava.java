import java.util.Arrays;
 
class SecondMostFrequentElementInJava
{
public static void countFreq(int arr[], int n)
{
    boolean visited[] = new boolean[n];
     
    Arrays.fill(visited, false);
 
    // Traverse through array elements and
    // count frequencies
	int array[]= new int[n];
	int res=0;
    for (int i = 0; i < n; i++) {
 
        // Skip this element if already processed
        if (visited[i] == true)
            continue;
 
        // Count frequency
        int count = 1;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                visited[j] = true;
                count++;
            }
        }
        System.out.println(arr[i] + " " + count);
		array[i]=count;
		
    }
	Arrays.sort(array);
	res=array[n-2];
	System.out.println(res);
}
 
// Driver code
public static void main(String []args)
{
    int arr[] = new int[]{ 10, 20, 20, 10, 10, 20, 5, 20 };
    int n = arr.length;
    countFreq(arr, n);
}
}