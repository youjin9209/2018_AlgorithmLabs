/*
Algorithm JOBS Extra course 2

6. 색종이
문제 풀이 : 각 순서마다의 사각형에 idx 를 박는다 -> 나중껄로 덮어씌워지겠지 !! 
해결 : (1) 각 idx 마다 개수를 담을배열 선언 !! -> 세어 놓은걸 담는다 
*/
import java.util.Scanner;

public class colorpaper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		int[] cnt = new int[101];
		int sx, sy;
		int dx, dy;
		for (int i = 1; i <= N; i++) {
			sx = sc.nextInt();
			sy = sc.nextInt();
			dx = sc.nextInt();
			dy = sc.nextInt();
			dx += sx;
			dy += sy;
			for (int p = sx; p < dx; p++) {
				for (int q = sy; q < dy; q++) {
					map[p][q] = i;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				cnt[map[i][j]]++;
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(cnt[i]);
		}
	}
}
