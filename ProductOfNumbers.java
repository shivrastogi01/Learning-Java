class ProductOfNumbers {
    ArrayList<Integer> list;
    int product;
    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    public void add(int num) {
        list.add(num);
    }
    public int getProduct(int k) {
        product=1;
        for(int i=list.size()-k;i<list.size();i++){
            product*=(int)list.get(i);
        }
        return product;
    }
}