class FrogJump {
    public boolean solve(int[] stones, int index, int jump, Map<Integer, Integer> map, Map<String, Boolean> dp) {
        if (index == stones.length - 1) {
            return true;
        }
        if (dp.containsKey(index + "" + jump))
            return dp.get(index + "" + jump);
        boolean result = false;
        if (index < stones.length && (jump - 1) >= 1 && map.containsKey(stones[index] + (jump - 1)))
            result |= solve(stones, map.get(stones[index] + (jump - 1)), jump - 1, map, dp);
        if (index < stones.length && jump >= 1 && map.containsKey(stones[index] + jump))
            result |= solve(stones, map.get(stones[index] + jump), jump, map, dp);
        if (index < stones.length && (jump + 1) < stones.length && map.containsKey(stones[index] + (jump + 1)))
            result |= solve(stones, map.get(stones[index] + (jump + 1)), jump + 1, map, dp);
        dp.put(index + "" + jump, result);
        return result;
    }
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return solve(stones, 0, 0, map, new HashMap<>());
    }
}