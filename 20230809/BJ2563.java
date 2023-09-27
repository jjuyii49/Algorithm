import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
		
		int[][] map = new int[100][100];	// 도화지를 나타내는 배열 선언
		int count = 0;	// 넓이를 개수로 판단하기 위해서 count 변수 선언
		int N = Integer.parseInt(br.readLine());	// 색종이 개수 입력 받기
		
		StringTokenizer st;	// 공백으로 분리하기 위한 StringTokenizer 선언
		while(N-- > 0) {	// 색종이가 없을 때까지
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력받아 공백으로 나누기
			int x = Integer.parseInt(st.nextToken());	// 색종이의 x 좌표 입력 받기
			int y = Integer.parseInt(st.nextToken());	// 색종이의 y 좌표 입력 받기
			
			for(int i = x; i < x + 10; i++) {	// 색종이의 크기만큼 반복 10번
				for(int j = y; j < y + 10; j++) {	// 색종이의 크기만큼 반복 10번
					if(++map[i][j] == 1) count++;	// 색종이가 있는 곳은 1 증가시키고 그 값이 1이면 count 증가
				}
			}
		}
		
		System.out.println(count);	// count 출력
	}

}
