import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2023-09-27
 * Bj3055 : 탈출
 * 
 * 오 나의 여신님이랑 비슷했던 문제
 * 고슴도치 큐와 물 큐를 따로 두고
 * 고슴도치 먼저 이동 후 물 이동
 */
public class Bj3055 {

	static int R, C;	// 숲의 크기
	static char[][] map;	// 지도를 저장할 2차원 배열
	static Queue<Data> queueS, queueW;	// queueS : 고슴도치큐, queueW : 물 큐
	static int[][] visited;	// 고슴도치 방문 체크할 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력
		StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄 입력받고 공백 나누기

		R = Integer.parseInt(st.nextToken());	// 행 입력 받기
		C = Integer.parseInt(st.nextToken());	// 열 입력 받기

		map = new char[R][C];	// 2차원 배열 생성
		queueS = new ArrayDeque<>();	// 고슴도치 큐 생성
		queueW = new ArrayDeque<>();	// 물 큐 생성
		visited = new int[R][C];	// 방문체크 배열 생성
		Data D = new Data(0, 0);	// D 위치 저장할 Data 객체 생성
		for(int i = 0; i < R; i++) {	// 행 반복
			String input = br.readLine();	// 입력 받기
			for(int j = 0; j < C; j++) {	// 열 반복	
				map[i][j] = input.charAt(j);	//  한 글자씩 분리하기
				if(map[i][j] == '*') queueW.offer(new Data(i, j));	// *이면 물 큐에 넣기
				if(map[i][j] == 'S') {	// S이면
					queueS.offer(new Data(i, j));	// 고슴도치 큐에 넣기
					visited[i][j] = 1;	// 방문 체크를 위해 1로 변경
				}
				if(map[i][j] == 'D') D = new Data(i, j);	// D이면 위치 저장
			}
		}

		bfs();	// bfs 실행

		System.out.println(visited[D.i][D.j] == 0? "KAKTUS" : visited[D.i][D.j] - 1);	// D 위치의 방문값이 0이면 미방문이므로 KAKTUS 출력, 아니면 방문값 - 1 출력
	}

	private static void bfs() {
		// 4방향 탐색
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		while(!queueS.isEmpty()) {	// 고슴도치 큐가 빌 때까지 반복
			int sSize = queueS.size();	// 현재 고슴도치 큐의 사이즈만큼만 반복
			while(sSize-- > 0) {
				Data currentS = queueS.poll();	// 고슴도치 큐에서 뽑기
				if(map[currentS.i][currentS.j] == '*') continue;	// 만약 뽑은 위치가 *로 바뀌었으면 다음 큐 뽑으러 가기
				map[currentS.i][currentS.j] = '.';	// 이동할거니까 .으로 변경

				for(int i = 0; i < 4; i++) {	// 4방향 반복
					int nr = currentS.i + dr[i];	// 탐색할 행 위치
					int nc = currentS.j + dc[i];	// 탐색할 열 위치

					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;	// 범위 벗어나면 다음껄로

					if(visited[nr][nc] != 0) continue;	// 방문했으면 다음껄로

					
					if(map[nr][nc] == '.') {	// .이면 이동할 수 있는 곳
						map[nr][nc] = 'S';	// S로 변경
						queueS.offer(new Data(nr, nc));	// 고슴도치 큐에 넣기
						visited[nr][nc] = visited[currentS.i][currentS.j] + 1;	// 방문값 변경
					}

					if(map[nr][nc] == 'D') {	// D이면 탈출 성공!
						map[nr][nc] = 'S';	// S로 변경
						visited[nr][nc] = visited[currentS.i][currentS.j] + 1;	// 방문값 변경
						return;	// 반복문 종료
					}
				}
			}
			
			int wSize = queueW.size();	// 현재 물 큐의 사이즈만큼 반복
			while(wSize-- > 0) {
				Data currentW = queueW.poll();	// 물 큐에서 뽑기
				for(int i = 0; i < 4; i++) {	// 4방향 반복
					int nr = currentW.i + dr[i];	// 탐색할 행 위치
					int nc = currentW.j + dc[i];	// 탐색할 열 위치
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;	// 범위 벗어나면 다음껄로
					
					if(map[nr][nc] == '.' || map[nr][nc] == 'S') {	// .이거나 S이면 물 이동 가능
						map[nr][nc] = '*';		// *로 변경
						queueW.offer(new Data(nr, nc));	// 물 큐에 넣기
					}
				}
			}
		}

	}

	static class Data{	// 위치 인덱스 관리 위한 Data 클래스
		int i, j;	// 행, 열

		public Data(int i, int j) {	// 생성자
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Data [i=" + i + ", j=" + j + "]";
		}

	}

}
