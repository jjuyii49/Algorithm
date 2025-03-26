import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] degree = new int[N + 1];

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            degree[a]++;
            degree[b]++;
        }

        int Q = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine().trim());

            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 단절점
            if(t == 1) {
                sb.append(degree[k] >= 2 ? "yes" : "no").append("\n");
            } else {    // 단절선
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);
    }
}