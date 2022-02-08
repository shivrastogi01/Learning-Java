class CarFleet {
    public int carFleet(int target, int[] pos, int[] speed) {
      
       // put the elements according to the position
        TreeMap<Integer,Integer> tm=new TreeMap<>();
		for (int i = 0; i < pos.length; ++i) { tm.put(pos[i], speed[i]); }
		
		// putted all the time elements in the arryay
		  ArrayList<Double> al=new ArrayList<>();
		for(int po : tm.keySet()) { 
            double time = (double)(target - po) / tm.get(po);
            al.add(time);
		}
        
        Stack<Double> st=new Stack<>();
        double timearr[]=new double[al.size()];
        for(int i=0;i<timearr.length;i++)
        {
            timearr[i]=al.get(i);
        }
		// for time
        for(int i=0;i<timearr.length;i++)
        {
            while(!st.isEmpty() && timearr[i]>=st.peek())
                st.pop();
            
            st.push(timearr[i]);
        }
        return st.size();
        
        
    }
}