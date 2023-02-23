import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_2667 {
	
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int cnt = 0;
	
	// 상하좌우
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String input = bf.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}

		visited = new boolean[n][n];
		List<Integer> apt = new ArrayList<>();
		// ====== input ======
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != 0 && visited[i][j] == false) {
					dfs(i, j);
					apt.add(cnt);
					cnt = 0;
				}
			}
		}
		
        apt.sort(Comparator.naturalOrder());
        System.out.println(apt.size());

        for(int i=0; i<apt.size(); i++){
        	if(apt.get(i) != 0) {
        		System.out.println(apt.get(i));
        	}
        }
		
	}
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		cnt++;
		
		// 상하좌우
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			// (1) 범위 체크
			if(ni >= 0 && nj >= 0 && ni < n && nj < n) {
				// (2) 방문 & 조건 체크
				if(map[ni][nj] != 0 && visited[ni][nj] == false) {
					dfs(ni, nj);
				}
			}
		}
	}

}
