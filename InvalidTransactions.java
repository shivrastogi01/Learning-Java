class InvalidTransactions {
    public List<String> invalidTransactions(final String[] transactions) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String, List<Transaction>> map = new HashMap<>();

        // populate map with all the transactions against one name
        for(String tran : transactions) {
            Transaction t = new Transaction(tran);

            if(map.containsKey(t.name)) {
                map.get(t.name).add(t);
            } else {
                map.put(t.name, new ArrayList<>());
                map.get(t.name).add(t);
            }
        }

        // check validity and add to res
        for(String trans : transactions) {
            Transaction currentTrans = new Transaction(trans);
            if(!isValid(map.get(currentTrans.name), currentTrans)) { // if trans is not valid then add the STRING trans to res
                res.add(trans);
            }
        }

        return res;
    }    
    
    private boolean isValid(List<Transaction> transaction, Transaction currentTrans) {
        if(transaction.size() <= 1 && currentTrans.amount <= 1000) {
            return true;
        }
        
        for(Transaction tran : transaction) {
            if(currentTrans.isInvalidTrans(tran.city, tran.time)) { // call isInvalidTrans() for currentTrans obj and pass the trans for the 'name' one by one. Basically 'currentTrans' transaction would we checked against all the transaction in the list (including itself) so O(N^2)
                return false;
            }
        }
        return true;
    }
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;
    
    public Transaction(String transaction) {
        String[] trans = transaction.split(",");
        this.name = trans[0];
        this.time = Integer.parseInt(trans[1]);
        this.amount = Integer.parseInt(trans[2]);
        this.city = trans[3];
    }
    
    public boolean isInvalidTrans(String transCity, int transTime) { // any true condition will tell that trans is invalid
        return isInvalidAmount() || isDifferentCity(transCity, transTime);
    }
    
    private boolean isInvalidAmount() {
        return this.amount > 1000; // 'this' means we are checking for 'currentTrans' obj above through which the isInvalid() is called
    }
    
    // 'this' means we are checking for 'currentTrans' obj above through which the isInvalid() is called
    // Here, we also compare the same trans(once) with itself (since we compare all the trans for one name)
    // My logic handles the above thing as well. For same trans our first condition will return !(true) = false && second condition(0) will return true so isDifferentCity() would return 'false' and hence it will not be added to the returning list above
    private boolean isDifferentCity(String transCity, int transTime) {
        return !this.city.equals(transCity) && Math.abs(this.time - transTime) <= 60;
    }
}