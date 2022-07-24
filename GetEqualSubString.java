class GetEqualSubString {
public int equalSubstring(String s, String t, int maxCost) {
int[] diff = new int[s.length()];
int max = 0,sum=0,count=0,j=0;

    for(int i =0 ;i<s.length();i++){
       diff[i] = Math.abs(s.charAt(i)-t.charAt(i));
        sum+=diff[i];
        if(sum<=maxCost) count++;
        else{
            sum-=(diff[j++]+diff[i--]);
            count--;
        }
        max = Math.max(max,count);
    }
  return max;
}
}