 class DecodeString{
 public static String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ']') {
        StringBuilder v = new StringBuilder();
        while (sb.charAt(sb.length() - 1) != '[') {
          v.insert(0, sb.charAt(sb.length() - 1));
          sb.deleteCharAt(sb.length() - 1);
        }
        sb.deleteCharAt(sb.length() - 1); // delete '['
        StringBuilder repeat = new StringBuilder();
        // Notice condition: sb.length()!=0 &
        while ( sb.length()!=0 && '0' <= sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 1) <= '9') {
          repeat.insert(0, sb.charAt(sb.length() - 1));
          sb.deleteCharAt(sb.length() - 1);
        }
        int n = Integer.valueOf(repeat.toString());
        while (n-- >= 1) sb.append(v.toString());
      } else sb.append(s.charAt(i));
    }
    return sb.toString();
  }}