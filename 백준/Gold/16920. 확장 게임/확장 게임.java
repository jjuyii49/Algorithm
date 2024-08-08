import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, P;
    static char[][] map;
    static int[] num;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        num = new int[P + 1];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i < P + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine().trim();

            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        bfs();

        int[] result = new int[P + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int temp = 0;
                if(map[i][j] != '.' && map[i][j] != '#') {
                    temp = map[i][j] - '0';
                }

                result[temp]++;
            }
        }

        for(int i = 1; i < P + 1; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static void bfs() {
        Queue<int[]>[] queues = new ArrayDeque[P + 1];
        for(int i = 1; i < P + 1; i++) {
            queues[i] = new ArrayDeque<>();
        }

        // 초기 맵 상태에서 플레이어의 성 위치 각 queue에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '.' && map[i][j] != '#') {
                    int temp = map[i][j] - '0';
                    queues[temp].offer(new int[]{i, j, num[temp]});
                }
            }
        }

        boolean expanded;
        do {
            expanded = false;
            for(int p = 1; p < P + 1; p++) {
                Queue<int[]> queue = new ArrayDeque<>();

                while(!queues[p].isEmpty()) {
                    int[] current = queues[p].poll();

                    int r = current[0];
                    int c = current[1];
                    int n = current[2];

                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if(map[nr][nc] != '.') continue;

                        if(n - 1 == 0) {
                            queue.offer(new int[] {nr, nc, num[p]});
                        }
                        else {
                            queues[p].offer(new int[]{nr, nc, n - 1});
                        }
                        
                        map[nr][nc] = map[r][c];
                        expanded = true;
                    }
                }
                queues[p] = queue;
            }
        } while (expanded);
    }
}