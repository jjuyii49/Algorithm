import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, K, map[][], max;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        max = Integer.MIN_VALUE;

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < M + 1; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i, j);

                    if(max < count) max = count;
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            count++;

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 1 || nr >= N + 1 || nc < 1 || nc >= M + 1) continue;

                if(visited[nr][nc]) continue;

                if(map[nr][nc] != 1) continue;

                queue.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }

        return count;
    }
}