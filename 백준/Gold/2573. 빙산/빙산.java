import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][];
    static boolean[][] visited, countVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        boolean isSuccess = false;
        while(true) {
            time++;
            visited = new boolean[N][M];

            int count = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        count = melt(i, j);
                    }
                }
            }

            if(count >= 2) {
                isSuccess = true;
                break;
            }
            else if(count == 0) break;
        }

        System.out.println(isSuccess? time : 0);
    }

    static int melt(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});

        int[][] newMap = new int[N][M];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int zero = 0;

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (map[nr][nc] == 0) {
                    zero++;
                    continue;
                }
                if (visited[nr][nc]) continue;

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }

            int newIce = map[current[0]][current[1]] - zero;
            newMap[current[0]][current[1]] = Math.max(newIce, 0);
        }

        countVisited = new boolean[N][M];
        int count = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (newMap[i][j] != 0 && !countVisited[i][j]) {
                    bfs(i, j, newMap);
                    count++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(newMap[i], M);
        }

        return count;
    }

    static void bfs(int r, int c, int[][] meltMap) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        countVisited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(meltMap[nr][nc] == 0 || countVisited[nr][nc]) continue;

                queue.offer(new int[] {nr, nc});
                countVisited[nr][nc] = true;
            }
        }
    }
}