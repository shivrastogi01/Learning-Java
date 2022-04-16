class CatAndMouse{
  int[][][] winners;
  
  final int MOUSE = 1, CAT = 2, NO_ONE = 0;
  final int HOLE = 0;
  final int[] TURNS = {MOUSE, CAT};
  
  public int catMouseGame(int[][] graph) {
    final int N = graph.length;
    int[][][] degress = buildDegree(graph, N);

    Queue<State> queue = new LinkedList<>();
    winners = new int[N][N][3];
    
    for(int i = 0; i < N; i++){
      for(int turn : TURNS){
        State mouseWin = new State(HOLE, i, turn, MOUSE);
        setWinner(mouseWin);
        queue.offer(mouseWin);
        if (i != HOLE) {
          State catWin = new State(i, i, turn, CAT);
          setWinner(catWin);
          queue.offer(catWin);
        }
      }
    }

    while(!queue.isEmpty()){
      State sub = queue.poll();

      for(State cur : parents(graph, sub)){
        if(getWinner(cur) == NO_ONE){
          if(cur.turn == sub.winner){
            cur.winner = sub.winner;
          }else if(--degress[cur.mouse][cur.cat][cur.turn] == 0){
            cur.winner = 3 - cur.turn;
          }
          if (cur.winner != NO_ONE) {
            setWinner(cur);
            queue.offer(cur);
          }
        }
      }
    }
    return winners[1][2][MOUSE];
  }

  private List<State> parents(int[][] graph, State sub) {
    List<State> parents = new LinkedList<>();
    if(sub.turn == CAT){
      for (int mouse : graph[sub.mouse]) {
        parents.add(new State(mouse, sub.cat, MOUSE, NO_ONE));
      }
    }else{
      for (int cat : graph[sub.cat]) {
        if (cat != HOLE) {
          parents.add(new State(sub.mouse, cat, CAT, NO_ONE));
        }
      }
    }
    return parents;
  }
  
  private int[][][] buildDegree(int[][] graph, int N){
    int[][][] degrees = new int[N][N][3];
    for(int m = 0; m < N; m++){
      for(int c = 0; c < N; c++){
        degrees[m][c][MOUSE] = graph[m].length;
        degrees[m][c][CAT] = graph[c].length;
      }
    }
    for(int c : graph[HOLE]){
      for(int m = 0; m < N; m++){
        degrees[m][c][CAT]--;
      }
    }
    return degrees;
  }

  private int getWinner(State state){
    return winners[state.mouse][state.cat][state.turn];
  }

  private void setWinner(State state){
     winners[state.mouse][state.cat][state.turn] = state.winner;
  }

  private static class State{
    int mouse;
    int cat;
    int turn;
    int winner;

    State(int mouse, int cat, int turn, int winner){
      this.mouse = mouse;
      this.cat = cat;
      this.turn = turn;
      this.winner = winner;
    }
  }
}