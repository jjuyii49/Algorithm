import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo06_SWEA9229 {
	
	static int N;	// 과자 봉지의 개수 N
	static int M;	// 무게 제한 M
	static int[] weight;	// 과자 봉지의 무게를 저장할 배열
	static int sum;	// 고른 과자 봉지의 무게의 합을 저장할 변수
	static int max;	// 무게 제한 내에서 가장 큰 값을 저장할 변수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
		
		int TC = Integer.parseInt(br.readLine());	// 테스트 케이스 입력 받기
		StringTokenizer st;	// 공백으로 구분하여 입력 받기 위한 StringTokenizer 선언
		
		for(int t = 1; t < TC + 1; t++) {	// 테스트 케이스만큼 반복
			sb.append("#").append(t).append(" ");	// 출력 양식 저장
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력 받고 공백으로 나누기
			
			N = Integer.parseInt(st.nextToken());	// N 값 저장
			M = Integer.parseInt(st.nextToken());	// M 값 저장
			
			weight = new int[N];	// 무게 저장 배열 객체 생성
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력 받고 공백으로 나누기		
			for(int i = 0; i < N; i++) {	// 과자 개수만큼 반복 N번
				weight[i] = Integer.parseInt(st.nextToken());	// 무게 배열에 값 저장
			}
			
			sum = 0;	// 테스트 케이스마다 새로 시작해야하므로 재귀 함수 실행 전에 초기화
			max = -1;	// 테스트 케이스마다 새로 시작해야하므로 재귀 함수 실행 전에 초기화 (무게 제한 내의 가장 큰 값이 없을 경우 -1을 출력해야하므로 -1로 초기화)
			
			comb(0, 0);	// idx 0, count 0부터 시작
			sb.append(max).append("\n");	// sb에 max 값 저장
		}
		
		System.out.println(sb);	// sb 출력
	}
	
	// static void comb(int idx, int count) {	// 조합 메소드 생성 (재귀)
	// 	if(count == 2) {	// 과자는 2개밖에 고르지 못하므로 기저 조건으로 설정
	// 		if(sum > max) {	// 고른 과자 봉지의 무게 합이 max 보다 크고
	// 			if(sum <= M) max = sum;	// 무게 제한보다 작으면 max값을 sum으로 변경
	// 		}
	// 		return;	// 메소드 종료
	// 	}
		
	// 	// to do
	// 	for(int i = idx; i < N; i++) {	// 이미 고른 값은 다시 고를 수 없으므로 idx부터 N까지 반복
	// 		sum += weight[i];	// sum에 무게 더함
	// 		comb(i + 1, count + 1);	// 다음 재귀 실행
	// 		sum -= weight[i];	// 다음 반복문을 위해 이전에 더한 값 빼기(복구)
	// 	}
	// }

	// sum도 재귀 실행 시마다 계속 변경되는 값이므로 전역 변수로 선언 시 다음 재귀에 영향을 끼칠 수 있다.
	// 그래서 매개변수로 작성하는 게 좋다.
	static void comb(int idx, int count, int sum) {	// 조합 메소드 생성 (재귀)
		if(count == 2) {	// 과자는 2개밖에 고르지 못하므로 기저 조건으로 설정
			if(sum > max) {	// 고른 과자 봉지의 무게 합이 max 보다 크고
				if(sum <= M) max = sum;	// 무게 제한보다 작으면 max값을 sum으로 변경
			}
			return;	// 메소드 종료
		}
		
		// to do
		for(int i = idx; i < N; i++) {	// 이미 고른 값은 다시 고를 수 없으므로 idx부터 N까지 반복
			// sum += weight[i];	// sum에 무게 더함
			comb(i + 1, count + 1, sum + weight[i]);	// 다음 재귀 실행
			// sum -= weight[i];	// 다음 반복문을 위해 이전에 더한 값 빼기(복구)
		}
	}
}
