import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h, visited[][];
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> fireQueue, sQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visited = new int[h][w];

            fireQueue = new ArrayDeque<>();
            sQueue = new ArrayDeque<>();

            for(int i = 0; i < h; i++) {
                String input = br.readLine().trim();
                for(int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);

                    if(map[i][j] == '*') fireQueue.offer(new int[] {i, j});
                    else if(map[i][j] == '@') {
                        sQueue.offer(new int[] {i, j});
                        visited[i][j] = 1;
                    }
                }
            }

            int result = bfs();
            sb.append(result > 0? result:"IMPOSSIBLE").append("\n");
        }

        System.out.println(sb);
    }

    static int bfs() {
        while(true) {
            int fireSize = fireQueue.size();
            while (fireSize-- > 0) {
                int[] fire = fireQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = fire[0] + dr[i];
                    int nc = fire[1] + dc[i];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                    if (map[nr][nc] == '#' || map[nr][nc] == '*') continue;

                    map[nr][nc] = '*';
                    fireQueue.offer(new int[]{nr, nc});
                }
            }

            int sSize = sQueue.size();
            while (sSize-- > 0) {
                int[] current = sQueue.poll();

                if (current[0] == 0 || current[1] == 0 || current[0] == h - 1 || current[1] == w - 1) return visited[current[0]][current[1]];

                if(map[current[0]][current[1]] == '@') map[current[0]][current[1]] = '.';
                for (int i = 0; i < 4; i++) {
                    int nr = current[0] + dr[i];
                    int nc = current[1] + dc[i];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                    if (map[nr][nc] != '.') continue;
                    if(visited[nr][nc] > 0) continue;

                    map[nr][nc] = '@';
                    visited[nr][nc] = visited[current[0]][current[1]] + 1;
                    sQueue.offer(new int[]{nr, nc});
                }
            }

            if(sQueue.isEmpty()) return -1;
        }
    }
}