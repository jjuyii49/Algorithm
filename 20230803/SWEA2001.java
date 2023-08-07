import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class hwalgo03_SWEA2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader br 객체 생성
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 횟수 입력 받음
		
		StringBuilder sb = new StringBuilder();		// 빠른 출력을 위한 StringBuilder sb 객체 생성
		
		for(int tc = 1; tc <= T; tc++) {			// 테스트 케이스만큼 반복
			
			sb.append("#").append(tc).append(" ");	// sb에 출력 양식 저장
			
			StringTokenizer st = new StringTokenizer(br.readLine());	// 공백으로 분리하여 입력 받기 위한 StringTokenizer st 객체 생성
			int N = Integer.parseInt(st.nextToken());					// 배열의 크기를  N으로 입력 받음
			int M = Integer.parseInt(st.nextToken());					// 파리채의 크기를 M으로 입력 받음
			
			int[][] sumArr = new int[N + 1][N + 1];						// 파리 개수의 구간합을 저장할 합배열 sumArr 생성
			
			for(int i = 1; i < N + 1; i++) {				// 1차원 인덱스를 1부터 배열 크기 + 1까지 반복
				st = new StringTokenizer(br.readLine());	// 공백으로 분리하여 입력받기 위해서 StringTokenizer 새로 생성 
				for(int j = 1; j < N + 1; j++) {			// 2차원 인덱스를 1부터 배열 크기 + 1까지 반복
					int temp = Integer.parseInt(st.nextToken());	// 입력값을 temp 변수에 임시 저장
					sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + temp;	// 구간합을 구해서 sumArr에 저장
				}
			}
			ArrayList<Integer> sumList = new ArrayList<>();	// 파리채의 크기만큼의 합을 저장할 sumList 객체 생성
			for(int i = M; i < N + 1; i++) {				// 1차원 인덱스 파리채의 크기부터 시작하여 배열 크기 + 1까지 반복
				for(int j = M; j < N + 1; j++) {			// 2차원 인덱스 파리채의 크기부터 시작하여 배열 크기 + 1까지 반복
					sumList.add(sumArr[i][j] - sumArr[i - M][j] - sumArr[i][j - M] + sumArr[i - M][j - M]); // 파리채의 크기만큼 구간합을 구해서 sumList에 추가
				}
			}
			
			sb.append(Collections.max(sumList)).append("\n");	// Collections.max를 사용하여 sumList의 최댓값을 sb에 추가
		}
		System.out.println(sb);	// sb 출력
	}

}
