class NumberOfBurgersWithZeroWaste {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> l = new ArrayList<>();
        if(cheeseSlices*2 == tomatoSlices)
        {
            l.add(0);
            l.add(cheeseSlices);
        }
        else if(cheeseSlices*4 == tomatoSlices)
        {
            l.add(cheeseSlices);
            l.add(0);
        }
        else if(tomatoSlices - cheeseSlices*2 == 2)
        {
            l.add(1);
            l.add(cheeseSlices-1);
        }
        else if(tomatoSlices - cheeseSlices*2 > 2 && (tomatoSlices - cheeseSlices*2)%2==0)
        {
            int diff = 0;
            int a = (tomatoSlices - cheeseSlices*2)/4;
            if(((tomatoSlices - cheeseSlices*2)%4)==2)
            {
                diff = 1;
            }
            if(a*2+diff > cheeseSlices)
            {
                return l;
            }
            l.add(a*2+diff);
            l.add(cheeseSlices-(a*2+diff));
        }
        return l;
    }
}