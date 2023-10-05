import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  2023-10-05
 * 	
 * 	Bj2458 : 키 순서
 * 
 *  인접행렬과 메모이제이션
 */
public class Bj2458 {

	static int N, M, adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());

		adj = new int[N + 1][N + 1];

		for(int i = 0; i < N + 1; i++) {
			adj[i][0] = -1;	// 메모이제이션 이용. 초기값 -1로 설정
		}

		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken().trim());
			int c = Integer.parseInt(st.nextToken().trim());

			adj[r][c] = 1;	// 인접 행렬 저장
		}

		for(int i = 1; i < N + 1; i++) {
			if(adj[i][0] == -1) dfs(i);	// 0열이 -1이면 아직 탐색하지 않은 곳. dfs 탐색하기
		}

		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				adj[0][j] += adj[i][j];	// 키 작은 학생들 수 저장
			}
		}

		int answer = 0;
		for(int i = 0; i < N + 1; i++) {
			if(adj[i][0] + adj[0][i] == N - 1) answer++;	// 키 작은 학생 수 + 키 큰 학생 수 = N-1 이면 몇 번째인지 알 수 있음
		}

		System.out.println(answer);
	}

	private static void dfs(int cur) {	// cur : 현재 탐색할 번호
		for(int j = 1; j < N + 1; j++) {
			if(adj[cur][j] == 1) {	// 1이고
				if(adj[j][0] == -1) {	// 아직 탐색하지 않은 곳이면
					dfs(j);	// 탐색하기
				}

				// 탐색했던 곳이거나 탐색이 끝났으면
				if(adj[j][0] > 0) {	// 메모이제이션 확인. 0보다 크면 키가 큰 학생들이 있는 것
					for(int c = 1; c < N + 1; c++) {
						if(adj[j][c] == 1) adj[cur][c] = 1;	// 간접 관계를 직접 관계로 저장
					}
				}
			}

			int cnt = 0;	// 키 큰 학생들 수
			for(int c = 1; c < N + 1; c++) {
				if(adj[cur][c] == 1) cnt++;	// 키 큰 학생 수 세기
			}
			adj[cur][0] = cnt;	// 0열에 저장
		}
	}

}
