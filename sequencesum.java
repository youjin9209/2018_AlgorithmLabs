/*
Algorithm JOBS Extra course 3
6. 준혁이의 수열 
문제 : 두항의 합만 주어진걸로 각 항의 값 구하기 
풀이 : 행끼리 더해
주의 : 나누는 수 규칙찾아서 일반항으로 넣기 ! - 하드코딩 노노 
*/
import java.util.Scanner;

public class sequencesum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] a = new long[N+2][N+2];
		long totalSum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				a[i][j] = sc.nextInt();
				if (i != j)
					totalSum += a[i][j];
			}
		}
		
		totalSum /= (2*N-2);
		long[] d = new long[N+1];
		for (int i = 1; i <= N; i++) {
			long rowSum = 0;
			for (int j = 1; j <= N; j++) {
				if (i != j)
					rowSum += a[i][j];
			}
			d[i] = (rowSum - totalSum) / (N-2);
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(d[i] + " ");
		}
	}
}
