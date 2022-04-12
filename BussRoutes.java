class BussRoutes {
    public HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
    public HashMap<Integer, List<Integer>> stopToBus = new HashMap<>();
    public HashSet<Integer> targetBuses = new HashSet<>();
    public HashSet<Integer> visited = new HashSet<>();
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                if (!stopToBus.containsKey(stop))
                    stopToBus.put(stop, new ArrayList<>());
                stopToBus.get(stop).add(bus);
            }
        }
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                List<Integer> dests = stopToBus.get(stop);
                if (!g.containsKey(bus))
                    g.put(bus, new HashSet<>());
                g.get(bus).addAll(dests);
            }
        }
        targetBuses.addAll(stopToBus.getOrDefault(target, new ArrayList<>()));
        Queue<Integer> queue = new LinkedList<>();
        for (Integer bus : stopToBus.get(source)) {
            queue.add(bus);
            visited.add(bus);
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int k = queue.size();
            while (k-- > 0) {
                int u = queue.poll();
                if (targetBuses.contains(u))
                    return step;
                for (int v : g.getOrDefault(u, new HashSet<>())) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.add(v);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}