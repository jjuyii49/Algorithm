import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 int N = Integer.parseInt(br.readLine());
		 
		 int[] num = new int[N + 1];
		 for(int i = 1; i < N + 1; i++) {
			 num[i] = Integer.parseInt(br.readLine());
		 }
		 
		 int[] dp = new int[N + 1];
		 
		 dp[1] = num[1];

		 for(int i = 2; i < N + 1; i++) {
			 if(i == 2) dp[i] = num[1] + num[2];
			 else if(i == 3) dp[i] = Math.max(num[1], num[2]) + num[3];
			 else dp[i] = Math.max(dp[i - 3] + num[i - 1], dp[i - 2]) + num[i];
		 }
		 
		 System.out.println(dp[N]);
	}

}
