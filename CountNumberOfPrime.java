class CountNumberOfPrime {
public int countPrimes(int n) {
       boolean[] isPrime = new boolean[n];
        // mark true everywhere in boolean array
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }
  
       for (int i = 2; i * i < n; i++) {
           // already prime nhi h to continue
          if (!isPrime[i]) continue;
           // mutiple of that number mark as false
          for (int j = i * i; j < n; j += i) {
             isPrime[j] = false;
          }
       }
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i] == true){
              count++;
          }
       }
       return count;
    }
}