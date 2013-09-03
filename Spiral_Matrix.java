import java.util.*;

public class SpiralMatrix {
    int[][] dir;
    public SpiralMatrix(){
        dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    }
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> answer = new ArrayList<Integer>(128);
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return answer;
        int d = 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] walked = new boolean[m][n];
        for(int x = 0, y = 0, k = 0; k <= 4; ){
            if(x < 0 || x >= m || y < 0 || y >= n || walked[x][y]){
                x -= dir[d][0];
                y -= dir[d][1];
                d = (d + 1) % 4;
                k++;
            }else
            {
                walked[x][y] = true;
                answer.add(matrix[x][y]);
                k = 0;
            }
            x += dir[d][0];
            y += dir[d][1];          
        }
        return answer;
    }
}
