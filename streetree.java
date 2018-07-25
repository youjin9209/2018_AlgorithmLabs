import java.util.Arrays;
import java.util.Scanner;

public class streetree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] a = new long[N+1];
		long[] dx = new long[N+1];
		long min = 1000000001;
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextLong();
			if (i >= 2) {
				dx[i] = a[i]-a[i-1];
				if (min > dx[i]) {
					min = dx[i];
				}
			}
		}
		long GCD = 0;
		
		for (long j = min; j >= 1; j--) {
			boolean flag = true;
			for (int i = 2; i <= N; i++) {
				if (dx[i] % j != 0) {
					flag = false;
					break;
				}	
			}
			if (flag) {
				GCD = j;
				break;
			}
		}
		long result = ((a[N]-a[1])/GCD + 1) - N;
		System.out.println(result);
	}
}
