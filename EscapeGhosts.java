class EscapeGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        for (int[] g:ghosts) {
            if ((Math.abs(g[0]-target[0])+Math.abs(g[1]-target[1]))<=(Math.abs(target[0])+Math.abs(target[1]))) {
                return false;
            }
        }
        return true;
    }
}