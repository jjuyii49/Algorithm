import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 	Bj16926 : 배열 돌리기 1
 * 	[N][M]배열의 요소들이 반시계 방향으로 R번 회전
 *	A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
 * 		↓                                       ↑
 *	A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
 * 		↓         ↓                   ↑         ↑
 *	A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
 * 		↓                                       ↑
 *	A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
 */

public class Bj16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
		StringTokenizer st = new StringTokenizer(br.readLine());	// 입력값을 공백을 기준으로 분리하기 위한 StringTokenizer 선언
		
		int N = Integer.parseInt(st.nextToken());	// 배열의 크기 N 입력 받기
		int M = Integer.parseInt(st.nextToken());	// 배열의 크기 M 입력 받기
		int R = Integer.parseInt(st.nextToken());	// 배열의 회전 수 R 입력 받기
		
		String[][] map = new String[N][M];	// 주어진 배열을 저장할 String 배열 선언
		for(int i = 0; i < N; i++) {	// 배열의 크기만큼 반복
			map[i] = br.readLine().split(" ");	// 공백으로 분리하여 배열에 저장
		}
		
		int num = Math.min(N, M) / 2;	// 배열을 회전시켜야하는 가짓수
		
		while(R-- > 0) {	// 회전 수만큼 반복 R번
			String[][] temp = new String[N][M];	// 회전시킨 배열을 임시 저장할 배열 선언
				
			for(int n = 0; n < num; n++) {	// 배열을 회전시켜야하는 가짓수만큼 반복
				for(int j = n; j < M - 1 - n; j++) {	// 왼쪽으로 이동하는 요소 처리
					temp[n][j] = map[n][j + 1];
				}
				
				for(int i = n + 1; i < N - n; i++) {	// 아래로 이동하는 요소 처리
					temp[i][n] = map[i -1][n];
				}
				
				for(int j = n + 1; j < M - n; j++) {	// 오른쪽으로 이동하는 요소 처리
					temp[N - 1 - n][j] = map[N - 1 - n][j - 1];
				}
				
				for(int i = n; i < N - 1 - n; i++) {	// 위로 이동하는 요소 처리
					temp[i][M - 1 - n] = map[i + 1][M - 1 - n];
				}
			}
			
			map = temp;	// map을 임시 저장한 배열로 변경
		}
		
		for(int i = 0; i < N; i++) {	// 배열의 크기만큼 반복 N번
			for(int j = 0; j < M; j++) {	// 배열의 크기만큼 반복 M번
				sb.append(map[i][j]).append(" ");	// sb에 저장
			}
			sb.append("\n");	// map[i] 출력 후 줄바꿈
		}
		
		System.out.println(sb);	// sb 출력

	}

}
