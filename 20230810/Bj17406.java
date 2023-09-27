import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  Bj17406 : 배열 돌리기4
 *  배열의 값은 각 행에 있는 모든 수의 합 중 최소값을 의미
 *  주어진 회전 연산(r, c, s)으로 (r-s, c-s)인덱스부터 (r+s, c+s)인덱스까지 회전
 *  회전 연산의 수(K)가 여러 개라면 순서를 임의로 정함 -> 어떤 걸 먼저 하느냐에 따라 값이 달라짐 -> 순열 이용!
 *  주어진 모든 회전 연산을 진행했을 때 배열 값의 최소값을 찾아야 함
 */

public class hwalgo08_Bj17406 {
	
	static int N;	// 배열의 크기 N
	static int M;	// 배열의 크기 M
	static int K;	// 회전 연산 수 K
	static String[][] map;	// 배열을 저장할 변수 map
	static String[][] mapCopy;	// 순열 재귀를 이용하므로 다음 재귀 호출 시 이전 호출의 영향 받지 않게 하기 위해 주어진 배열의 복사본을 이용
	static int[][] oper;	// 회전 연산을 저장할 배열 oper
	static boolean[] visited;	// 순열 재귀에서 사용할 방문 체크 배열
	static int[][] order;	// 순열을 저장할 2차원 배열
	static int minAll = Integer.MAX_VALUE;	// 재귀 실행 후 찾은 모든 최소값들 중에서 찾은 최소값을 저장할 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력을 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(br.readLine());	// 공백으로 분리하기 위한 StringTokenizer
		
		N = Integer.parseInt(st.nextToken());	// N 입력
		M = Integer.parseInt(st.nextToken());	// M 입력
		K = Integer.parseInt(st.nextToken());	// K 입력
		
		map = new String[N + 1][M + 1];	// 주어진 배열을 저장할 map 객체 생성
		mapCopy = new String[N + 1][M + 1];	// map을 복사할 mapCopy 객체 생성
		
		for(int i = 1; i <= N; i++) {	// N번 반복 (행 반복)
			st = new StringTokenizer(br.readLine());	// 공백으로 분리하기 위한 StringTokenizer 생성
			for(int j = 1; j <= M; j++) {	// M번 반복 (열 반복)
				map[i][j] = st.nextToken();	// map 배열에 저장
			}
		}
		
		for(int i = 1; i < N + 1; i++) {	// N번 반복하면서 (행 반복)
			mapCopy[i] = Arrays.copyOf(map[i], map[i].length);	// 배열 복사
			// (유의! 배열 복사 시 = 사용하지 않기 -> 참조값을 복사하기 때문에 복사 배열을 변경하면 원본 배열도 같이 변경됨)
			// 2차원 배열이기 때문에 반복문을 사용하여 행별로 복사
		}
		
		oper = new int[K][3];	// 회전 연산을 저장할 oper 객체 생성. r, c, s 3개의 값이 K번 입력되므로 크기는 [K][3]
		for(int i = 0; i < K; i++) {	// K번 반복 (행 반복)
			st = new StringTokenizer(br.readLine());	// 공백으로 분리하기 위한 StringTokenizer 생성
			for(int j = 0; j < 3; j++) {	// 3번 반복 (열 반복)
				oper[i][j] = Integer.parseInt(st.nextToken());	// oper에 입력값 저장
			}
		}
		
		visited = new boolean[K];	// 재귀 호출 시 방문을 체크할 visited 객체 생성
		order = new int[K][3];	// 순열을 저장할 order 객체 생성
		
		perm(0);	// 순열 재귀 함수 실행(첫 실행이니까 매개변수 idx는 0)
		
