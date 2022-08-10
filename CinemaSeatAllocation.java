class CinemaSeatAllocation {

	// Time Complexity, Space Complexity = O(M), M=reservedSeats.length
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //Max seatings
        int countSeatings=2*n;
        
        HashMap<Integer, Integer> rowAvailability = new HashMap<>();
        
        for(int i=0; i<reservedSeats.length; i++){
            int row=reservedSeats[i][0]-1; 
            int col=reservedSeats[i][1];
            
			// 0 => 000 => All three arrangements are available
			//rowVal stores existing seating arrangements available
            int rowVal = rowAvailability.getOrDefault(row, 0);
            
            if(col==1 || col==10) continue;  //Dont impact any of the seating arrangements
            else if(col==2 || col==3 ) rowVal= rowVal | 4;  //rowVal | 100 as 2/3 affect the first type of seat in the row
            else if(col==4 || col==5 ) rowVal= rowVal | 6;
            else if(col==6 || col==7 ) rowVal= rowVal | 3;
            else rowVal= rowVal | 1;
            
            rowAvailability.put(row, rowVal); //updates the val
        }
                    
		//Since we have final row availabilities, scan to subtract unavailable spots
        for(int x: rowAvailability.keySet()){                
            switch(rowAvailability.get(x)){
                case 7: countSeatings-=2;  //111 => all three are occupied, no seating available
                case 0:                    //Same as next case
                case 2: continue; //010 / 000 =>can seat at 2 spots
                default: countSeatings--;  //=> all other cases can allow only 1 seating
                    
            }
        }           
            
        return countSeatings;
    }
    
}