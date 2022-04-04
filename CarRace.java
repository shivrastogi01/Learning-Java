class CarRace{
   public int racecar(int target) {
    int ans = 0;
    Queue<List<Integer>> queue = new LinkedList<>(); // queue for [position, speed]
    Set<List<Integer>> visited = new HashSet<>();  // In a job interview I might not have enough time to spend on programming a proper Car state class. List serves our purpose well here.
    List<Integer> initState = List.of(0, 1);
    queue.add(initState);
    visited.add(initState);
    while (!queue.isEmpty()) {
        ans++;
        for (int size = queue.size(); size > 0; size--) {
            List<Integer> curr = queue.remove();
            int currPos = curr.get(0);
            int currSpeed = curr.get(1);
            // try "A"
            int newPos = currPos + currSpeed;
            if (newPos == target) return ans;
            if (Math.abs(newPos - target) < target) {
                List<Integer> newState = List.of(newPos, currSpeed * 2);
                if (visited.add(newState)) {
                    queue.add(newState);
                }
            }
            // try "R"
            List<Integer> newState = List.of(currPos, (currSpeed > 0) ? -1 : 1);
            if (visited.add(newState)) {
                queue.add(newState);
            }
        }
    }
    return -1;  // It is impossible for code to reach here.
}
}