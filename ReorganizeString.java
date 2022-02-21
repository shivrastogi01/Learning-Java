class ReorganizeString {
	public class Pair implements Comparable<Pair>{
		char ch;
		int freq;
		Pair(char ch, int freq){
			this.ch = ch;
			this.freq = freq;
		}
		
		public int compareTo(Pair o) {
			return this.freq - o.freq;
		}
	}
    public String reorganizeString(String s) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch : s.toCharArray())
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        for(Character ch : map.keySet())
        	pq.add(new Pair(ch, map.get(ch)));
        
        Pair block = pq.remove();
        block.freq -= 1;
        StringBuilder sb = new StringBuilder();
        sb.append(block.ch);
        
        while(pq.size() > 0) {
        	Pair temp = pq.remove();
        	sb.append(temp.ch);
        	if(block.freq > 0)
        		pq.add(block);
        	block = temp;
        	block.freq -= 1;
        }
        
        if(block.freq > 0)
        	return "";
        return sb.toString();
    }
}