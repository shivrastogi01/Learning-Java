class ShiftingLetters {
public String shiftingLetters(String s, int[] shifts) {
StringBuilder sb = new StringBuilder();
sb.append(s);
char oldch;
char newch;
int newint;
int sum = 0;
for(int j = shifts.length - 1; j >= 0; j--){
sum += shifts[j];
sum=sum%26;
oldch = sb.charAt(j);
newint =(int) (((oldch - 97 ) + sum) % 26) + 97;
newch=(char)newint;
sb.setCharAt(j, newch);
}
return sb.toString();

}
}