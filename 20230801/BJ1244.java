import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo01_BJ1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// BufferedReader 선언
		int n = Integer.parseInt(br.readLine());	// 스위치 개수를 n으로 입력
		String[] status = br.readLine().split(" ");	// 스위치 상태를 status 배열로 입력
		int num = Integer.parseInt(br.readLine());	// 학생 수를 num으로 입력
		
		for(int i = 0; i < num; i++) {									// 학생 수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());	// StringTokenizer 사용
			int gender = Integer.parseInt(st.nextToken());				// 입력값을 공백으로 나누어서 gender와 idx로 입력
			int idx = Integer.parseInt(st.nextToken());					// 입력값을 공백으로 나누어서 gender와 idx로 입력
			if(gender == 1) {											// gender가 1일 때, 남학생일 때
				for(int j = 0; j < n; j++) {							// 스위치 개수만큼 반복
					if((j + 1) % idx == 0) {							// 남학생이 받은 스위치 번호의 배수 찾기(j가 0부터 시작하므로 +1 해준다.)
						if(status[j].equals("0")) status[j] = "1";		// 스위치 상태가 0이면 1로 변경
						else if(status[j].equals("1")) status[j] = "0";	// 스위치 상태가 1이면 0으로 변경
					}
				}
			}
			else {									// gender가 1이 아닐 때, 여학생일 때
				idx--;								// status 배열은 0부터 시작하므로 idx를 1 줄임.
				int idxl = idx - 1, idxr = idx + 1;	// idx의 왼쪽을 확인할 idxl, 오른쪽을 확인할 idxr 생성
				while(true) {						// while 반복
					if(idxl < 0 || idxr >= n || !status[idxl].equals(status[idxr])) {	// idxl와 idxr이 인덱스를 벗어나거나 idxl과 idxr 인덱스의 status가 같지 않을 때
						idxl++;						// idxl과 idxr을 이전 인덱스로 돌려놓음
						idxr--;						// idxl과 idxr을 이전 인덱스로 돌려놓음
						break;						// while 탈출
					}
					
					idxl--;							// idxl--로 왼쪽으로 한 칸 더 이동
					idxr++;							// idxr++로 오른쪽으로 한 칸 더 이동
				}
				
				for(int j = idxl; j <= idxr; j++) {					// idxl부터 idxr까지 반복
					if(status[j].equals("0")) status[j] = "1";		// status가 0이면 1로 변경
					else if(status[j].equals("1")) status[j] = "0";	// status가 1이면 0으로 변경
				}

			}
			
		}
		int count = 0;					// 출력 개수를 세기 위한 변수 count 생성
		for(int i = 0; i < n; i++) {	// 스위치 개수만큼 반복
			if(count == 20) {			// 출력된 개수가 20이면
				System.out.println();	// 줄바꿈
				count = 0;				// 다시 0으로 초기화
			}
			System.out.print(status[i] + " ");	// status 출력
			count++;							// count 증가
		}
		
	}

}
