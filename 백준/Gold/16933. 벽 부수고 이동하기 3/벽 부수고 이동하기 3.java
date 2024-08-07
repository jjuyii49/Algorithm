import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, map[][];
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 0; i < N; i++) {
            String input = br.readLine().trim();

            for(int j = 0; j < M; j++) {
                map[i + 1][j + 1] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[K + 1][N + 1][M + 1];

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, 1, 0, 1, 0});
        visited[0][1][1] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int wall = current[2];
            int count = current[3];
            int dayNight = current[4];

            if(r == N && c == M) return count;

            // 낮밤 변경 (0 : 낮, 1 : 밤)
            if(dayNight == 0) dayNight = 1;
            else dayNight = 0;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 1 || nc < 1 || nr >= N + 1 || nc >= M + 1) continue;

                // 벽이 아닌 경우
                if(map[nr][nc] == 0 && !visited[wall][nr][nc]) {
                    queue.offer(new int[] {nr, nc, wall, count + 1, dayNight});
                    visited[wall][nr][nc] = true;
                }

                // 벽인 경우
                if(map[nr][nc] == 1 && wall < K && !visited[wall + 1][nr][nc] && dayNight == 1) {
                    queue.offer(new int[] {nr, nc, wall + 1, count + 1, dayNight});
                    visited[wall + 1][nr][nc] = true;
                }
                else if(map[nr][nc] == 1 && wall < K && dayNight == 0) { // 이동하지 않는 경우
                    queue.offer(new int[] {r, c, wall, count + 1, dayNight});
                    visited[wall][r][c] = true;
                }
            }
        }

        return -1;
    }
}