class EqualRationalNumber {
  
  public boolean isRationalEqual(String s, String t) {
    Fraction f1 = Rational.parse(s).toFraction();
    Fraction f2 = Rational.parse(t).toFraction();
    return f1.p * f2.q == f2.p * f1.q;
  }
  
  private static class Rational {
    private final String integer, nonRepeating, repeating;
    
    private Rational(String integer, String nonRepeating, String repeating) {
      this.integer = integer;
      this.nonRepeating = nonRepeating;
      this.repeating = repeating;
    }
    
    public static Rational parse(String s) {
      // HACK: quick and dirty parsing assuming inputs are always valid
      // this usually needs more thorough validation
      String[] parts = s.split("[.()]");
      return new Rational(
        parts.length >= 1 ? parts[0] : "",
        parts.length >= 2 ? parts[1] : "",
        parts.length >= 3 ? parts[2] : ""
      );
    }
    
    public Fraction toFraction() {
      long a = tenpow(nonRepeating.length());
      long i = Long.parseLong(integer + nonRepeating); // = a * number
      if (repeating.length() == 0) {
        return new Fraction(i, a);
      }
      else {
        long b = tenpow(nonRepeating.length() + repeating.length());
        long j = Long.parseLong(integer + nonRepeating + repeating); // = b * number
        return new Fraction(j - i, b - a);
      }
    }
    
    public String toString() {
      return String.format("%s.%s(%s)", integer, nonRepeating, repeating);
    }
  }
  
  // represents p/q
  private static class Fraction {
    private final long p, q;
    
    private Fraction(long p, long q) {
      this.p = p;
      this.q = q;
    }
    
    public String toString() {
      return String.format("%d/%d", p, q);
    }
  }
  
  // 10^x
  private static long tenpow(int x) {
    assert x >= 0;
    long r = 1;
    while (--x >= 0) {
      r *= 10;
    }
    return r;
  }  
}