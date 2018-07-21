import java.util.Scanner;

public class classpresident {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[1002][7];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[][] cnt = new int[N+2][N+2];
		for (int i = 1; i < N; i++) {
			for (int k = i+1; k <= N; k++) {
				for (int j = 1; j <= 5; j++) {
					if (map[i][j] == map[k][j]) {
						cnt[i][k] = 1;
						cnt[k][i] = 1;
					}
				}
			}
		}
		int max = -1;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			int c = 0;
			for (int j = 1; j <= N; j++) {
				if (cnt[i][j] == 1)
					c++;
			}
			if (max < c) {
				max = c;
				idx = i;
			}
		}
		System.out.println(idx);
	}
}
