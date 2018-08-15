/*
단지 번호 붙이기
- bfs로 다 체크 -> 번지에 해당하는거 ++;
*/
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class course_6_6 {
	static int N;
	static int[][] map;
	static boolean[][] check;
	static int[] cnt;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs (int x, int y, int idx) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		check[x][y] = true;
		cnt[idx]++;
		while(!queue.isEmpty()) {
			Point p = queue.remove();
			int px = p.x;
			int py = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (!check[nx][ny] && map[nx][ny] == 1) {
						queue.add(new Point(nx, ny));
						check[nx][ny] = true;
						cnt[idx]++;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		check = new boolean[N][N];
		cnt = new int[N+1];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j] && map[i][j] == 1) {
					idx++;
					bfs(i, j, idx);
				}
			}
		}
		Arrays.sort(cnt);
		System.out.println(idx);
		for (int i = N-(idx-1); i <= N; i++) {
			System.out.println(cnt[i]);
		}
	}
}
