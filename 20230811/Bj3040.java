import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 *  Bj3040 : 백설공주와 일곱 난쟁이
 *  9개의 숫자 중 합이 100이 되는 7개의 숫자 찾아서 출력
 *  9개 중 7개를 뽑고 순서가 중요하지 않으므로 조합 문제
 */
public class Bj3040 {

	static int[] num;	// 주어진 숫자를 저장할 배열 num
	static int[] result;	// 조합으로 만들어진 7개의 숫자를 저장할 배열 result
	static StringBuilder sb;	// 빠른 출력을 위한 StringBuilder
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
		sb = new StringBuilder();	// StringBuilder 객체 생성
		
		num = new int[9];	// num 배열 객체 생성. 크기는 9개
		
		for(int i = 0; i < 9; i++) {	// 9번 반복
			num[i] = Integer.parseInt(br.readLine());	// 입력값 num 배열에 저장
		}
		
		result = new int[7];	// result 배열 객체 생성. 크기 7개
		
		comb(0, 0, 0);	// 조합 메소드 실행. 첫 시작이므로 idx 0, start 0, sum 0
		
		System.out.println(sb);	// sb 출력
	}
	
	static void comb(int idx, int start, int sum) {	// 조합 메소드
		if(idx == 7) {	// 7개를 뽑는 것이므로 idx가 7이 될 때가 기저 조건
			if(sum == 100) {	// sum이 100이면 문제에서 찾는 수
				for(int i = 0; i < 7; i++) {	// 7번 반복하면서
					sb.append(result[i]).append("\n");	// sb에 저장
				}
			}
			return;	// 메소드 종료
		}
		
		for(int i = start; i < 9; i++) {	// 9번 반복하면서 조합 생성
			result[idx] = num[i];	// 뽑은 수 저장
			comb(idx + 1, i + 1, sum + num[i]);	// 다음 수 뽑으면서 뽑은 수의 합도 같이 처리.
		}
	}

}
