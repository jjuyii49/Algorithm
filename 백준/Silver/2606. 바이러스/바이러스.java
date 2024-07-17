import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, map[][], count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());

        map = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = map[c][r] = 1;
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        count = 0;

        bfs(1);

        System.out.println(count);
    }

    static void bfs(int num) {
        for(int i = 0; i < n + 1; i++) {
            if(map[num][i] == 1 && !visited[i]) {
                visited[i] = true;
                count++;
                bfs(i);
            }
        }
    }
}