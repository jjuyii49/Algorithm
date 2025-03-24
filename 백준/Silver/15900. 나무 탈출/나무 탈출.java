import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, total;
    static List<Integer>[] graph;
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

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        total = 0;
        for(int i = 1; i < N + 1; i++) {
            if(visited[i]) continue;

            for(int j : graph[i]) {
                if(!visited[j]) {
                    visited[i] = true;
                    dfs(j, 1);
                }
            }
        }

        System.out.println((total % 2 == 0)? "No" : "Yes");
    }

    static void dfs(int i, int count) {
        visited[i] = true;

        boolean isLeef = true;
        for(int j : graph[i]) {
            if(!visited[j]) {
                isLeef = false;
                dfs(j, count + 1);
            }
        }

        if(isLeef) total += count;
    }
}