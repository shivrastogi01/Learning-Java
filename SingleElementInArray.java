class SingleElementInArray{
public int singleNumber(int[] nums) {
//using XOR operator.
int res=0;
for(int i: nums){
res ^= i;
}
return res;
}
}