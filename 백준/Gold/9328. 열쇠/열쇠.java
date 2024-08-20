import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int h, w, keys, count;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]>[] doors;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String input = br.readLine().trim();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            keys = 0;

            String sKey = br.readLine().trim();
            if (!sKey.equals("0")) {
                for (int i = 0; i < sKey.length(); i++) {
                    int iKey = sKey.charAt(i) - 'a';
                    keys |= (1 << iKey);
                }
            }

            count = 0;
            doors = new ArrayList[26];
            for(int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }

            for(int i = 0; i < h; i++) {
                if(checkOut(i, 0)) bfs(i, 0);
                if(checkOut(i, w - 1)) bfs(i, w - 1);
            }

            for(int j = 0; j < w; j++) {
                if(checkOut(0, j)) bfs(0, j);
                if(checkOut(h - 1, j)) bfs(h - 1, j);
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static boolean checkOut(int r, int c) {
        return !visited[r][c] && map[r][c] != '*';
    }

    static void bfs(int r, int c) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;

        if (map[r][c] == '$') {  // 문서인 경우
            count++;
        } else if (Character.isLowerCase(map[r][c])) { // 열쇠인 경우
            int iKey = map[r][c] - 'a';

            keys |= (1 << iKey);
            visited = new boolean[h][w];

            while (!doors[iKey].isEmpty()) {
                int[] door = doors[iKey].remove(0);
                queue.offer(door);
                visited[door[0]][door[1]] = true;
            }
        } else if (Character.isUpperCase(map[r][c])) {   // 문인 경우
            int iDoor = map[r][c] - 'A';
            if ((keys & (1 << iDoor)) == 0) {   // 열쇠 없음
                doors[iDoor].add(new int[]{r, c});
                queue.pollLast();
                visited[r][c] = false;
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if(map[nr][nc] == '*' || visited[nr][nc]) continue;

                if (map[nr][nc] == '$') {  // 문서인 경우
                    count++;
                } else if (Character.isLowerCase(map[nr][nc])) { // 열쇠인 경우
                    int iKey = map[nr][nc] - 'a';

                    if((keys & (1 << iKey)) == 0) { // 새로운 열쇠 획득
                        keys |= (1 << iKey);

                        while (!doors[iKey].isEmpty()) {
                            int[] door = doors[iKey].remove(0);
                            queue.offer(door);
                            visited[door[0]][door[1]] = true;
                        }
                    }
                } else if (Character.isUpperCase(map[nr][nc])) {   // 문인 경우
                    int iDoor = map[nr][nc] - 'A';
                    if ((keys & (1 << iDoor)) == 0) {   // 열쇠 없음
                        doors[iDoor].add(new int[]{nr, nc});
                        continue;
                    }
                }

                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}