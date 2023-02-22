import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_16395 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// ========== input ==========
		int result = comb(n-1, r-1);
		
		System.out.println(result);
	}
	
	// а╤гу
	static int comb(int n, int r) {
		int[][] pascal = new int[n + 1][n + 1];
        
        for (int i = 0; i <= n; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        return pascal[n][r];
	}

}
