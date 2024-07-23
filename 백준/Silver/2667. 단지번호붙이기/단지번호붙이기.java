import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, map[][];
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine().trim();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int count = 0;
        ArrayList<Integer> sizeList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    sizeList.add(bfs(i, j));
                }
            }
        }

        System.out.println(count);

        Collections.sort(sizeList);
        for(int i = 0; i < sizeList.size(); i++) {
            System.out.println(sizeList.get(i));
        }
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int size = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;

                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                size++;
            }
        }

        return size;
    }
}