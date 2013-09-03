public class SpiralMatrixII {
    int[][] dir;
    public SpiralMatrixII(){
        dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    }
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) return new int[0][0];
        int[][] answer = new int[n][n];
        boolean[][] walked = new boolean[n][n];
        for(int x = 0, y = 0, k = 0, d = 0, num = 1; k <= 4; ){
            if(x < 0 || x >= n || y < 0 || y >= n || walked[x][y]){
                x -= dir[d][0];
                y -= dir[d][1];
                d = (d + 1) % 4;
                k++;
            }else
            {
                walked[x][y] = true;
                answer[x][y] = num++;
                k = 0;
            }
            x += dir[d][0];
            y += dir[d][1];          
        } 
        return answer;
        
    }
}
