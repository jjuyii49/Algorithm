import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine().trim());

            int result = dfs(num);

            if(result == 0) visited[num] = true;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int dfs(int i) {
        List<Integer> path = new ArrayList<>();
        int cur = i;
        while(cur > 0) {
            path.add(cur);
            cur /= 2;
        }
        Collections.reverse(path);

        for(int node : path) {
            if(visited[node]) return node;
        }

        return 0;
    }
}