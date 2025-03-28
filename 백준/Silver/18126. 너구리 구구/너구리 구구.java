import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long max;
    static List<long[]>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        graph = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            graph[a].add(new long[] {b, c});
            graph[b].add(new long[] {a, c});
        }

        visited = new boolean[N + 1];
        max = 0;

        for(int i = 1; i < N + 1; i++) {
            if(visited[i]) continue;

            for(long[] node : graph[i]) {
                if(!visited[(int)node[0]]) {
                    visited[i] = true;
                    dfs((int)node[0], node[1]);
                }
            }
        }

        System.out.println(max);
    }

    private static void dfs(int i, long sum) {
        visited[i] = true;

        max = Math.max(max, sum);

        for(long[] node : graph[i]) {
            if(visited[(int)node[0]]) continue;

            dfs((int)node[0], sum + node[1]);
        }
    }
}