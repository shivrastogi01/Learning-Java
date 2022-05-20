class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        String[] sa = expression.split("(?=\\+)|(?=\\-)");
        int nu = 0;
        int dn = 0;
        for (int i=0;i<sa.length;i++) {
            String[] sa2 = sa[i].split("/");
            int nu1 = Integer.valueOf(sa2[0]);
            int dn1 = Integer.valueOf(sa2[1]);
            if (nu==0) {
                nu = nu1;
                dn = dn1;
            } else {
                int dn2 = dn1*dn;
                int nu2 = dn1*nu+nu1*dn;
                nu = nu2;
                dn = dn2;
            }
            if (nu==0) {
                dn = 1;
            } else {
                int g = gcd(nu, dn);
                if (g!=1) {
                    nu = nu/g;
                    dn = dn/g;
                }
                if (dn<0) {
                    nu = -nu;
                    dn = -dn;
                }
            }
        }
        return ""+nu+"/"+dn;
    }
    public int gcd(int n1, int n2) {
        if (n2==0) {
            return n1;
        }
        return gcd(n2, n1%n2);
    }
}