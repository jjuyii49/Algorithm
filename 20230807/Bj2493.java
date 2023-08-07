import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한  BufferedReader br 선언
		int N = Integer.parseInt(br.readLine());	// N 입력
		Deque<int[]> top = new ArrayDeque();	// top의 번호와 높이를 함께 저장하기 위해서 Type을 int[]로 선언
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 공백으로 분리하여 저장하기 위한 StringTokenizer st 선언
		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
		for(int i = 0; i < N; i++) {	// N번 반복
			int temp = Integer.parseInt(st.nextToken());	// 탑의 높이를 임시 저장.
			int idx = 1;	// 레이저를 받는 탑의 번호를 저장할 변수 idx
			
			while(true) {	// top.size()가 0이거나 레이저를 보내는 탑보다 높은 탑이 있을 때 탈출
				if(top.size() == 0) {	// top.size()가 0이면
					idx = 0;			// 레이저를 받는 탑이 없으므로 idx = 0
					break;				// while문 탈출
				}
				
				if(top.peekLast()[1] < temp) {	// 덱에 마지막으로 들어있는 탑의 높이가 레이저를 송신할 탑보다 낮으면
					top.pollLast();				// 덱에서 삭제
				}
				else {							// 덱에 마지막으로 들어있는 탑의 높이가 레이저를 송신할 탑보다 높으면
					idx = top.peekLast()[0];	// 그 탑이 레이저를 수신하므로 idx에 번호 저장
					break;						// while문 탈출
				}
			}
			
			top.offerLast(new int[] {i + 1, temp});	// 임시 저장한 탑의 높이(temp)를 번호와 함께 덱에 저장
			sb.append(idx).append(" ");				// 레이저를 수신하는 탑의 번호를 sb에 저장
		}
		System.out.println(sb);	// sb 출력
		
	}
}
