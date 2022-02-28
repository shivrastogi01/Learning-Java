class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>(); 
        boolean commented = false; 
        StringBuilder sb = new StringBuilder(); 
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (commented) {
                    if (line.charAt(i) == '*' && i < line.length()-1&& line.charAt(i+1) == '/') {
                        commented = false; 
                        i++; 
                    }
                }
                else {
                    if (line.charAt(i) == '/' && i < line.length()-1&& line.charAt(i+1) == '*') {
                        commented = true; 
                        i++; 
                    }
                    else if (line.charAt(i) == '/' && i < line.length()-1&& line.charAt(i+1) == '/') {
                        break;
                    }
                    else {
                        sb.append(line.charAt(i));
                    }
                }
            }
            if (!commented && sb.length() != 0) {
                res.add(sb.toString());
                sb = new StringBuilder(); 
            }
        }
        return res; 
    }
}