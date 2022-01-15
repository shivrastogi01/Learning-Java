class FlightBooking {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // a difference array to add seats to a range of flights in O(1) time
        int[] diffArr = new int[n];
        // an integer array to save seats info for each flight
        int[] flight = new int[n];
        
        // iterate through bookings and add seats to ranges in diffArr
        for (int[] booking : bookings) {
            int start = booking[0] - 1, end = booking[1] - 1, numOfSeats = booking[2];
            
            diffArr[start] += numOfSeats;
            if (end + 1 < n) diffArr[end + 1] -= numOfSeats;
        }
        
        flight[0] = diffArr[0];
        
        for (int i = 1; i < flight.length; i++) {
            flight[i] = flight[i-1] + diffArr[i]; 
        }
        
        return flight;
        
    }
}