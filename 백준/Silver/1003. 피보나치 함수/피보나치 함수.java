import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < T; i++) {
            int[][] dp = new int[41][2];

            dp[0] = new int[]{1, 0};
            dp[1] = new int[]{0, 1};

            int num = Integer.parseInt(br.readLine().trim());
            for(int j = 2; j <= num; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }

            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.println(sb);
    }
}