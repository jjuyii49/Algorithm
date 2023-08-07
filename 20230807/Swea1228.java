import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader 선언
		StringBuilder sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder 선언
		
		for(int tc = 1; tc <= 10; tc++) {	// 테스트케이스만큼 반복(10번)
			sb.append("#").append(tc).append(" ");	// 출력 양식
			
			int N = Integer.parseInt(br.readLine());	// 원본 암호문의 길이 N 입력
			
			ArrayList<String> list = new ArrayList<>();	// 원본 암호문을 저장할 ArrayList 선언
			StringTokenizer st = new StringTokenizer(br.readLine());	// 공백으로 구분하기 위해 StringTokenizer 선언
			for(int i = 0; i < N; i++) {	// 암호문의 길이만큼 반복 N번
				list.add(st.nextToken());	// ArrayList에 추가
			}
			int M = Integer.parseInt(br.readLine());	// 명령어의 개수 M 입력
			
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력 받아 공백으로 구분하기
			for(int i = 0; i < M; i++) {	// 명령어의 개수만큼 반복 M번
				String temp = st.nextToken();	// 공백으로 구분한 값 temp에 저장
				
				if(temp.equals("I")) {	// temp가 "I"이면 명령문 시작
					int idx = Integer.parseInt(st.nextToken());	// 명령문 규칙에 따라 I 다음 값은 삽입될 위치 -> idx에 저장
					int count = Integer.parseInt(st.nextToken());	// 명령문 규칙에 따라 삽입될 위치 다음 값은 추가할 숫자의 개수 -> count에 저장
					
					for(int j = 0; j < count; j++) {	// count만큼 반복
						list.add(idx++, st.nextToken());	// list의 인덱스에 숫자 삽입 -> 다음 숫자는 원래 삽입 위치보다 +1인 위치에 삽입되므로 idx++을 사용
					}
				}
			}
			
			for(int i = 0; i < 10; i++) {	// 처음 10개 항을 출력해야 하므로 10번 반복
				sb.append(list.get(i)).append(" ");	// sb에 list의 값 저장
			}
			sb.append("\n");	// 10개 저장 후 줄바꿈
		}
		
		System.out.println(sb);	// sb 출력
	}

}
