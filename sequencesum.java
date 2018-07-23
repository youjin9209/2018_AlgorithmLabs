import java.util.Scanner;

public class sequencesum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] a = new int[N+2][N+2];
		int totalSum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				a[i][j] = sc.nextInt();
				totalSum += a[i][j];
			}
		}
		
		totalSum /= 6;
		int[] d = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int rowSum = 0;
			for (int j = 1; j <= N; j++) {
				if (i != j)
					rowSum += a[i][j];
			}
			d[i] = (rowSum - totalSum) / 2;
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(d[i] + " ");
		}
	}

}
