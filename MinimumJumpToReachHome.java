class MinimumJumpToReachHome{
    int val;
    int direction;
    Position(int val, int direction){
        this.val = val;
        this.direction = direction;
    }
    @Override
    public String toString(){
        return this.val+"#"+this.direction;
    }
}
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0)
            return 0;
        Set<Integer> forbiddenSet = new HashSet();
        Set<String> visited = new HashSet();
        for (int n: forbidden)
            forbiddenSet.add(n);
        Queue<Position> queue = new LinkedList();
        queue.offer(new Position(0,0));
        visited.add(0+"#"+0);
        int result = 0;
        int max = 10000;
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            while(size-->0){
                Position curr = queue.poll();
                int next_a = curr.val + a;
                if (next_a == x)
                    return result;
                if (next_a >= 0 && next_a < max && !forbiddenSet.contains(next_a) && visited.add(next_a+"#"+1))
                    queue.add(new Position(next_a, 1));
                if (curr.direction == 1){
                    int next_b = curr.val - b;
                    if (next_b == x)
                        return result;
                     if (next_b >= 0 && next_b < max && !forbiddenSet.contains(next_b) && visited.add(next_b+"#"+0))
                    queue.add(new Position(next_b, 0));
                    
                }
            }
        }
        return -1;
    }
}