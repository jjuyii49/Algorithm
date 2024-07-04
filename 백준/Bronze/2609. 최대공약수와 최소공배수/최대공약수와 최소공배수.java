import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
        int r, aa = 0, bb = 0;
        
        if(a % b == 0) r = b;
        else {
            r = a % b;
		    aa = b;
		    bb = r;
		
		    while(true) {
			    if(aa % bb == 0) break;
			    r = aa % bb;
			    aa = bb;
			    bb = r;      
		    }
        }
		
		System.out.println(r);
		System.out.println(a * b / r);
	}

}
