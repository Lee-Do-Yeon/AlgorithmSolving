import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1388 {
	
	static char[][] map;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];

		for(int i=0; i<N; i++) {
			String input = bf.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		// ======= input =======
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] == false) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		
		if(map[i][j]=='-') {
			int nj = j + 1;
			if(nj<M) {
				if(map[i][nj] == '-') {
					dfs(i, nj);
				}
			}
		}else {
			int ni = i + 1;
			if(ni<N) {
				if(map[ni][j] == '|') {
					dfs(ni, j);
				}
			}
		}
		
	}

}
