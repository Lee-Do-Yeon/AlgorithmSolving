import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// ========== input ==========
		BigInteger result = comb(n, r);
		
		System.out.println(result);
	}
	
	// а╤гу
	static BigInteger comb(int n, int r) {
		BigInteger[][] pascal = new BigInteger[n + 1][n + 1];
        
        // (1) nC0 = nCn = 1
        for (int i = 0; i <= n; i++) {
            pascal[i][0] = new BigInteger("1");
            pascal[i][i] = new BigInteger("1");
        }
        
        // (2) nCr = n-1Cr + n-1Cr-1
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                pascal[i][j] = pascal[i - 1][j - 1].add(pascal[i - 1][j]);
            }
        }
        return pascal[n][r];
	}

}
