class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        List<Integer> fir = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            fir.add(nums1[i]);
        }
        for (int i = 0; i<n; i++) {
            int v = nums2[i];
            int idx = binarySearch(fir, v);
            nums1[i] = fir.get(idx);
            fir.remove(idx);
        }
        return nums1;
    }
    public int binarySearch(List<Integer> list, int v) {
        // apply the greedy idea
        // find the first element greater than v, therefore nums1[i] > nums2[i]
        // if there's no such element than return the smallest element
        int lo = 0, hi = list.size()-1, ans = 0; 
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            int cur = list.get(mid);
            if (cur>v) {
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }
}