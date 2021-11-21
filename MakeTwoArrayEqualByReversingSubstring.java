 
 class MakeTwoArrayEqualByReversingSubstring
 {
 public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(target, arr);
    }
}