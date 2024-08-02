import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H, map[][];
    static boolean[][][] visited;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[K + 1][H][W];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int horse = current[2];
            int act = current[3];

            if(r == H - 1 && c == W - 1) return act;

            for(int i = 0; i < 12; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
                if(map[nr][nc] == 1) continue;

                if(i > 7) { // 원숭이 움직임
                    if(visited[horse][nr][nc]) continue;
                    queue.offer(new int[] {nr, nc, horse, act + 1});
                    visited[horse][nr][nc] = true;
                } else { // 말 움직임
                    if(horse == K) continue;
                    if(visited[horse + 1][nr][nc]) continue;
                    queue.offer(new int[] {nr, nc, horse + 1, act + 1});
                    visited[horse + 1][nr][nc] = true;
                }
            }
        }

        return -1;
    }
}