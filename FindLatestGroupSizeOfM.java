class FindLatestGroupSizeOfM{
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n){
            return n; 
        }
        
        // go backwards, from step n to 1,  change bit from 1 to 0
        List<Group> groups = new ArrayList<>();
        groups.add(new Group(1, n));
        for (int step = n; step >=m; step--){
            int groupIndex = findGroup(groups, arr[step - 1]);
            List<Group> subGroups = groups.get(groupIndex).divide( arr[step - 1] );
            for (var group : subGroups){
                if (group.length() == m){
                    return step - 1;
                }
            }
            if (subGroups.size() == 0){
                groups.remove(groupIndex); // remove original group
            } else {
                
                groups.set(groupIndex, subGroups.get(0)); // replace the original group with 1st sub-group
                if (subGroups.size() > 1){
                    groups.add(groupIndex+1, subGroups.get(1)); // insert the 2nd sub-group to right after the 1st sub-group
                }
            }
        }
        return -1;
    }
    
    int findGroup(List<Group> groups, int index){
        int start = 0, end = groups.size() - 1;
        if (groups.get(start).includes(index)){
            return start;
        }
        if (groups.get(end).includes(index)){
            return end;
        }
        while (start <= end){
            int middle = start + (end - start) / 2;
            var group = groups.get(middle);
            if (group.includes(index)){
                return middle;
            }
            if (group.end < index){
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1; // not found, impossible
    }
    
    class Group{
        public int start;
        public int end;
        
        public Group(int start, int end){
            this.end = end;
            this.start = start;
        }
        
        public int length(){
            return end - start + 1;
        }
        
        public boolean includes(int position){
            return position <= end && position >= start;
        }
        
        public List<Group> divide(int position){
            List<Group> groups = new ArrayList<>();
            if (position > start){
                groups.add(new Group(start, position-1));
            }
            if (position < end){
                groups.add(new Group(position+1, end));
            }
            return groups;
        }
        
        public String toString(){
            return String.format("[%d..%d]", start, end);
        }
    }
}