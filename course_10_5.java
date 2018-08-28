/*
1) 인접한거 못쓸 때
2) 직전까지 최대 
*/
import java.util.Scanner;

public class course_10_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[][] d = new int[N][3];
		for (int i = 0; i < 3; i++) {
			d[0][i] = map[0][i];
		}
		for (int i = 1; i < N; i++) {
			d[i][0] = Math.max(d[i-1][1], d[i-1][2]) + map[i][0];
			d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + map[i][1];
			d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + map[i][2];
		}
		int result = 0;
		result = Math.max(d[N-1][2], Math.max(d[N-1][0], d[N-1][1]));
		System.out.println(result);
	}
}
