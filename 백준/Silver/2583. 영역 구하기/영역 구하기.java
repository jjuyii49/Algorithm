import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N, map[][], count;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];

        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine().trim());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());

            for(int x = lbx + 1; x <= rtx; x++) {
                for(int y = lby + 1; y <= rty; y++) {
                    map[y][x] = -1;
                }
            }
        }

        count = 0;
        result = new ArrayList<>();
        for(int i = 1; i < M + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(map[i][j] != -1 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);

        Collections.sort(result);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;

        int temp = 1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 1 || nc < 1 || nr >= M + 1 || nc >= N + 1) continue;
                if(map[nr][nc] == -1 || visited[nr][nc]) continue;

                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                temp++;
            }
        }

        result.add(temp);
    }

}