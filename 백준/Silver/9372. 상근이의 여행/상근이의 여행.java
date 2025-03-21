import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new int[N + 1][N + 1];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine().trim());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a][b] = 1;
                graph[b][a] = 1;
            }

            answer = 0;
            
            visited = new boolean[N + 1];
            for(int i = 1; i < N + 1; i++) {
                if(visited[i]) continue;
                visited[i] = true;

                for(int j = 1; j < N + 1; j++) {
                    if(graph[i][j] == 1 && !visited[j]) {
                        answer++;
                        dfs(j);
                    }
                }
            }

            System.out.println(answer);

        }
    }

    static void dfs(int index) {
        visited[index] = true;
        for(int j = 1; j < N + 1; j++) {
            if(graph[index][j] == 1 && !visited[j]) {
                answer++;
                dfs(j);
            }
        }
    }
}