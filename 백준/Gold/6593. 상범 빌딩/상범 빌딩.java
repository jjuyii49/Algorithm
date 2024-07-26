import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, R, C, end[];
    static char[][][] map;
    static int[][][] visited;
    static int[] dl = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new int[L][R][C];
            int[] start = new int[3];
            end = new int[3];

            for(int l = 0; l < L; l++) {
                for(int r = 0; r < R; r++) {
                    String input = br.readLine().trim();
                    for(int c = 0; c < C; c++) {
                        map[l][r][c] = input.charAt(c);

                        if(map[l][r][c] == 'S') {
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        } else if(map[l][r][c] == 'E') {
                            end[0] = l;
                            end[1] = r;
                            end[2] = c;
                        }
                    }
                }
                br.readLine();
            }

            int time = bfs(start[0], start[1], start[2]);

            if(time > 0) {
                sb.append("Escaped in ").append(time - 1).append(" minute(s).").append("\n");
            }
            else {
                sb.append("Trapped!").append("\n");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int l, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {l, r, c});
        visited[l][r][c] = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == end[0] && current[1] == end[1] && current[2] == end[2]) {
                return visited[current[0]][current[1]][current[2]];
            }

            for(int i = 0; i < 6; i++) {
                int nl = current[0] + dl[i];
                int nr = current[1] + dr[i];
                int nc = current[2] + dc[i];

                if(nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C) continue;
                if(map[nl][nr][nc] == '#' || visited[nl][nr][nc] > 0) continue;

                queue.offer(new int[] {nl, nr, nc});
                visited[nl][nr][nc] = visited[current[0]][current[1]][current[2]] + 1;
            }
        }

        return -1;
    }
}