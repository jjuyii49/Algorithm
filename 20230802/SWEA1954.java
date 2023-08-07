import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hwalgo02_SWEA1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력 받기 위한 BufferedReader 선언
		int T = Integer.parseInt(br.readLine());	// 입력 받은 테스트케이스 값을 T 변수에 Integer type으로 저장
		
		for(int tc = 1; tc <= T; tc++) {	// 테스트 케이스만큼 반복
			int N = Integer.parseInt(br.readLine());	// 입력 받은 달팽이의 크기 N을 Integer type으로 저장
			StringBuilder sb = new  StringBuilder();	// 빠른 출력을 위한 String Builder 선언
			sb.append("#").append(tc).append("\n");	// 출력 양식 저장
			
			int[][] map = new int[N][N];	// 달팽이 숫자를 저장할 배열 선언
			int num = 1;	// 달팽이에 저장할 숫자 변수 선언 및 초기화. 숫자는 1부터 시작.
			
			int[] dx = {0, 1, 0, -1};	// 방향 전환에 따른 x 값 변화 저장. [0]:오른쪽, [1]:아래, [2]:왼쪽, [3]:위
			int[] dy = {1, 0, -1, 0};	// 방향 전환에 따른 y 값 변화 저장. [0]:오른쪽, [1]:아래, [2]:왼쪽, [3]:위
			int x = 0, y = 0;	// 첫 시작 인덱스는 0,0
			int dir = 0;	// 방향 저장 변수 선언. 첫 시작은 오른쪽 0.
			
			while(true) {	// 반복문을 이용해 달팽이 숫자를 저장.
				if(num > N * N) break;	// num이 N * N보다 크면 탈출. 더 이상 저장할 수 x
				if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 0) {	// x, y가 인덱스 값 안에 있고 가리키는 값이 0일 때,
					map[x][y] = num++;										// num 저장.
				}
				else {	// x, y가 인덱스 밖 값이거나 가리키는 값이 0이 아닐 때,
					x -= dx[dir];	// 이미 변경된 x값을 이전 상태로 돌림.
					y -= dy[dir];	// 이미 변경된 y값을 이전 상태로 돌림.
					dir = (dir + 1) % 4;	// 방향 전환. 4로 나눈 나머지 값을 dir에 대입 (0, 1, 2, 3만 사용하기 때문)
				}
				
				x += dx[dir];	// 방향에 맞추어 x 새로 저장
				y += dy[dir];	// 방향에 맞추어 y 새로 저장
				
			}
			for(int i = 0; i < N; i++) {	// map의 크기 만큼 반복
				for(int j = 0; j < N; j++) {	// map[]의 크기 만큼 반복
					sb.append(map[i][j]).append(" ");	// sb의 값에 붙여서 저장
				}
				sb.append("\n");	// map[] 한 줄이 저장되면 줄바꿈
			}
			
			System.out.print(sb);	// sb 출력
		}
	}

}
