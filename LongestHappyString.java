class LongestHappyString {
    final int A = 0;
    final int B = 1;
    final int C = 2;
    final int NONE = -1;
    
    public String longestDiverseString(int a, int b, int c) {
        int[] available = {a,b,c};
        char[] letters = {'a', 'b', 'c'};
        
        StringBuilder ret = new StringBuilder();
        
        int selection = NONE;
        int lastSelection = NONE;
        int unusable = NONE;
        
        while(true) {
            selection = getMostFavorableLetter(available, unusable);
            if(selection == NONE)
                break;
            
            unusable = (lastSelection == selection) ? selection : NONE;
            
            ret.append(letters[selection]);
            available[selection]--;
            lastSelection = selection;
        }
        return ret.toString();
    }

    int getMostFavorableLetter(int[] available, int unusable) {
        int max = 0;
        int ret = -1;
        for(int i = 0; i < available.length; i++) {
            if(available[i] > max && i != unusable) {
                max = available[i];
                ret = i;
            }
        }
        return ret;
    }
}