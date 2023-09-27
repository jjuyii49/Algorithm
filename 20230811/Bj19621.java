import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 *  Bj19621 : 회의실 배정 2
 *  
 */
public class Bj19621 {

	static int N;
	static Meeting[] meet;
	static boolean[] v;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		meet = new Meeting[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int start = Integer.parseInt(st.nextToken());
			 int end = Integer.parseInt(st.nextToken());
			 int people = Integer.parseInt(st.nextToken());
			
			 meet[i] = new Meeting(start, end, people);
			 
		}
		
		v = new boolean[N];
		
		powerset(0);
		
		System.out.println(max);
	}
	
	static void powerset(int idx) {
		if(idx == N) {
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				if(v[i]) sum += meet[i].people;
			}
			
			max = Math.max(max, sum);
			
			return;
		}
		
		if(idx >= 1) {
			if(v[idx - 1]) {
				v[idx] = false;
				powerset(idx + 1);
				v[idx] = true;
			}
			else {
				v[idx] = true;
				powerset(idx + 1);
				v[idx] = false;
				powerset(idx + 1);
			}
		}
		else {
			v[idx] = true;
			powerset(idx + 1);
			v[idx] = false;
			powerset(idx + 1);
		}
	}

}

class Meeting {
	int start;
	int end;
	int people;
	
	public Meeting(int start, int end, int people) {
		this.start = start;
		this.end = end;
		this.people = people;
	}
}