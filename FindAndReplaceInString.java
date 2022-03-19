class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int i = 0, len = s.length();
        StringBuilder sb = new StringBuilder();
        Map<Integer, Pair<String, String>> map = new HashMap<>();
        
        for (int j = 0; j < indices.length; ++ j) {
            map.put(indices[j], new Pair<>(sources[j],targets[j]));
        }
        
        while (i < len) {
            if (!map.containsKey(i)) {
                sb.append(s.charAt(i));
                ++ i;
            } else {
                boolean canReplace = true;
                String source = map.get(i).getKey();
                String target = map.get(i).getValue();
                for (int p = 0; i + p < len && p < source.length(); ++ p) {
                    if (s.charAt(i + p) != source.charAt(p)) {
                        canReplace = false;
                        break;
                    }
                }
                
                if (canReplace) {
                    sb.append(target);
                    i = i + source.length();
                } else {
                    sb.append(s.charAt(i));
                    ++ i;
                }
            }
        }
        
        return sb.toString();
    }
}