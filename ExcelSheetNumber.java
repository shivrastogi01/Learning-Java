class ExcelSheetNumber {
	public static void main(String[] args){
		String s= "BA";
		System.out.println(titleToNumber(s));
	}
  public static int titleToNumber(String s) {
		int val=0;
		for(int i=0; i<s.length();i++) {
			val = (val)*26;
			for(char j = 'A'; j<='Z';j++) {
				val++;
				if( j==s.charAt(i) ) break;
			}
		}
        
        return val;
    }
}