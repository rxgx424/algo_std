import java.util.*;
import java.io.*;
class Solution {
    static int[][] board;
    static boolean[][] visit;
    static int row;
    static int col;
    static int[] dx = {1, 0, -1, 0}; // 동, 남, 서, 북
    static int[] dy = {0, 1, 0, -1}; // 동, 남, 서, 북
    public int solution(int[][] maps) {
        
        row = maps.length;
        col = maps[0].length;
        board = new int[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0;i < row; i++){
            for(int j = 0;j < col; j++){
                board[i][j] = maps[i][j];
            }
        }
        
        return func(0, 0);
    }
    public int func(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 1});
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            int cnt = now[2];
            
            if(nx == row - 1 && ny == col - 1){
                return cnt;
            }
            
            for(int i = 0; i < 4; i++){

                int r = nx + dx[i];
                int c = ny + dy[i];

                if(r < 0 || c < 0 || r >= row || c >= col ) 
                    continue;
                
                if( board[r][c] == 1 && !visit[r][c]){
                    visit[r][c] = true;
                    q.add(new int[]{r, c, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}