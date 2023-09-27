import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 *  Bj1931 : 회의실 배정
 *  회의 N개
 *  시작 시간과 끝나는 시간이 주어질 때 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대 개수 찾기
 */
public class Bj1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력 받기 위한 BufferedReader 선언
		int N = Integer.parseInt(br.readLine());	// 회의 개수 N 입력 받기
		PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {	// 회의 시간을 입력 받으면서 바로 정렬하기 위해서 PriorityQueue를 사용
																					// 내가 원하는대로 정렬하기 위해서 Comparator 사용
			@Override
			public int compare(Meeting o1, Meeting o2) {	// compare 메소드 재정의
				if(o1.end == o2.end) return o1.start - o2.start;	// 끝나는 시간이 동일하면 시작 시간 순으로 정렬 (오름차순)
				
				return o1.end - o2.end;	// 끝나는 시간 순으로 정렬 (오름차순)
			}
		});
		
		StringTokenizer st = null;	// 공백으로 분리하기 위하여 StringTokenizer 선언
		for(int i = 0; i < N; i++) {	// N번 반복하면서 입력 받기
			st = new StringTokenizer(br.readLine());	// 한 줄 입력 받아서 공백 기준으로 분리
			int start = Integer.parseInt(st.nextToken());	// 첫 번째 입력값 start
			int end = Integer.parseInt(st.nextToken());		// 두 번째 입력값 end
			pq.offer(new Meeting(start, end));	// pq에 추가
		}
		
		Meeting current = pq.poll();	// 첫 번째 회의 선택하여 current에 저장
		int count = 1;	// 첫 번째 회의 선택했으므로 count 1부터 시작
		
		for(int i = 0; i < pq.size(); i++) {	// pq.size()만큼 반복 -> isempty로 해도 될 것 같다
			if(pq.peek().start < current.end) pq.poll();	// pq의 첫번째 Meeting의 시작 시간이 현재 Meeting의 끝나는 시간보다 작으면 회의 시간이 겹치는 것. -> 그냥 뽑아냄
			else {	// 시간이 겹치지 않으면
				current = pq.poll();	// 다음 pq 탐색 시 비교하기 위해 그 값을 뽑아서 current에 저장 
				count++;	// 선택했으므로 count 증가
			}
			i--;	// pq에서 값을 빼냈으므로 i 감소
		}
		
		// isEmpty()로 해도 된다!
		// 내용은 for문과 동일
//		while(!pq.isEmpty()) {
//			if(pq.peek().start < current.end) pq.poll();
//			else {
//				current = pq.poll();
//				count++;
//			}
//		}
		
		System.out.println(count);	// count 출력
	}

}

class Meeting{	// 회의의 시작 시간과 끝나는 시간을 함께 관리하기 위해 클래스 생성
	int start;	// 멤버변수로 start
	int end;	// 멤버변수로 end
	
	public Meeting(int start, int end) {	// start와 end를 매개변수로 갖는 생성자로 start 값과 end 값 저장 
		this.start = start;	// start 멤버 변수에 저장
		this.end = end;		// end 멤버 변수에 저장
	}
	
}
