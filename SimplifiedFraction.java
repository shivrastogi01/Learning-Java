class SimplifiedFraction {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList();
        HashSet<Double> v = new HashSet();
        
        for(int i=1; i<n; i++) {
            for(int j=2; j<=n; j++) {
                double val = (double)i/j;
                if (val > 0 && val < 1 && !v.contains(val)) {
                     v.add(val);
                     ans.add(i+"/"+j);
                }
            }
        }
        return ans;
    }
}