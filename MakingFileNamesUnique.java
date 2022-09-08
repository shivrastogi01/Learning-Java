class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<names.length; i++) {
            String current = names[i];
            while (map.containsKey(current)) {
                int count = map.get(names[i]);
                count += 1;
                map.put(names[i], count);
                StringBuilder sb = new StringBuilder();
                sb.append(names[i]);
                sb.append("(");
                sb.append(count);
                sb.append(")");
                current = sb.toString();
            }
            map.put(current, 0);
            names[i] = current;
        }
        return names;
    }
}