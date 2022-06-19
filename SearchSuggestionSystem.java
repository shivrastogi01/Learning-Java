class SearchSuggestionSystem{
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> ans=new ArrayList<>();
            Arrays.sort(products);
            String str="";
            for(int i=0; i<searchWord.length(); i++){
                str+=searchWord.charAt(i);
                List<String> arr=new ArrayList<>();
                for(String j : products){
                    if(j.indexOf(str)==0){
                        arr.add(j); 
                        if(arr.size()==3){ break; }
                    }
                }
                ans.add(arr);
            }
            return ans;
    }
}