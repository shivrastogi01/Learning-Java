class CountServerThatCommunicate {
public int countServers(int[][] grid) {
    
int [] rows= new int [grid.length];
int [] col= new int [grid[0].length];
int counter=0;
for (int i = 0; i < grid.length; i++)
for (int j = 0; j < grid[i].length; j++)
if (grid[i][j]==1) {
rows[i]++;
col[j]++;
    }
for (int i = 0; i < grid.length; i++)
for (int j = 0; j < grid[i].length; j++)
if (grid[i][j]==1 &&( rows[i]>=2 || col[j]>=2))
counter++;
return counter;

    }

}