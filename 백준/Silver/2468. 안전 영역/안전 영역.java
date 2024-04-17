import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, maxHeight, max, map[][];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = null;

        map = new int[N][N];
        maxHeight = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < map[i][j]) maxHeight = map[i][j];
            }
        }

        max = Integer.MIN_VALUE;

        flooding(map, maxHeight);

        System.out.println(max);
    }

    private static void flooding(int[][] map, int maxHeight) {
        int height = -1;

        while(height++ <= maxHeight) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 0) continue;
                    else if(map[i][j] <= height) map[i][j] = 0;
                }
            }

            int num = find(map);
            if(max < num) max = num;
        }
    }

    private static int find(int[][] map) {
        int num = 0;
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    num++;
                    dfs(i, j);
                }
            }
        }

        return num;
    }

    private static void dfs(int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            if(visited[nr][nc]) continue;

            if(map[nr][nc] == 0) continue;

            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}