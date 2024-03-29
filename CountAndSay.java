/**
 * Find each state starting from 1st to nth.
 * 
 * Time Complexity: O(L(1) + L(2) + L(3) + ... + L(N-1) + L(N))
 *
 * Space Complexity: O(L(N-1) + L(N))
 *
 * N = Input number. L(N) = Length of Nth state
 */
class CountAnySay {
    public String countAndSay(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            sb = getNextState(sb);
        }
        return sb.toString();
    }

    private StringBuilder getNextState(StringBuilder curSb) {
        StringBuilder nextSb = new StringBuilder();
        int len = curSb.length();
        int i = 0;
		
        while (i < len) {
            char c = curSb.charAt(i++);
            int count = 1;
            while (i < len && c == curSb.charAt(i)) {
                count++;
                i++;
            }
            nextSb.append(count).append(c);
        }
		
        return nextSb;
    }
}