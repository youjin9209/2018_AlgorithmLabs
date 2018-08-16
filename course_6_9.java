/*
  boolean check[] 가 있으면 벽을 안깨고 돌아온 애들이 방문을 못한다 !!
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point3 {
	int x, y, z;
	Point3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z; // broken flag -> 0 : not broken / 1: broken
	}
}
public class course_6_9 {
	static int N; 
	static int M;
	static int[][] map;
	static int[][][] dist;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void bfs(int startX, int startY, int flag) {
		Queue<Point3> queue = new LinkedList<Point3>();
		queue.add(new Point3(startX, startY, flag));
		dist[startX][startY][flag] = 0;
		while (!queue.isEmpty()) {
			Point3 p = queue.remove();
			int px = p.x;
			int py = p.y;
			int pz = p.z;
			if (px == endX && py == endY) {
				System.out.println(dist[px][py][pz]);
				System.exit(0);
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				int nz = pz;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 0 && dist[nx][ny][nz] == -1) {
						queue.add(new Point3(nx, ny, nz));
						dist[nx][ny][nz] = dist[px][py][pz] + 1;
					}
					if (map[nx][ny] == 1 && pz == 0 && dist[nx][ny][nz] == -1) { // 벽일 때 - 한번도 안깼어야 함 
						queue.add(new Point3(nx, ny, 1));
						dist[nx][ny][1] = dist[px][py][pz] + 1;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M][2];
		startX = N - 1;
		startY = 0;
		endX = 0;
		endY = M - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				for (int k = 0; k < dist[i][j].length; k++) {
					dist[i][j][k] = -1;
				}
			}
		}
		bfs(startX, startY, 0);
	}
}
