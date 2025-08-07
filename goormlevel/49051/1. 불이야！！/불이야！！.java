import java.io.*;
import java.util.*;

class Main {

	static int R, C;
	static char[][] map;
	static int[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new int[R][C];
		int gR = 0, gC = 0;
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '&') {
					gR = i;
					gC = j;
				}
			}
		}

		System.out.println(bfs(gR, gC));
	}

	private static int bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = 1;

		while(!queue.isEmpty()) {
			int[] current = queue.poll();

			for(int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];

				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(visited[nr][nc] != 0 || map[nr][nc] == '#') continue;
				if(map[nr][nc] == '@') return visited[current[0]][current[1]] - 1;

				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = visited[current[0]][current[1]] + 1;
			}
		}

		return -1;
	}
}