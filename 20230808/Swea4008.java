import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*	
 * 	Swea4008 : 숫자 만들기
 * 	N개의 숫자
 * 	+, -, *, / 연산자를 숫자 사이에 넣고 왼쪽에서 오른쪽으로 계산
 * 	최대값 - 최소값?
 */

// 연산자의 개수를 입력 받고 그 개수대로 char[] 배열을 만들어서 순열을 찾으려고 했으나
// 메모리 에러 발생.
// 원인은 못찾겠다.
/*public class Swea4008 {

	static int N;
	static char[] oper;	
	static int[] nums;
	static char[] out;
	static boolean[] v;
	static List<Integer> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			oper = new char[N-1];
			nums = new int[N];
			for(int i = 0, idx = 0; i < 4; i++) {
				int temp = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < temp; j++) {
					switch (i) {
					case 0:
						oper[idx] = '+';
						break;
					case 1:
						oper[idx] = '-';
						break;
					case 2:
						oper[idx] = '*';
						break;
					case 3:
						oper[idx] = '/';
						break;
					}
					idx++;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken()); 
			}
			
			out = new char[N - 1];
			v = new boolean[N - 1];
			
			perm(0);
			
			sb.append(Collections.max(result) - Collections.min(result)).append("\n");
			
		}
		
		System.out.println(sb);

	}
	
	static void perm(int idx) {
		if(idx == N - 1) {
			int temp = nums[0];
			for(int i = 0; i < N -1; i++) {
				switch (oper[i]) {
				case '+':
					temp += nums[i + 1];
				case '-':
					temp -= nums[i + 1];
				case '*':
					temp *= nums[i + 1];
				case '/':
					temp /= nums[i + 1];
				}
			}
			result.add(temp);
			return;
		}
		
		for(int i = 0; i < N - 1; i++) {
			out[idx] = oper[i];
			v[i] = true;
			perm(idx + 1);
			v[i] = false;
		}
	}
}*/

public class Swea4008 {
	
	static int N;	// 숫자의 개수
	static int[] oper;	// 연산자의 개수를 저장할 배열
	static int[] nums;	// 숫자 저장 배열
	static int max;	// max 값을 저장할 변수
	static int min;	// min 값을 저장할 변수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 생성
		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 값 입력 받기
		
		StringTokenizer st = null;	// 입력값을 공백을 기준으로 분리하기 위해 StringTokenizer 선언
		for(int t = 1; t < T + 1; t++) {	// 테스트 케이스만큼 반복
			sb.append("#").append(t).append(" ");	// 출력 양식
			N = Integer.parseInt(br.readLine());	// 숫자의 개수 N 입력 받기
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력 받아 공백으로 분리하기
			
			oper = new int[4];	// 연산자의 개수를 저장할 배열 선언 (+, -, *, /) 4개
			for(int i = 0 ; i < 4; i++) {	// 4번 반복
				oper[i] = Integer.parseInt(st.nextToken());	// 분리된 입력 값 저장
			}
			
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력 받아 공백으로 분리하기
			nums = new int[N];	// 숫자를 저장할 배열 선언
			for(int i = 0; i < N; i++) {	// 숫자의 개수만큼 반복 N번
				nums[i] = Integer.parseInt(st.nextToken());	// 분리된 입력 값 저장
			}
			
			max = Integer.MIN_VALUE;	// max는 Integer의 최소값으로 초기화
			min = Integer.MAX_VALUE;	// min은 Integer의 최대값으로 초기화
			
			perm(0, new int[N-1]);	// idx 0, operSelect 배열 객체 생성하며 재귀 함수 실행
			sb.append(max-min).append("\n");	// 문제에서 원하는 출력값 max-min 저장
		}
		System.out.println(sb);	// sb 출력
	}
	
	static void perm(int idx, int[] operSelect) {
		if(idx == N - 1) {	// 기저 조건 : 고른 연산자의 개수가 N-1
			int temp = nums[0];	// nums[0]을 시작으로 연산함.
			for(int i = 0; i < N - 1; i++) {	// 연산자의 개수만큼 반복 N-1번
				if(operSelect[i] == 0) {	// + 의미
					temp += nums[i + 1];	// + 연산
				} else if(operSelect[i] == 1) {	// - 의미
					temp -= nums[i + 1];		// - 연산
				} else if(operSelect[i] == 2) {	// * 의미
					temp *= nums[i + 1];		// * 연산
				} else if(operSelect[i] == 3) {	// / 의미
					temp /= nums[i + 1];		// / 연산
				}
			}
			max = Math.max(max, temp);
			min = Math.min(min, temp);
			return;
		}
		
		// 연산자의 종류만큼 반복
		for(int i = 0; i < 4; i++) {
			if(oper[i] == 0) continue;	// 연산자의 개수가 0이면 선택할 수 없으므로 다음 반복문 실행
			operSelect[idx] = i;	// 매개변수인 operSelect에 i 저장 -> 어떤 연산자인지 알기 위해서 i를 저장한다.
			oper[i]--;	// 한 개를 선택했으므로 하나 줄임.
			perm(idx + 1, operSelect);	// 다음 재귀 실행
			oper[i]++;	// 다음 반복문을 위해 줄였던 값 다시 증가(복구)
		}
	}
}