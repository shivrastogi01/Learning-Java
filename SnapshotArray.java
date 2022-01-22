class SnapshotArray {
    int snapshotid;
    TreeMap[] arr;
    public SnapshotArray(int length) {
        snapshotid = 0;
        arr = new TreeMap[length];
        for(int i = 0; i < length; i++)
        {
            arr[i] = new TreeMap<Integer, Integer>();
        }
    }
    
    public void set(int i, int val) {
        TreeMap<Integer, Integer> map = (TreeMap<Integer, Integer>)arr[i];
        arr[i].put(snapshotid, val);
    }
    
    public int snap() {
        return snapshotid++;
    }
    
    public int get(int i, int snap_id) {
        TreeMap<Integer, Integer> map = (TreeMap<Integer, Integer>)arr[i];
        Integer target = map.floorKey(snap_id);
        if(target==null)return 0;
        return map.get(target);
    }
}