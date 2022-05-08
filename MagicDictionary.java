class MagicDictionary {
	String[] dictionary;

	boolean OneCharDifferent(String start, String end) {
		if (start.length() != end.length()) {
			return false;
		}
		int differrent = 0;
		for (int i = 0; i < start.length() && differrent  <= 1; ++i) {
			if(start.charAt(i) != end.charAt(i)){
				differrent += 1;
			}
		}   
		return differrent == 1;
	}
	public MagicDictionary() {

	}

	public void buildDict(String[] dictionary) {
		this.dictionary = dictionary;
	}

	public boolean search(String searchWord) {
		for(String s : dictionary){
			if(OneCharDifferent(s,searchWord))
				return true;
		}
		return false;
	}
}