class PushDomino {
   public String pushDominoes(String dominoes) {
        return process(dominoes);
    }

    public String process(String d) {
        String ne = d;
        char[] left = new char[d.length()];
        char[] right = new char[d.length()];

        left[right.length-1] = d.charAt(right.length-1);
        for (int i = 1; i < d.length(); i++) {
            if (d.charAt(i) == 'L' && d.charAt(i-1) == '.')
                left[i - 1] = 'L';
            else left[i-1] = d.charAt(i-1);
        }

        right[0] = d.charAt(0);
        for (int i = d.length() - 2; i >= 0; i--) {
            if (d.charAt(i) == 'R' && d.charAt(i+1) == '.')
                right[i + 1] = 'R';
            else right[i+1] = d.charAt(i+1);
        }

        for (int i = 0; i < left.length; i++) {
            if ((left[i] == 'L' && right[i] == 'R') || (left[i] == 'R' && right[i] == 'L') ||
                    ((left[i] == '.' && right[i] == '.'))) {
                left[i] = '.';
            } else if (left[i] == 'L' || right[i] == 'L') left[i] = 'L';
            else left[i] = 'R';
        }
        if (String.valueOf(left).equals(ne)) return d;
        else return process(String.valueOf(left));
    }

}

// 1.Maintain 2 arrays, left & right
// 2.left => modified array considering next domino falls on left
// 3.right => modified array considering previous domino falls on right
// 4.create new state based on left & right.
// 5.repeat the process until there is no change in the string.