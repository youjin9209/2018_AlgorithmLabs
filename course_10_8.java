/*
이전까지 최대 보장 - 어디서 부터 왔는가를 케이스로 나누기 
*/
import java.util.Scanner;

public class course_10_8 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		d = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 && j == 0)
					d[i][j] = map[i][j];
				else if (i == 0 && j >= 1)
					d[i][j] = d[i][j-1] + map[i][j];
				else if (j == 0 && i >= 1)
					d[i][j] = d[i-1][j] + map[i][j];
				else
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]) + map[i][j];
			}
		}
		System.out.println(d[N-1][M-1]);
	}
}
