import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *  2023-10-04
 *  Bj2146 : 다리 만들기
 *  
 *  섬 구분
 *  - 2중 반복문 이용
 *  - map이 1이고 island가 0이면 새로운 섬
 *  - 해당 위치를 기준으로 4방 탐색 bfs 돌리기 -> 연결되어 있는 위치는 같은 idx로 저장
 *  - idx 증가
 *  
 *  최단 거리 찾기
 *  - 2중 반복문 이용
 *  - island가 0이 아니면 섬
 *  - 해당 위치를 기준으로 4방 탐색, 탐색 시마다 방문 배열 새로 생성
 *    0이면 -> 바다이므로 cnt 증가, 탐색해서 다른 섬을 찾아야되니까 큐에 넣기
 *    다른 섬을 만나면 -> cnt와 min 비교해서 최소값 저장
 *    같은 섬을 만나면 -> 탐색할 필요 x, 큐에 안넣음
 *  - 가지치기 : current.cnt가 min 값보다 크면 더 이상 탐색할 필요 x -> continue;
 *  
 */
public class Bj2146 {

	static int N;
	static int[][] map;
	static int[][] island;	// 새로운 섬 배열
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int min;	// 다리의 최단 거리
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// N 입력 받기
		
		map = new int[N][N];	// map 생성
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// map 입력 받기
			}
		}
		
		island = new int[N][N];	// 새로운 섬 배열 생성
		min = Integer.MAX_VALUE;	// 최소값
		
		findIsland();	// 섬 번호 매기기
		bfs();	// 최단 거리 찾기
		System.out.println(min);
	}
	
	private static void findIsland() {
		Queue<Data> queue = new ArrayDeque<>();
		
		int idx = 1;	// 섬 번호
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && island[i][j] == 0) {	// 1(섬)이고 새로운 섬으로 저장되지 않았으면
					queue.offer(new Data (i, j));	// 큐에 넣기
					island[i][j] = idx;	// 새로운 섬으로 저장
					
					while(!queue.isEmpty()) {
						Data current = queue.poll();
						
						for(int k = 0; k < 4; k++) {	// 4방 탐색
							int nr = current.i + dr[k];
							int nc = current.j + dc[k];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;	// 범위 넘으면 continue
							
							if(island[nr][nc] != 0) continue;	// 새로운 섬으로 저장되어 있으면 continue
							
							if(map[nr][nc] == 1) {	// 1(섬)이면
								queue.offer(new Data (nr, nc));	// 큐에 넣기
								island[nr][nc] = idx;	// 새로운 섬으로 저장
							}
						}
					}
					// 해당 위치와 인접한 섬 저장 완료
					
					idx++;	// idx 증가 -> 다음 섬 번호	 
				}
			}
		}
		
	}
	
	private static void bfs() {
		Queue<Data> queue = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(island[i][j] != 0) {	// 섬 번호가 0이 아니면 섬
					boolean[][] visited = new boolean[N][N];	// 해당 위치 기준으로 방문 체크
					queue.offer(new Data(i, j, 0));	// 큐에 넣기
					visited[i][j] = true;	// 방문 체크

					int idx = island[i][j];	// 해당 위치의 섬 번호 저장 -> 4방 탐색 시 같은 섬인지 확인용
					while(!queue.isEmpty()) {
						Data current = queue.poll();
						
						if(current.cnt > min) continue;	// 가지치기 : 현재의 다리 거리 cnt가 min보다 크면 더 이상 탐색할 필요 x
						
						for(int k = 0; k < 4; k++) {	// 4방 탐색
							int nr = current.i + dr[k];
							int nc = current.j + dc[k];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;	// 범위 벗어나면 continue
							
							if(visited[nr][nc]) continue;	// 방문했으면 continue
							
							if(island[nr][nc] == 0) {	// 0이면 바다
								queue.offer(new Data(nr, nc, current.cnt + 1));	// cnt 증가하고 큐에 넣기
								visited[nr][nc] = true;	// 방문 체크
								continue;	// 다음 탐색
							}
							
							if(island[nr][nc] != idx) min = Math.min(min, current.cnt);	// 0이 아니고 같은 섬이 아니면 최소값 저장 
							
						}
					}
				}
			}
		}
		
		
	}
	
	static class Data{
		int i, j, cnt;

		public Data(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public Data(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Data [i=" + i + ", j=" + j + "]";
		}
		
	}

}
