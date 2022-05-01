class LongestAbsoluteFilePath {
    int numTab(String s) {
        int num = 0;
        while (s.charAt(num) == '\t') num++;
        return num;
    }
    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");
        // Max  = all  tabs
        // This will hold size of last parent with index number of tabs.
        int[] tabs = new int[split.length];
        int max = 0;
        
        // Handle first file entry.
        if (split[0].indexOf(".") != -1) {
          max = split[0].length();
        } else {
          // Directory
          tabs[0] = split[0].length();
        }
        
        for (int i = 1; i <split.length;i++) {
            int tabcnt = numTab(split[i]);
            int parentsize = 0;
            // count "/" too to append child.
            if (tabcnt > 0) parentsize = tabs[tabcnt-1]+1;
            if (split[i].indexOf(".") != -1) {
			  // Parent  + Current - Tabs
              max = Math.max(max, parentsize + split[i].length() - tabcnt) ;
            } else {
              tabs[tabcnt] = parentsize + split[i].length() - tabcnt;
            }
        }
        
        return max;
                                     
    }
}