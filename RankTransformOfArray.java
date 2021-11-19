class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        
        List<Integer> indexes = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            indexes.add(i);
        }
        
        indexes.sort((i, j) -> Integer.compare(arr[i], arr[j]));
        
        int rank = 0;
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int idx = indexes.get(i);
            int val = arr[idx];
            if (prev == Integer.MAX_VALUE || val != prev) {
                rank++;
            }

            arr[idx] = rank;
            prev = val;

        }
        
        return arr;
    }
}