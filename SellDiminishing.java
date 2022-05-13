class SellDiminishing{
    public int maxProfit(int[] inventory, int orders) {
        int mod = (int)1e9 + 7;
        Arrays.parallelSort(inventory);
        long sum = 0L;
        long pre = 1L;
        int n = inventory.length;
        int count = 1;
        for (int i = n - 1; i >= 0; i--) {
            while (i > 0 && inventory[i] == inventory[i - 1]) {
                count++;
                i--;
            }
            int diff = orders / count;
            if (diff == 0) {
                sum += pre * inventory[i] * orders;
                break;
            }
            if (i == 0 || inventory[i] - inventory[i - 1] >= diff) {
                sum += getSumToDiff(count, inventory[i], diff);
                orders -= count * diff;
                sum += pre * orders % count * (inventory[i] - diff);
                break;
                
            } else {
                diff = inventory[i] - inventory[i - 1];
                sum += getSumToDiff(count, inventory[i], diff);                
                orders -= count * diff;
                count++;
            }
        }                
        return (int)(sum % mod);
    }
    private long getSumToDiff(int count, long value, long diff) {
        return count * (((value << 1) - diff + 1)) * (diff) / 2;
    }
}