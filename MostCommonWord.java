class MostCommonWord {
public String mostCommonWord(String paragraph, String[] banned) {

	// Split the words
	  String[] paraSplit = paragraph.toLowerCase().split("\\W+");
	  
    // Convert Arrays to List
       List<String> bannedList = Arrays.asList(banned);
       
     // Initialize Map
       Map<String, Integer> strMap = new HashMap<String, Integer>();
    		        
       
        // Creating the Map with Keys and Values
        for(String s: paraSplit){
             int ct =1;
             if(!bannedList.contains(s)){
                if(strMap.keySet().contains(s)){
                   ct = strMap.get(s);
                   ct += 1;
                    strMap.put(s,ct);
                }else{
                    strMap.put(s,ct);
                }
             }   
        }
        
        //Sorting the Map with values occurances
        Map<String, Integer> sortedMap = 
	    		   strMap.entrySet().stream()
	    		    .sorted(Entry.comparingByValue())
	    		    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
	    		                              (e1, e2) -> e1, LinkedHashMap::new));
        
       
       String lastKey="";
       Integer lastVal=0;
       
       for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
    	   lastKey = entry.getKey();
    	   lastVal = entry.getValue();
        }
	return lastKey;


}
}