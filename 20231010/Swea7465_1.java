import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea7465_1 {

	static int N, M, adj[][];	// N : 사람의 수, M : 서로를 알고있는 사람의 관계 수, adj[][] : 인접 행렬
	static boolean[] visited;	// 방문 체크
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// N 입력 받기
			M = Integer.parseInt(st.nextToken());	// M 입력 받기

			adj = new int[N + 1][N + 1];	// 인접 행렬 생성
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());

				int i = Integer.parseInt(st.nextToken());	// 서로 알고 있는 사람의 번호
				int j = Integer.parseInt(st.nextToken());	// 서로 알고 있는 사람의 번호

				adj[i][j] = adj[j][i] = 1;	// 인접 행렬에 저장
			}

			visited = new boolean[N + 1];	// 방문 체크 배열 생성
			
			int cnt = 0;	// 무리 개수
			for(int i = 1; i < N + 1; i++) {
				int sum = 0;	// 서로 알고 있는 사람이 아무도 없는 경우를 확인하기 위한 변수
				for(int j = 1; j < N + 1; j++) {
					if(adj[i][j] == 1 && !visited[i]) {	// 인접한데 방문하지 않았으면
						cnt++;	// 새로운 무리
						visited[i] = true;	// 방문
						dfs(i);	// dfs 실행
					}
					
					sum += adj[i][j];	// 서로 알고 있는 사람이 아무도 없는 경우를 확인하기 위해 합을 구함
				}
				
				if(sum == 0) cnt++;	// 합이 0 이면 아무도 서로 알고있는 사람이 없는 경우. 1개의 무리로 인식
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int r) {
		for(int c = 1; c < N + 1; c++) {
			if(adj[r][c] == 1 && !visited[c]) {	// 인접하고 인접한 번호가 방문되지 않았으면
				visited[c] = true;	// 방문
				dfs(c);	// dfs 실행
			}
		}
	}

}
