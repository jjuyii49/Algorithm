import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l, map[][], visited[][];
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for(int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine().trim());
            map = new int[l][l];
            visited = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            map[sr][sc] = 1;

            st = new StringTokenizer(br.readLine().trim());
            int fr = Integer.parseInt(st.nextToken());
            int fc = Integer.parseInt(st.nextToken());
            map[fr][fc] = -1;

            sb.append(bfs(sr, sc)).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = 1;
        queue.add(new int[] {r, c});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(map[current[0]][current[1]] == -1) {
              return visited[current[0]][current[1]] - 1;
            }

            for(int i = 0; i < 8; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= l || nc >= l) continue;

                if(visited[nr][nc] != 0) continue;

                visited[nr][nc] = visited[current[0]][current[1]] + 1;
                queue.add(new int[] {nr, nc});
            }
        }

        return 0;
    }
}