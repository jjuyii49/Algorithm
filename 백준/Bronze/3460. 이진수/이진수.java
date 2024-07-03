import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine().trim());

            int count = 0;
            for(int j = 1; j < n; j *= 2) {
                count++;
            }

            for(int j = 0; j <= count; j++) {
                if((n & (1 << j)) > 0) sb.append(j).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}