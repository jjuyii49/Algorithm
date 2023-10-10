import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj17144 {

	static class Data {
		int i, j, num;

		public Data(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public Data(int i, int j, int num) {
			super();
			this.i = i;
			this.j = j;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Data [i=" + i + ", j=" + j + "]";
		}

	}

	static int R, C, T, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(T-- > 0) {
			bfs();
			move();
		}

		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;

				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	private static void bfs() {
		Queue<Data> queue = new ArrayDeque<>();

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) queue.offer(new Data(i, j, map[i][j]));
			}
		}

		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		while(!queue.isEmpty()) {
			Data current = queue.poll();

			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				int nr = current.i + dr[i];
				int nc = current.j + dc[i];

				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

				if(map[nr][nc] != -1) {
					cnt++;
					map[nr][nc] += current.num / 5;
				}
			}

			map[current.i][current.j] -= (current.num / 5) * cnt;
		}
	}

	private static void move() {
		int air = -1;
		for(int i = 0; i < R; i++) {
			if(map[i][0] == -1) {
				air = i;
				break;
			}
		}

		int[][] newMap = new int[R][C];

		// 현재 맵 복사
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				newMap[i][j] = map[i][j];
			}
		}

		// 위쪽 공기청정기 미세먼지 이동
		for(int j = 0; j < C - 1; j++) {
			newMap[0][j] = map[0][j + 1];
		}

		for(int i = 1; i < air; i++) {
			newMap[i][0] = map[i - 1][0];
		}

		for(int j = 1; j < C; j++) {
			if(map[air][j - 1] == -1) {				
				newMap[air][j] = 0;
			}
			else newMap[air][j] = map[air][j - 1];
		}

		for(int i = 0; i < air; i++) {
			newMap[i][C-1] = map[i + 1][C - 1];
		}

		air++;
		
		// 아래쪽 공기청정기 미세먼지 이동
		for(int j = 0; j < C - 1; j++) {
			newMap[R - 1][j] = map[R - 1][j + 1];
		}

		for(int i = air + 1; i < R; i++) {
			newMap[i][C - 1] = map[i - 1][C - 1];
		}

		for(int j = 1; j < C; j++) {
			if(map[air][j - 1] == -1) {				
				newMap[air][j] = 0;
			}
			else newMap[air][j] = map[air][j - 1];
		}

		for(int i = air + 1; i < R - 1; i++) {
			newMap[i][0] = map[i + 1][0];
		}

		// 새로운 맵을 현재 맵으로 복사
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = newMap[i][j];
			}
		}
	}
}
