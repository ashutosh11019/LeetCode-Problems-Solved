class Solution {
    public int equalPairs(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[0][i] == grid[j][0]){
                    if(check(grid, i, j)){
                        c++;
                    }
                }
            }
        }
        return c;
    }
    
    public boolean check(int[][] grid, int col, int row){
        for(int i=0;i<grid.length;i++){
            if(grid[i][col] != grid[row][i]) return false;
        }
        return true;
    }
}