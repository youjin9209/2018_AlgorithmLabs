/*
Algorithm JOBS Extra course 4
6. 단지번호 붙이기
문제 : 단지 개수 출력 및 단지에 해당하는 집 개수 오름차순으로 출력 
풀이 : bfs 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class danji {
	public static int cnt = 0; // 단지 개수 
	public static int[] danjiCnt; // 각 단지별 집의 수 
	public static boolean[][] check; // 방문 여부 check 
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[][] map;
	public static void bfs(int a, int b, int N) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(a, b));
		check[a][b] = true;
		danjiCnt[cnt]++;
		while(!queue.isEmpty()) {
			Pair p = queue.remove();
			for (int i = 0; i <= 3; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (map[nx][ny] == 1 && !check[nx][ny]) {
						check[nx][ny] = true;
						danjiCnt[cnt]++;
						queue.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		danjiCnt = new int[25];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] token = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문 가능하고, 안가봤다면 
				if (map[i][j] == 1 && !check[i][j]) {
					cnt++;
					bfs(i,j,N);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		int[] temp = new int[cnt];
		for (int i = 1; i <= cnt; i++) {
			temp[i-1] = danjiCnt[i];
		}
		Arrays.sort(temp);
		
		for (int i = 0; i < cnt; i++) {
			sb.append(temp[i] + "\n");
		}
		System.out.println(sb);
	}
}
