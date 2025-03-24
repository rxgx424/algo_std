import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] cave;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int[][] cost;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			cave = new int[N][N];
			cost = new int[N][N];
			cnt++;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
	        PriorityQueue<Rupee> pq = new PriorityQueue<>((r1,r2)->r1.size-r2.size);
			pq.add(new Rupee(0, 0, cave[0][0]));
			cost[0][0] = cave[0][0];
			
			while(!pq.isEmpty()) {
				Rupee rupee = pq.poll();
				
				if(cost[rupee.pos_y][rupee.pos_x]<rupee.size) {
					continue;
				}
				
				for (int d = 0; d < 4; d++) {
					int ny = rupee.pos_y + dy[d];
					int nx = rupee.pos_x + dx[d];
					
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) {
						continue;
					}
					//갱신
					if(cost[ny][nx] > rupee.size+cave[ny][nx]) {
						cost[ny][nx] = rupee.size+cave[ny][nx];
						pq.add(new Rupee(nx, ny, cost[ny][nx]));
					}
					
				}
				
			}
			System.out.println("Problem " + cnt + ": " + cost[N-1][N-1]);
		}
		
	}
	static class Rupee{
		int pos_x; // 위치
		int pos_y;
		int size; // 도둑루피 크기
		
		Rupee(int pos_x, int pos_y, int size){
			this.pos_x = pos_x;
			this.pos_y = pos_y;
			this.size = size;
		}
	}
}
