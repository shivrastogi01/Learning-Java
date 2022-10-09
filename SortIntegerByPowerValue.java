class SortIntegerByPowerValue{
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> powers = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            int x = i;
            int pow = 0;
            while (x > 1) {
                if (powers.containsKey(x)) {
                    pow += powers.get(x);
                    break;
                }
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = 3 * x + 1;
                }
                pow++;
            }
            if (!powers.containsKey(i)) {
                powers.put(i, pow);
            }
            list.add(new Pair(i, pow));
        }
        Collections.sort(list, Comparator.comparing(Pair::getPow).thenComparing(Pair::getNum));
        return list.get(k - 1).getNum();
    }

    class Pair {
        int num;
        int pow;

        public Pair(int num, int pow) {
            this.num = num;
            this.pow = pow;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getPow() {
            return pow;
        }

        public void setPow(int pow) {
            this.pow = pow;
        }
    }
}