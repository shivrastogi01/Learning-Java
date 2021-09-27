class PartitionOfRoom
{
static int MOD = 1000000007;
 
// Function to return the count of
// ways to choose the balls
static int countWays(int n)
{
 
    // Calculate (2^n) % MOD
    int ans = 1;
    for (int i = 0; i < n; i++)
    {
        ans *= 2;
        ans %= MOD;
    }
 
    // Subtract the only where
    // no ball was chosen
    return ((ans - 1 + MOD) % MOD);
}
 
// Driver code
public static void main(String[] args)
{
    int n = 3;
 
    System.out.println(countWays(n));
}
}