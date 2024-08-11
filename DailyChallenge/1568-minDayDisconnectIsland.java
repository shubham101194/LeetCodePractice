class Solution {
    public void dfs(int[][] grid, int r, int c, boolean[][] visited, int n, int m) {
        visited[r][c] = true;
        
        if(r+1<n && !visited[r+1][c] && grid[r+1][c]==1)
            dfs(grid,r+1,c,visited,n,m);
        if(r-1>=0 && !visited[r-1][c] && grid[r-1][c]==1)
            dfs(grid,r-1,c,visited,n,m);
        if(c+1<m && !visited[r][c+1] && grid[r][c+1]==1)
            dfs(grid,r,c+1,visited,n,m);
        if(c-1>=0 && !visited[r][c-1] && grid[r][c-1]==1)
            dfs(grid,r,c-1,visited,n,m);
    }
    
    public int numberOfIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && grid[i][j]==1) {
                    dfs(grid,i,j,visited,n,m);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int num = numberOfIslands(grid);
        
        if(num != 1)
            return 0;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 0)
                    continue;
                
                grid[i][j] = 0;
                if(numberOfIslands(grid) != 1)
                    return 1;
                grid[i][j] = 1;
            }
        }
        
        return 2;
    }
}