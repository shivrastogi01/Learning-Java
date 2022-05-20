class FruitInotBasket {
   public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> hashMap = new HashMap<>();
        int result=1;
        int start=0,currentBasket=0;
        for(int fruit : fruits){
            // add current fruit
            currentBasket++;
            hashMap.put(fruit,hashMap.getOrDefault(fruit,0)+1);
            // if we have more that 2 distinct fruits in our basket then keep on removing the
            // fruits from the begining of the window
            while(hashMap.size() > 2){
                currentBasket--;
                int fruitsValue = hashMap.getOrDefault(fruits[start],0) - 1;
                if(fruitsValue <= 0){
                    // remove the fruit once no. of fruits reaches 0
                    hashMap.remove(fruits[start]);
                }
                if(fruitsValue > 0){
                    hashMap.put(fruits[start],fruitsValue);
                }
                // increment the window
                start++;
            }  

            result = Math.max(currentBasket,result);
        }
        return result;
    }
}