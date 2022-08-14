class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] mat = new int[n-2][n-2];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                mat[i][j] = maximum(grid, i+1, j+1, n);
            }
        }
        return mat;
    }
    
    public static int maximum(int[][] grid, int x, int y, int n){
        int max = Integer.MIN_VALUE;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 && j>=0 && i<n && j<n){
                    if(max<grid[i][j]) max=grid[i][j];
                }
            }
        }
        return max;
    }
}