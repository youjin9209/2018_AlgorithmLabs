/*
해결 : tree 의 level별로 출력해주는 거니까 BFS !
- 4등분한 시작좌표 (startx, starty, endx, endy) 를 Queue에 넣어준다.
- 해당 영역에서 모든 좌표가 같은지, 아닌지를 판단하는거는 시작좌표를 하나 저장해놓고 일일히 for문으로 비교하면 됨 ! 
- 4등부하는 길이 : endx - startx 겠지 !
- 다르면 4등분한거 넣어주고
- 다 같으면 시키는대로 append 
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
class Point4 {
	int startX, startY;
	int endX, endY;
	Point4 (int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
} 
public class course_6_10 {
	static int[][] map;
	static boolean[][] check;
	static int N;
	public static String bfs(int startX, int startY, int endX, int endY) {
		Queue<Point4> queue = new LinkedList<Point4>();
		queue.add(new Point4(startX, startY, endX, endY));
		check[startX][startY] = true;
		StringBuilder sb = new StringBuilder();
		String result = "";
		while(!queue.isEmpty()) {
			Point4 point = queue.remove();
			int sx = point.startX;
			int sy = point.startY;
			int ex = point.endX;
			int ey = point.endY;
			int startPoint = map[sx][sy];
			// 좌표 체크해주는건 그냥 반복문으로 돌리기 
			boolean flag = true;
			for (int i = sx; i <= ex; i++) {
				for (int j = sy; j <= ey; j++) {
					if (startPoint != map[i][j]) {
						flag = false;
						// 4 등분한 좌표 넣어주기 
						for (int k = 1; k <= 4; k++) {
							int nsx, nsy, nex, ney;
							if (k == 1) {  // 1
								nsx = sx;
								nsy = sy;
								nex = nsx + (ex - sx + 1)/2 - 1;
								ney = nsy + (ex - sx + 1)/2 - 1;
							} else if (k == 2) { // 2
								nsx = sx;
								nsy = sy + (ex - sx + 1)/2;
								nex = nsx + (ex - sx + 1)/2 - 1;
								ney = nsy + (ex - sx + 1)/2 - 1;
							} else if (k == 3) { // 3
								nsx = sx + (ex - sx + 1)/2;
								nsy = sy;
								nex = nsx + (ex - sx + 1)/2 - 1;
								ney = nsy + (ex - sx + 1)/2 - 1;
							} else { // 4
								nsx = sx + (ex - sx + 1)/2;
								nsy = sy + (ex - sx + 1)/2;
								nex = nsx + (ex - sx + 1)/2 - 1;
								ney = nsy + (ex - sx + 1)/2 - 1;
							}
							queue.add(new Point4(nsx, nsy, nex, ney));
						}
						break;
					}
				}
				if (!flag) {
					sb.append(1);
					break;
				}
			}
			if (flag) {
				if (ex == N-1 && ey == N-1 && sx == startX && sy == startY) {
					sb.append(0);
				} else {
					int num = map[sx][sy]; // 어짜피 다 똑같을 거니까 임의로 하나 넣어줌 
					sb.append(0).append(num);
				}
			}
			
		}
		result = sb.toString();
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		check = new boolean[N][N];
		String result = "";
		result = bfs(0, 0, N-1, N-1);
		int len = result.length();
		String ans = "";
		for (int i = len; i >= 0; i -= 4) {
			 if (i-4 >= 0) {
				 String p = result.substring(i-4, i);
				 int a = Integer.parseInt(p, 2);
				 ans += Integer.toHexString(a).toUpperCase();
			 } else {
				 String add = "";
				 for (int k = 0; k < 4-i; k++) {
					 add += "0";
				 }
				 String p = add + result.substring(0, i);
				 int a = Integer.parseInt(p,  2);
				 ans += Integer.toHexString(a);
			 }
		}
		int ansLen = ans.length();
		for (int i = ansLen-1; i >= 0; i--) {
			System.out.print(ans.charAt(i));
		}
	}
}
