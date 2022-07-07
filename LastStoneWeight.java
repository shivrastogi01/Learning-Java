class LastStoneWeight{
public int lastStoneWeightII(int[] stones) {
int dp[] = new int[15000];
int sum = 0;
for(int i=0;i<stones.length;i++){
sum += stones[i];
}
int target = sum / 2;
for(int i=0;i<stones.length;i++){
for(int j=target;j>=stones[i];j--){
dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
}
}
return sum - dp[target] - dp[target];
}
}