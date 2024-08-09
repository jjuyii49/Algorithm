import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, map[][];
    static boolean[][] visited;
    static ArrayList<int[]>[][] lampList;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        map[1][1] = 1;

        int M = Integer.parseInt(st.nextToken());

        lampList = new ArrayList[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                lampList[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lampList[x][y].add(new int[] {a, b});
        }

        visited = new boolean[N + 1][N + 1];

        bfs();

        int result = 0;

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(map[i][j] == 1) result++;
            }
        }

        System.out.println(result);
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            // 불 키기
            if(!lampList[r][c].isEmpty()) {
                for(int i = 0; i < lampList[r][c].size(); i++) {
                    int[] lamp = lampList[r][c].get(i);

                    if(map[lamp[0]][lamp[1]] == 0) {
                        visited = new boolean[N + 1][N + 1];
                        map[lamp[0]][lamp[1]] = 1;
                    }
                }
            }

            // 이동하기
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 1 || nc < 1 || nr >= N + 1 || nc >= N + 1) continue;
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;

                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}