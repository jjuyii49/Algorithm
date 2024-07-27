import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][], visited[][][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[2][N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine().trim();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);

        System.out.println(result);
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c, 0});
        visited[0][r][c] = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == N - 1 && current[1] == M - 1) return visited[current[2]][current[0]][current[1]];

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(map[nr][nc] == 1 && current[2] == 0 && visited[1][nr][nc] == 0) {
                    queue.offer(new int[] {nr, nc, 1});
                    visited[1][nr][nc] = visited[current[2]][current[0]][current[1]] + 1;
                }

                if(map[nr][nc] == 0 && visited[current[2]][nr][nc] == 0) {
                    queue.offer(new int[]{nr, nc, current[2]});
                    visited[current[2]][nr][nc] = visited[current[2]][current[0]][current[1]] + 1;
                }

            }
        }

        return -1;
    }
}