class NumberComplement {
public int findComplement(int n) {
StringBuilder nm=new StringBuilder(Integer.toBinaryString(n));
StringBuilder kk=new StringBuilder();
int k=nm.length();
for(int i=0;i<k;i++)
{
if(nm.charAt(i)=='1')
kk.append('0');
else
kk.append('1');
}
return Integer.parseInt(kk.toString(),2);
}
}