		System.out.println(minAll);	// 순열 재귀 함수 종료 후 찾은 최소값 출력
	}
	
	// 순열 재귀
	static void perm(int idx) {	// 변하는 값은 몇 번째 자리수를 뽑을 건지.
		if(idx == K) {	// 기저 조건 : 원하는 순열의 자리수는 K개이므로 idx가 K가 될 때가 기저조건이 됨
			
			// 만들어진 순열 순서대로 회전
			for(int i = 0; i < K; i++) {	// K번 회전 연산을 진행해야 하므로 K번 반복
				int r = order[i][0];	// i번째 자리수에 있는 첫 번째 값은 r
				int c = order[i][1];	// i번째 자리수에 있는 두 번째 값은 c
				int s = order[i][2];	// i번째 자리수에 있는 세 번째 값은 s
				rotation(r - s, c - s, r + s, c + s, mapCopy);	// mapCopy 회전.
			}
			
			// 배열의 각 행의 합의 최소값 찾기
			int min = Integer.MAX_VALUE;	// 배열의 각 행의 합의 최소값을 저장할 변수 선언
			for(int i = 1; i <= N; i++) {	// 배열의 크기만큼 반복 (행 반복)
				int sum = 0;				// 배열의 각 행의 합을 저장할 변수 선언
				for(int j = 1; j <= M; j++) {	// 배열의 크기만큼 반복 (열 반복)
					sum += Integer.parseInt(mapCopy[i][j]);	// 배열의 원소 합하기
				}
				min = Math.min(min, sum);	// 구한 sum과 min을 비교하여 작은 값 min에 저장
			}
			
			minAll = Math.min(minAll, min);	// 전체 최소값 중에서 최소값을 찾기 위해 minAll과 min을 비교하여 작은 값 minAll에 저장
			
			// 복사 배열을 다시 원본 배열로 만듦
			for(int i = 1; i < N + 1; i++) {	// N번 반복 (행 반복)
				mapCopy[i] = Arrays.copyOf(map[i], map[i].length);	// 다음 재귀 실행을 위해 처음 배열 map을 mapCopy로 복사
			}
			
			return;	// 메소드 종료
		}
		
		// 순열 만들기
		for(int i = 0; i < K; i++) {	// K번 반복
			if(visited[i]) continue;	// 방문했던 배열이면 선택할 수 없으므로(순열이니까) 다음 반복문 실행
			order[idx] = oper[i];		// oper[i] 값 order[idx]에 저장
			visited[i] = true;			// 선택되었으므로 true로 변경
			perm(idx + 1);				// 다음 자리수 선택을 위해 매개변수를 idx + 1로 실행
			visited[i] = false;			// 다음 반복문을 위해 false로 원상 복구
		}
		
	}
	
	// 회전 메소드
	static void rotation(int starti, int startj, int endi, int endj, String[][] mapCopy) {
		int num = Math.min(endi - starti + 1, endj - startj + 1) / 2;	// 주어진 인덱스의 가장 겉부분부터 안쪽까지 몇 번이나 회전할 건지 저장
		
		String[][] temp = new String[N + 1][M + 1];	// 회전하는 동안 임시 저장할 배열
		boolean[][] visited = new boolean[N + 1][M + 1];	// 주어진 인덱스의 크기가 홀수이면 회전하지 않는 원소가 존재
															// -> 원래 가지고 있던 값 그대로 존재해야하므로 방문체크를 통해
															//    방문하지 않은 곳은 변경하지 않는다.
		
		// 회전 처리
		for(int n = 0; n < num; n++) {	// num번 회전
			for(int j = startj + 1 + n; j <= endj - n; j++) {	// 오른쪽으로 이동하는 원소 처리
				temp[starti + n][j] = mapCopy[starti + n][j - 1];
				visited[starti + n][j] = true;
			}
			
			for(int i = starti + 1 + n; i <= endi - n; i++) {	// 아래로 이동하는 원소 처리
				temp[i][endj - n] = mapCopy[i - 1][endj - n];
				visited[i][endj - n] = true;
			}
			
			for(int j = startj + n; j <= endj - 1 - n; j++) {	// 왼쪽으로 이동하는 원소 처리
				temp[endi - n][j] = mapCopy[endi - n][j + 1];
				visited[endi - n][j] = true;
			}
			
			for(int i = starti + n; i <= endi - 1 - n; i++) {	// 위로 이동하는 원소 처리
				temp[i][startj + n] = mapCopy[i + 1][startj + n];
				visited[i][startj + n] = true;
			}
		}
		
		// 복사 배열에 변경 배열 저장
		for(int i = starti; i <= endi; i++) {	// 회전 시작 인덱스부터 끝나는 인덱스까지 반복
			for(int j = startj; j <= endj; j++) {	// 회전 시작 인덱스부터 끝나는 인덱스까지 반복
				if(visited[i][j]) mapCopy[i][j] = temp[i][j];	// 복사 배열에 변경 배열 저장
			}
		}
	}
}
