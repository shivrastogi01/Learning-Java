class ReconstructItinerary {
   public List<String> findItinerary(List<List<String>> tickets) { 
    Map<String,List<String>>map = new HashMap();
    List<String> result = new ArrayList();
    //Using stack to keep the track incase if lexicaly small elem leads to dead end
    //but we still have a path to reach dest          A  
    Stack<String> stack = new Stack();          //   /   \ \
                                               //   B    C
    stack.push("JFK");
    
    for(int i = 0; i < tickets.size(); i++)  {
        
       List arr = new ArrayList<String>();
       String fromCity =  tickets.get(i).get(0);
       String toCity   =  tickets.get(i).get(1); 
        
       if(map.containsKey(fromCity))
        {  
            arr = map.get(fromCity);
            arr.add(toCity);
            Collections.sort(arr);
            map.put(fromCity,arr);
           
        } else {
           
            arr.add(toCity);
            Collections.sort(arr);
            map.put(fromCity,arr);
        }
    }
    
    while(!stack.isEmpty()) {
        
        String city = stack.peek();
        List routes = map.get(city);
     
        if(routes == null || routes.size() == 0) {
            
            result.add(city);
            stack.pop();
            
         } else {
           
             String temp = routes.get(0).toString();
             stack.push(routes.get(0).toString());
             routes.remove(temp);
            
            }                 
    }
     
    Collections.reverse(result);
    
    return result;
}
}