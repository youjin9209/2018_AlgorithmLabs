/*
Algorithm JOBS Extra course 2

5. 사거리 
문제 : x를 중심으로 사거리 디펜스 만들기 
풀이 : point증가시키면서 완전탐색 ! 
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair {
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class attackrange {
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static void bfs(boolean[][] check, int N, String[][] map, int X, int Y, int R) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(X, Y));
		check[X][Y] = true;
		int point = 1;
		while (point < R+1) {
			Pair p = queue.remove();
			int x = p.x;
			int y = p.y;
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
					if (check[nx][ny] == false && map[nx][ny].equals("0")) {
						queue.add(new Pair(nx, ny));
						check[nx][ny] = true;
						if (point > 1) {
							point = Integer.parseInt(map[x][y]) + 1;
							if (point > R)
								return;
							map[nx][ny] = Integer.toString(point);
						} else if (point == 1) {
							map[nx][ny] = Integer.toString(1);
						}
					}
				}
			}
			if (point == 1)
				point++;
		}
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int R = sc.nextInt();
		String[][] map = new String[N+2][N+2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == X && j == Y)
					map[i][j] = "x";
				else 
					map[i][j] = Integer.toString(0);
			}
		}
		boolean[][] check = new boolean[N+2][N+2];
		bfs(check, N, map, X, Y, R);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
