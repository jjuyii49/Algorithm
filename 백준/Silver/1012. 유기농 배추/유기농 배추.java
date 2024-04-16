import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Backjoon 1012. 유기농 배추
 *
 * 상하좌우 인접한 배추 찾기
 */
public class Main {

    private static BufferedReader br;
    private static int m, n, map[][], visited[][];
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());


        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = initialize(m, n, k);

            visited = new int[n][m];

            int num = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 1 && visited[i][j] == 0) {
                        visited[i][j] = num++;
                        dfs(i, j, num);
                    }
                }
            }

            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] initialize(int m, int n, int k) throws IOException {
        int[][] map = new int[n][m];

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        return map;
    }

    private static void dfs(int r, int c, int num) {
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            if(visited[nr][nc] != 0) continue;

            if(map[nr][nc] == 1) {
                visited[nr][nc] = num;
                dfs(nr, nc, num);
            }
        }
    }
}