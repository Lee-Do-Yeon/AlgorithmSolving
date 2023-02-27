import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 {
	
	static int computer;
	static int[][] connections;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// ��ǻ���� �� 
		computer = Integer.parseInt(bf.readLine());
		// ����Ǿ��� ��ǻ�� ���� ��
		int n = Integer.parseInt(bf.readLine());
		
		connections = new int[computer][computer];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken())-1;
			int from = Integer.parseInt(st.nextToken())-1;
			
			// �����
			connections[to][from] = 1;
			connections[from][to] = 1;
		}
		
		// =============== input ===============
		
		int cnt = bfs(0);
		
		System.out.println(cnt);
		

	}
	
	static int bfs(int start) {
        int cnt = 0;
		boolean[] visited = new boolean[computer];
		
		Queue<Integer> queue = new LinkedList<>();
		
		visited[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			// ������ ��� ť�� �߰�.
			for(int i=0; i<computer; i++) {
				if(connections[node][i] == 1 && !visited[i]) {
					visited[i] = true;
					cnt++;
					queue.add(i);
				}
			}
		}
		
		return cnt;
	}

}
