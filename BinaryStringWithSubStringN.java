class BinaryStringWithSubStringN {
     public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; ++i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}