class WinnerOfCircularGame {
   public int findTheWinner(int n, int k) {
        List<Integer> list= new ArrayList();
        for( int i=1;i<=n;i++)
            list.add(i);
      int index=0;
       while(list.size()>1)
       {int size=list.size();
          index=index+k-1;
          if( index>=size)
              index=index%size;
         list.remove(list.get(index));
           
       }return list.get(0);
    }
}