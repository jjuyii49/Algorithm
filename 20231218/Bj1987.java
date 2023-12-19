import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	2023.12.18
 * 	Bj1987. 알파벳
 * 	말이 좌측 상단에서 시작해서 최대한 몇 칸을 지날 수 있는지 구하는 문제.
 * 	말은 상하좌우 이동 가능.
 * 	지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 다른 알파벳이 적혀있는 칸으로만 이동 가능. 
 */

public class Bj1987 {
	
	static int R, C;
	static char map[][];
	static int max;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		// 입력 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		// R, C, map 입력 받기
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine().trim();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		// 입력 끝

		max = Integer.MIN_VALUE;	// max 초기값은 Integer의 최소값으로 함.
		
		// dfs 실행
		dfs(0, 0, 0, 1);	// 초기 위치 (0, 0)과 비트마스킹으로 방문 체크할 alphabet 값, 지나는 칸에 출발지도 포함되므로 1
		
		System.out.println(max);	// max 값 출력
	}
	
	private static void dfs(int r, int c, int alphabet, int num) {
		// dfs가 실행되었다는 것은 방문할 수 있는 칸 => alpahbet에 방문 체크하기
		char now = map[r][c];
		alphabet |= 1 << (now-'A');	// 비트마스킹 or 이용
		
		// 상하좌우 이동
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;	// 이동할 칸의 범위 체크
			
			if((alphabet & (1 << (map[nr][nc]-'A'))) != 0) continue;	// 방문 체크
			
			// 방문하지 않았던 알파벳
			dfs(nr, nc, alphabet, num + 1);	// 칸 이동 
		}
		
		// 상하좌우 탐색이 다 끝났으므로 더 이상 말이 이동할 수 없음.
		if(max < num) max = num;	// max 값 갱신
		
	}
}