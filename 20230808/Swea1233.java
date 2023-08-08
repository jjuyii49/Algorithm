import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Swea1233 : 사칙연산 유효성 검사
 * 
 */
//public class Swea1233 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
//		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
//		
//		 for(int t = 1; t <= 10; t++) {	// 테스트 케이스 10번 반복
//			 sb.append("#").append(t).append(" ");	// 출력 양식
//			 int N = Integer.parseInt(br.readLine());	// N 입력 받기
//			 boolean check = false;	// 유효성을 저장할 boolean 선언
//			 String[] input;	// 주어진 입력을 저장할 Strng[] 선언
//			 
//			 for(int i = 0; i < N; i++) {	// N번 반복
//				 input = br.readLine().split(" ");	// 한 줄을 공백으로 분리하여 입력 받기
//				 if(input.length > 2) continue;	// 배열의 크기가 2보다 크면 자식 노드가 있다는 것이므로 다음 반복문 실행
//				 
//				 if(input[1].equals("+") || input[1].equals("-") || input[1].equals("*") || input[1].equals("/")) {	// 입력값의 2번째가 연산자이면
//					 check = false;	// 마지막 노드가 연산자이므로 false.
//					 for(int j = i + 1; j < N; j++) {	// 이후에 남은 입력을 처리하기 위한 반복문, i + 1부터 N까지 반복
//						 br.readLine();	// 입력 읽기
//					 }
//					 break;	// 반복문 탈출
//				 }
//				 else check = true;	// 숫자이면 true
//			 }
//			 
//			 if(check) sb.append(1).append("\n");	// check가 true이면 유효한 계산식이므로 1 출력
//			 else sb.append(0).append("\n");		// check가 false이면 유효하지 않은 계산식이므로 0 출력
//		 }
//		 
//		 System.out.println(sb);	// sb 출력
//
//	}
//
//}

public class Swea1233 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
		
		for(int t = 1; t < 11; t++) {	// 테스트 케이스 10번 반복
			int N = Integer.parseInt(br.readLine());	// N 입력 받기
			boolean[] tree = new boolean[N + 1];	// 트리를 1차원 배열로 선언하여 사용(boolean으로 선언하여 연산자면 true, 숫자면 false)
			
			for(int i = 1; i < N + 1; i++) {	// tree 배열에 1부터 저장하므로 1부터 N까지 반복
				String[] input = br.readLine().split(" ");	// 한 줄을 공백으로 구분하여 입력 받기
				// 2번째 문자가 연산자이거나 숫자이므로 input[1]만 확인.
				if(input[1].equals("+") || input[1].equals("-") || input[1].equals("*") || input[1].equals("/"))	// 연산자이면
					tree[i] = true;	// tree[i]에 true 저장
				else tree[i] = false;	// 숫자이면 false 저장
			}
			
			int idx = N;	// 제일 마지막 노드부터 확인하기 위해 idx를 N으로 선언
			int cnt = 0;	// 방문한 노드의 수를 확인하기 위해 cnt 선언
			while(idx > 0) {	// idx가 루트 노드일 때까지 반복
				if(!(tree[idx]) && !(tree[idx - 1])) {	// 마지막 노드와 그 형제 노드가 숫자이고
					if(tree[idx / 2]) {	// 부모 노드가 연산자이면
						tree[idx / 2] = false;	// 숫자 노드가 계산되어 다시 숫자가 되므로 부모 노드가 숫자가 된다.(false로 변경)
						cnt += 2;		// 방문한 노드의 수 2개 증가
					}
					else break;	// 부모 노드가 숫자이면 계산식이 유효하지 않기 때문에 반복문을 탈출
				}
				idx -= 2;	// 다음으로 확인할 노드는 idx - 2.
			}
			
			sb.append("#").append(t).append(" ").append(cnt == N-1? 1:0).append("\n");	// 출력 양식 및 방문한 노드의 수가 N-1(루트 제외)과 같으면 반복문 중간에 탈출이 없었던 것. -> 유효한 계산식이므로 1 출력
																						//                                    같지 않으면 반복문 중간에 탈출한 것. -> 유효하지 않은 계산식 0 출력
			
		}
		
		System.out.println(sb);	// sb 출력
	}
}
