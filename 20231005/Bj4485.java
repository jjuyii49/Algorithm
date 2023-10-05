import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 2023-10-05
 * 
 * Bj4485 : 녹색 옷 입은 애가 젤다지?
 * 
 * 최소 비용 찾기, 주어지는 값이 양수 -> 다익스트라 이용
 * 비용 배열을 현재까지의 비용 + 이동할 map 비용과 비교하여 최소값으로 저장
 * 
 */
public class Bj4485 {

	static int N, map[][], visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			sb.append("Problem ").append(++t).append(": ");
			
			map = new int[N][N];
			StringTokenizer st = null;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	// map 입력 받기
				}
			}
			
			visited = new int[N][N];	// 방문 체크 배열 <- 최소 비용 저장
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited[i][j] = Integer.MAX_VALUE;	// 초기값을 max로 설정
				}
			}
			
			bfs();
			sb.append(visited[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs() {
		PriorityQueue<Data> pqueue = new PriorityQueue<>();	// 다익스트라 사용 위해 우선순위 큐 사용
		
		pqueue.offer(new Data(0, 0, map[0][0]));	// 출발 위치
		visited[0][0] = map[0][0];	// 출발 위치 비용 저장
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(!pqueue.isEmpty()) {
			Data current = pqueue.poll();
			
			for(int i = 0; i < 4; i++) {	// 4방향 탐색
				int nr = current.i + dr[i];
				int nc = current.j + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(visited[nr][nc] > visited[current.i][current.j] + map[nr][nc]) {	// 방문할 위치까지의 비용이 현재까지의 비용 + 방문할 비용보다 크면
					visited[nr][nc] = visited[current.i][current.j] + map[nr][nc];	// 변경
					pqueue.offer(new Data(nr, nc, visited[nr][nc]));	// 큐에 넣기
				}
			}
			
		}
	}

	public static class Data implements Comparable<Data>{
		int i, j, num;

		public Data(int i, int j, int num) {
			super();
			this.i = i;
			this.j = j;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Data [i=" + i + ", j=" + j + ", num=" + num + "]";
		}

		@Override
		public int compareTo(Data o) {
			return this.num - o.num;
		}
		
	}
}
