class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // TreeSet<Integer> bst = new TreeSet<>();
        List<Integer> bst = new ArrayList<>();
            
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            if (arr[i] == 0) {
                bst.add(i);
                ans[i] = 1;
                
            } else {
                // check if this causes floor or not
                int lastIdx = map.getOrDefault(arr[i], -1);
                
                if (lastIdx == -1) {
                    map.put(arr[i], i);
                    ans[i] = -1;
                    
                } else {                    
                    // find if we can dry this out
                    // Integer dryIdx = bst.higher(lastIdx);
                    Integer dryIdx = binarySearch(bst, lastIdx);
                    if (dryIdx == null) {
                        // flood !!!
                        return new int[0];
                    } 
                    ans[dryIdx] = arr[i];
                    bst.remove(dryIdx);
                    map.put(arr[i], i);
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
    
    public Integer binarySearch(List<Integer> arr, int k) {
        // we need to find ceil of k
        if (arr.size() == 0) return null;
        int si = 0, ei = arr.size();
        while (si < ei) {
            int mid = (si + ei) >> 1;
            if (arr.get(mid) > k) {
                ei = mid;
            } else {
                si = mid + 1;
            }
        }
        if (si == arr.size()) return null;
        else if (si == 0) {
            if (arr.get(si) <= k) return null;
        }
        return Integer.valueOf(arr.get(si));
    }
}
