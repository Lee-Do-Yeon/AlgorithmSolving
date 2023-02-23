import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
	
	static int [][] map;
	static boolean [][] visited;
	static int M, N, K;
	static int cnt = 0;
	static int[] di = { 0,0,-1,1 };
	static int[] dj = { -1,1,0,0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}
			
			// ======= input =======
			int ans = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] == false && map[i][j] == 1) {
						dfs(i,j);
						if(cnt != 0) {
							ans++;
							cnt = 0;
						}
					}
				}
			}
			
			System.out.println(ans);
		}
		

	}
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		cnt++;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M) {
				if(map[ni][nj] == 1 && visited[ni][nj] == false) {
					dfs(ni, nj);
				}
			}
		}
	}

}
