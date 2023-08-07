import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15649 {
	static int n;
	static int m;
	static int[] nums;
	static boolean[] v;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 빠른 입력을 위한 BufferedReader br 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine());	// 공백으로 구분하여 입력 받기 위해 StringTokenizer st 객체 생성
		n = Integer.parseInt(st.nextToken());	// 
		m = Integer.parseInt(st.nextToken());
		nums = new int[m];
		
		v = new boolean[n + 1];
		
		sb = new StringBuilder();	// 빠른 출력을 위한 StringBuilder sb 생성
		perm(0);
	}
	
	static void perm(int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(nums[i]).append(" ");
			}
			System.out.println(sb);
			sb.delete(0, sb.length());
			return;
		}
		
		for(int i = 1; i < n + 1; i++) {
			if(v[i]) continue;
			nums[cnt] = i;
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}
}